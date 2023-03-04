package com.example.Book_My_Show_Custom.EntrryDtos;

import com.example.Book_My_Show_Custom.Entities.MovieEntity;
import com.example.Book_My_Show_Custom.Entities.TheatreEntity;
import com.example.Book_My_Show_Custom.Enums.ShowType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private ShowType showType;

    private int theatreId;

    private int movieId;

    private int classicSeatPrice;

    private int premiumSeatPrice;
}
