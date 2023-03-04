package com.example.Book_My_Show_Custom.Convertors;

import com.example.Book_My_Show_Custom.Entities.MovieEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.MovieEntryDto;
import com.example.Book_My_Show_Custom.ResponseDtos.MovieResponseDto;

public class MovieConvertors {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder().movieName(movieEntryDto.getMovieName()).
                rating(movieEntryDto.getRating()).duration(movieEntryDto.getDuration()).
                language(movieEntryDto.getLanguage()).genre(movieEntryDto.getGenre()).build();

        return movieEntity;
    }

    public static MovieResponseDto convertEntityToResponse(MovieEntity movieEntity){
        return MovieResponseDto.builder().movieName(movieEntity.getMovieName())
                .rating(movieEntity.getRating()).duration(movieEntity.getDuration())
                .language(movieEntity.getLanguage()).genre(movieEntity.getGenre()).build();

    }
}
