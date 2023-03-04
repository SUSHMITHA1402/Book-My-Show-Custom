package com.example.Book_My_Show_Custom.Services;

import com.example.Book_My_Show_Custom.Convertors.MovieConvertors;
import com.example.Book_My_Show_Custom.Entities.MovieEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.MovieEntryDto;
import com.example.Book_My_Show_Custom.Repositories.MovieRepository;
import com.example.Book_My_Show_Custom.ResponseDtos.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie added Successfully";
    }

    public MovieResponseDto getMovie(int movieId){
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        return MovieConvertors.convertEntityToResponse(movieEntity);
    }

    public List<MovieResponseDto> getAllMovies(){
        List<MovieResponseDto> responseMovies = new ArrayList<>();
        List<MovieEntity> movies = movieRepository.findAll();
        for(MovieEntity movie:movies){
            responseMovies.add(MovieConvertors.convertEntityToResponse(movie));
        }
        return responseMovies;
    }

    public String getMaxShowsMovie(){
        List<MovieEntity> movies = movieRepository.findAll();
        String popularMovie="";
        int max =0;
        for(MovieEntity movie:movies){
            if(movie.getShowEntityList().size()>max){
                max = movie.getShowEntityList().size();
                popularMovie = movie.getMovieName();
            }
        }
        return popularMovie;
    }
}
