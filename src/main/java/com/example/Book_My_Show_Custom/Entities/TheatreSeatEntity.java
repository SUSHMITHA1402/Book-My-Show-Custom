package com.example.Book_My_Show_Custom.Entities;

import com.example.Book_My_Show_Custom.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;
}
