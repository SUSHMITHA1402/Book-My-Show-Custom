package com.example.Book_My_Show_Custom.EntrryDtos;

import lombok.Data;

@Data
public class TheatreEntryDto {

    private String name;

    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
