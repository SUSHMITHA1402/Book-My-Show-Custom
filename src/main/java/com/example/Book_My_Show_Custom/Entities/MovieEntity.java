package com.example.Book_My_Show_Custom.Entities;

import com.example.Book_My_Show_Custom.Enums.Genre;
import com.example.Book_My_Show_Custom.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    // Movie is parent wrt the shows

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();


}
