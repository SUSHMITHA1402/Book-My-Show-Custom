package com.example.Book_My_Show_Custom.Convertors;

import com.example.Book_My_Show_Custom.Entities.ShowEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.ShowEntryDto;

public class ShowConvertors {

    public static ShowEntity convertEntryDtoToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity = ShowEntity.builder()
                .showTime(showEntryDto.getShowTime())
                .showDate(showEntryDto.getShowDate())
                .showType(showEntryDto.getShowType())
                .build();
        return showEntity;
    }
}
