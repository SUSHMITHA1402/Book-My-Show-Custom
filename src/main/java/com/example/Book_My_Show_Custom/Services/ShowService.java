package com.example.Book_My_Show_Custom.Services;

import com.example.Book_My_Show_Custom.Convertors.ShowConvertors;
import com.example.Book_My_Show_Custom.Entities.*;
import com.example.Book_My_Show_Custom.EntrryDtos.ShowEntryDto;
import com.example.Book_My_Show_Custom.Enums.SeatType;
import com.example.Book_My_Show_Custom.Repositories.MovieRepository;
import com.example.Book_My_Show_Custom.Repositories.ShowRepository;
import com.example.Book_My_Show_Custom.Repositories.ShowSeatRepository;
import com.example.Book_My_Show_Custom.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertors.convertEntryDtoToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theatreId = showEntryDto.getTheatreId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheatreEntity theatreEntity = theatreRepository.findById(theatreId).get();

        // Setting the attributes for the foreign keys
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);

        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setListOfShowSeats(showSeatEntityList);

        showRepository.save(showEntity);

        List<ShowEntity> showEntityList = theatreEntity.getShowEntityList();
        showEntityList.add(showEntity);
        theatreEntity.setShowEntityList(showEntityList);

       theatreRepository.save(theatreEntity);

        List<ShowEntity> showEntities = movieEntity.getShowEntityList();
        showEntities.add(showEntity);
        movieEntity.setShowEntityList(showEntities);

        movieRepository.save(movieEntity);

        return "Show Added Successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity){
        TheatreEntity theatreEntity = showEntity.getTheatreEntity();
        List<TheatreSeatEntity> theatreSeatEntityList = theatreEntity.getTheatreSeatEntityList();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for (TheatreSeatEntity theatreSeatEntity:theatreSeatEntityList){
            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
            showSeatEntity.setSeatNo(theatreSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatreSeatEntity.getSeatType());

            if(theatreSeatEntity.getSeatType().equals(SeatType.CLASSIC)){
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else{
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }
            showSeatEntity.setBooked(false);
            // foreign for the showSeat
            showSeatEntity.setShowEntity(showEntity);
            showSeatEntityList.add(showSeatEntity);
        }
        return showSeatEntityList;
    }

    public List<LocalTime> getShowTimings(String movieName, String theatreName){
        List<LocalTime> showsListOfMovieTheatre = new ArrayList<>();
        MovieEntity movieEntity = movieRepository.findByMovieName(movieName);
        TheatreEntity theatreEntity = theatreRepository.findByName(theatreName);
        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        for(ShowEntity show:showEntityList){
            if(show.getTheatreEntity().equals(theatreEntity)){
                showsListOfMovieTheatre.add(show.getShowTime());
            }
        }
        return showsListOfMovieTheatre;
    }

    public List<String> getTheatresAtShowTime(LocalTime time){
        List<ShowEntity> showEntityList = showRepository.findAll();
        List<String> theatres = new ArrayList<>();
        for (ShowEntity show:showEntityList){
            if(show.getShowTime().equals(time)){
                theatres.add(show.getTheatreEntity().getName()+" "+show.getTheatreEntity().getLocation()+" ");
            }
        }
        return theatres;
    }
}
