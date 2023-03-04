package com.example.Book_My_Show_Custom.Services;

import com.example.Book_My_Show_Custom.Convertors.TheatreConvertors;
import com.example.Book_My_Show_Custom.Entities.TheatreEntity;
import com.example.Book_My_Show_Custom.Entities.TheatreSeatEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.TheatreEntryDto;
import com.example.Book_My_Show_Custom.Enums.SeatType;
import com.example.Book_My_Show_Custom.Repositories.TheatreRepository;
import com.example.Book_My_Show_Custom.Repositories.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(TheatreEntryDto theatreEntryDto) throws Exception{

        // Do some Validations
        if(theatreEntryDto.getName()==null || theatreEntryDto.getLocation()==null){
            throw new Exception("Name and Location should not be null");
        }

        TheatreEntity theatreEntity = TheatreConvertors.convertEntryDtoToEntity(theatreEntryDto);

        // set all its attributes

        List<TheatreSeatEntity> theatreSeatEntityList = createTheatreSeats(theatreEntryDto,theatreEntity);

        theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);

        theatreRepository.save(theatreEntity);

        return "Theatre Added Successfully";

    }

    private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDto theatreEntryDto,TheatreEntity theatreEntity){

        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

        int classicSeats = theatreEntryDto.getClassicSeatsCount();
        int premiumSeats = theatreEntryDto.getPremiumSeatsCount();

        //Create the classic Seats

        for (int count =1;count<=classicSeats;count++){

            // We need to make a new TheatreSeatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().seatType(SeatType.CLASSIC).
                    seatNo(count+"C").theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);

        }

        // Create the premium seats
        for (int count =1;count<=premiumSeats;count++){

            // We need to make a new TheatreSeatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().seatType(SeatType.PREMIUM).
                    seatNo(count+"P").theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);

        }

        // Not saving the child here
        return theatreSeatEntityList;

    }
}
