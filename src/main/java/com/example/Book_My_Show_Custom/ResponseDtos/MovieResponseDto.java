package com.example.Book_My_Show_Custom.ResponseDtos;

import com.example.Book_My_Show_Custom.Enums.Genre;
import com.example.Book_My_Show_Custom.Enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDto {

    private String movieName;

    private double rating;

    private int duration;

    private Language language;

    private Genre genre;
}
