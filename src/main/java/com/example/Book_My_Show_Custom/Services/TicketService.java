package com.example.Book_My_Show_Custom.Services;

import com.example.Book_My_Show_Custom.Convertors.TicketConvertors;
import com.example.Book_My_Show_Custom.Entities.ShowEntity;
import com.example.Book_My_Show_Custom.Entities.ShowSeatEntity;
import com.example.Book_My_Show_Custom.Entities.TicketEntity;
import com.example.Book_My_Show_Custom.Entities.UserEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.TicketEntryDto;
import com.example.Book_My_Show_Custom.Repositories.ShowRepository;
import com.example.Book_My_Show_Custom.Repositories.TicketRepository;
import com.example.Book_My_Show_Custom.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketEntryDto ticketEntryDto)throws Exception{

        // 1. Create TicketEntity from entryDto
        TicketEntity ticketEntity = TicketConvertors.convertEntryDtoToEntity(ticketEntryDto);

        // 2. Do Validation : Check if the requested seats are available or not
        boolean isValidRequest = checkValidity(ticketEntryDto);
        if (isValidRequest==false){
            throw new Exception("Requested Seats are not available");
        }
        //We assume that requested seats are valid

        // Calculate the total amount

        int totalAmount = 0;
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeats = showEntity.getListOfShowSeats();
        for(ShowSeatEntity showSeat:showSeats){
            String seatNo = showSeat.getSeatNo();
            if (requestedSeats.contains(seatNo)){
                showSeat.setBooked(true);
                showSeat.setBookedAt(new Date());
                totalAmount = totalAmount+showSeat.getPrice();
            }
        }

        ticketEntity.setTotalAmount(totalAmount);
        // Setting the other attributes for ticket entity

        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheatreName(showEntity.getTheatreEntity().getName());

        // We need to set the String that stores the booked seats
        String allocatedSeats = "";
        for(String seat:ticketEntryDto.getRequestedSeats()){
            allocatedSeats=allocatedSeats+seat+", ";
        }

        ticketEntity.setBookedSeats(allocatedSeats);
        // Setting the foreign key attributes

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);
        ticketRepository.save(ticketEntity);

        List<TicketEntity> bookedTickets = showEntity.getListOfBookedTickets();
        bookedTickets.add(ticketEntity);
        showEntity.setListOfBookedTickets(bookedTickets);

        List<TicketEntity> bookedTickets2 = userEntity.getBookedTickets();
        bookedTickets2.add(ticketEntity);
        userEntity.setBookedTickets(bookedTickets2);

        // Save the parents
        showRepository.save(showEntity);
        userRepository.save(userEntity);


        return "Tickets have been booked Successfully";

    }

    private boolean checkValidity(TicketEntryDto ticketEntryDto){
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeats = showEntity.getListOfShowSeats();
        for(ShowSeatEntity showSeat:showSeats){
            String seatNo = showSeat.getSeatNo();
            if (requestedSeats.contains(seatNo) && showSeat.isBooked()==true){
                return false;
            }
        }
        return true;
    }
}
