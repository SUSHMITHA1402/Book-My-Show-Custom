package com.example.Book_My_Show_Custom.Controllers;

import com.example.Book_My_Show_Custom.EntrryDtos.TheatreEntryDto;
import com.example.Book_My_Show_Custom.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDto theatreEntryDto)throws Exception{
        try {
            String response = theatreService.addTheatre(theatreEntryDto);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
