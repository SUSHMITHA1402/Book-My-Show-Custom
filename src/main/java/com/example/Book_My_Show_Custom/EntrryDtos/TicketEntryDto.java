package com.example.Book_My_Show_Custom.EntrryDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class TicketEntryDto {

    private int showId;

    private int userId;

    private List<String> requestedSeats = new ArrayList<>();

}
