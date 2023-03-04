package com.example.Book_My_Show_Custom.Convertors;

import com.example.Book_My_Show_Custom.Entities.TheatreEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.TheatreEntryDto;

public class TheatreConvertors {

    public static TheatreEntity convertEntryDtoToEntity(TheatreEntryDto theatreEntryDto){

        TheatreEntity theatreEntity = TheatreEntity.builder().name(theatreEntryDto.getName()).
                location(theatreEntryDto.getLocation()).build();

        return theatreEntity;
    }
}
