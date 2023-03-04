package com.example.Book_My_Show_Custom.Controllers;

import com.example.Book_My_Show_Custom.EntrryDtos.TicketEntryDto;
import com.example.Book_My_Show_Custom.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("/book")
    public String bookTicket(@RequestBody TicketEntryDto ticketEntryDto)throws Exception{
        try {
            return ticketService.addTicket(ticketEntryDto);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
