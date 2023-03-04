package com.example.Book_My_Show_Custom.Controllers;

import com.example.Book_My_Show_Custom.Entities.TheatreEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.ShowEntryDto;
import com.example.Book_My_Show_Custom.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try {
            String response  = showService.addShow(showEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String error = "Show Not added";
            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_showtime")
    public List<LocalTime> getShowTimes(@RequestParam("movie") String movieName, @RequestParam("Theatre") String theatreName){
        return showService.getShowTimings(movieName,theatreName);
    }

    @GetMapping("/get_theatres_at_showtime")
    public List<String> getTheatresListAtShowTime(@RequestParam("time") LocalTime time){
        return  showService.getTheatresAtShowTime(time);
    }
}
