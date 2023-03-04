package com.example.Book_My_Show_Custom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private String theatreName;

    private LocalDate showDate;

    private LocalTime showTime;

    private String bookedSeats;

    private String ticketId = UUID.randomUUID().toString();

    private int totalAmount;

    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    // Ticket is child wrt to the shows
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
