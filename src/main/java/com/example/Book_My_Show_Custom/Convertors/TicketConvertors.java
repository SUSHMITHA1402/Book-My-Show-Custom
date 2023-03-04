package com.example.Book_My_Show_Custom.Convertors;


import com.example.Book_My_Show_Custom.Entities.TicketEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.TicketEntryDto;

public class TicketConvertors {

    public static TicketEntity convertEntryDtoToEntity(TicketEntryDto ticketEntryDto){

        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
