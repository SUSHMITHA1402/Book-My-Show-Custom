package com.example.Book_My_Show_Custom.Controllers;

import com.example.Book_My_Show_Custom.Entities.MovieEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.MovieEntryDto;
import com.example.Book_My_Show_Custom.ResponseDtos.MovieResponseDto;
import com.example.Book_My_Show_Custom.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody  MovieEntryDto movieEntryDto){
        try {
            String response = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "Movie not added";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_movie")
    public MovieResponseDto getMovieById(@RequestParam("id") int id){
        return movieService.getMovie(id);
    }
    @GetMapping("/get_all_movies")
    public List<MovieResponseDto> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/get_maxShows_movie")
    public String getMaxShowsMovie(){
        return movieService.getMaxShowsMovie();
    }
}
