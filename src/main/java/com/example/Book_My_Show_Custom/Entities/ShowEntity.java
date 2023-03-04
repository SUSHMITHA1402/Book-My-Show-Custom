package com.example.Book_My_Show_Custom.Entities;

import com.example.Book_My_Show_Custom.Enums.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    // Show is child wrt the theatre
    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;

    // Show is child wrt the movie
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    // Show is parent wrt the showSeats Entity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeats = new ArrayList<>();

    //Show is parent wrt the ticket
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfBookedTickets  = new ArrayList<>();

}
