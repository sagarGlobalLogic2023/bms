package com.example.Book.my.show.Service;

import com.example.Book.my.show.Repository.ShowRepo;
import com.example.Book.my.show.Repository.ShowSeatsRepo;
import com.example.Book.my.show.Repository.TicketRepository;
import com.example.Book.my.show.Repository.UserReop;
import com.example.Book.my.show.ReqDTOs.TicketDTO;
import com.example.Book.my.show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private ShowSeatsRepo showSeatsRepo;


    public void  BookTickets(TicketDTO ticketDTO) throws Exception {
//Requirements------>>>
        userEntity user=userReop.findById(ticketDTO.getUserId()).get();
        ShowEntity show=showRepo.findById(ticketDTO.getShowId()).get();
        List<String> RequestSeats=ticketDTO.getAllotedSeats();
//        get all show seats list from showEntity
        List<ShowSeatEntity> showSeats=show.getListOfSeats();
        List<ShowSeatEntity> bookedSeats=new ArrayList<>();
//        checking all reqesting seats are available or not
        for(ShowSeatEntity showSeat:showSeats){

            if(showSeat.isBoocked()==false && RequestSeats.contains(showSeat.getSeatNo())){
             bookedSeats.add(showSeat);
            }
        }

//       Failure Situation
        if(bookedSeats.size()!=RequestSeats.size()){
            throw new Exception("Requested seats are not available");
        }
//       Success situation

        TicketEntity ticket=new TicketEntity();
        double totalAmount=0;
        double multiplier=show.getMultiplayer();

        String allocatedSeats="";
        int rate=0;

        for(ShowSeatEntity bookedseat:bookedSeats){
            bookedseat.setBoocked(true);
            bookedseat.setBookedOn(new Date());
            bookedseat.setShow(show);
            bookedseat.setTickets(ticket);

            allocatedSeats=allocatedSeats+bookedseat.getSeatNo()+",";

            if(bookedseat.getSeatNo().charAt(0)=='1'){
                rate=100;
            }else{
                rate=200;
            }
            totalAmount=totalAmount+multiplier*rate;
        }
        ticket.setBooked_at(new Date());
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setBookSeats(bookedSeats);
        ticket.setAmount((int)totalAmount);
        ticket.setAlloted_seats(allocatedSeats);

        ticketRepository.save(ticket);
    }
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
}
