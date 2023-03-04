package com.example.Book_My_Show_Custom.EntrryDtos;

import com.example.Book_My_Show_Custom.Enums.Genre;
import com.example.Book_My_Show_Custom.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String movieName;

    private double rating;

    private int duration;

    private Language language;

    private Genre genre;
}
