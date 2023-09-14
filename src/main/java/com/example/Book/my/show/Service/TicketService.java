package com.example.Book.my.show.Service;

import com.example.Book.my.show.Repository.*;
import com.example.Book.my.show.ReqDTOs.TicketDTO;
import com.example.Book.my.show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepo showRepo;

    @Autowired
    UserReop userReop;

    @Autowired
    SeatsRepo seatsRepo;

    @Autowired
    private ShowSeatsRepo showSeatsRepo;


    public void  BookTickets(TicketDTO ticketDTO) throws Exception {
        // Requirements------>>>
        userEntity user=userReop.findById(ticketDTO.getUserId()).get();
        ShowEntity show=showRepo.findById(ticketDTO.getShowId()).get();
        List<String> RequestSeats = ticketDTO.getAllotedSeats();
        System.out.println(RequestSeats);
        SeatsEntity seatsEntity = show.getSeats();

        HashMap<String,Boolean> allSeats = seatsEntity.getAllSeats(seatsEntity);

        for(String seat : RequestSeats){

            allSeats.put(seat, true);

        }

        seatsEntity.setAllSeat(allSeats);
        seatsRepo.save(seatsEntity);

        TicketEntity ticket=new TicketEntity();

        ticket.setBooked_at(new Date());
        ticket.setShow(show);
        ticket.setUser(user);

        ticket.setAmount(ticketDTO.getAmount());

        String allotedSeats = "";
        for (String s : RequestSeats){
            allotedSeats = allotedSeats.concat(s);
            allotedSeats = allotedSeats.concat(",");
        }

        ticket.setAllotedSeats(allotedSeats);

        ticketRepository.save(ticket);


        /*
        // get all show seats list from showEntity
        List<ShowSeatEntity> showSeats = show.getListOfSeats();
        List<ShowSeatEntity> bookedSeats=new ArrayList<>();
        // checking all reqesting seats are available or not
        for(ShowSeatEntity showSeat:showSeats){

            if(showSeat.isBoocked()==false && RequestSeats.contains(showSeat.getSeatNo())){
             bookedSeats.add(showSeat);
            }
        }


//       Failure Situation
        if(bookedSeats.size()!=RequestSeats.size()){
            throw new Exception("Requested seats are not available");
        }
*/


//       Success situation




    }

    /*
    public int cancelTicket(int ticketId){

        TicketEntity ticket=ticketRepository.findById(ticketId).get();
        String alloted_seats=ticket.getAlloted_seats();
        String [] seats=alloted_seats.split(",");
        List<String> seatslist=new ArrayList<>(List.of(seats));
        ShowEntity show=ticket.getShow();
        List<ShowSeatEntity> showSeats=show.getListOfSeats();
        for(ShowSeatEntity showSeat: showSeats){
            if (seatslist.contains(showSeat.getSeatNo())){
                showSeat.setBoocked(false);
                showSeat.setTickets(null);
                showSeat.setBookedOn(null);
            }
        }
        int refund=ticket.getAmount();
        ticketRepository.delete(ticket);
        return refund;
    }
    */

}
