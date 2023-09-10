package com.example.Book.my.show.Service;

import com.example.Book.my.show.Repository.MovieRepo;
import com.example.Book.my.show.Repository.ShowRepo;
import com.example.Book.my.show.Repository.ShowSeatsRepo;
import com.example.Book.my.show.Repository.TheaterRepo;
import com.example.Book.my.show.ReqDTOs.ShowDTO;
import com.example.Book.my.show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    TheaterRepo theaterRepo;
    @Autowired
    ShowRepo showRepo;

    @Autowired
    ShowSeatsRepo showSeatsRepo;


    public String addShow(ShowDTO showDTO){

//        create show entity
        ShowEntity showEntity=ShowEntity.builder().showDate(showDTO.getShowDate()).showTime(showDTO.getShowTime()).multiplayer(showDTO.getMultiplayer()).build();
//        Need to get the MovieRepo
        String name=showDTO.getMovieName();
        MovieEntity movie=movieRepo.findByName(name);
//        Need to get Theater Repository
        TheaterEntity theater=theaterRepo.findById(showDTO.getTheaterId()).get();

        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        movie.getListOfShows().add(showEntity);
        theater.getListOfSeats().add(showEntity);
        List<ShowSeatEntity> seatEntityList=createShowSeats(theater.getTheaterSeatsEntity());
        showEntity.setListOfSeats(seatEntityList);
//        for each show seat : Need to mark to which show it belongs to
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }
//        showRepo.save(showEntity);
        movieRepo.save(movie);
        theaterRepo.save(theater);
        return "Show Successfully added";
    }

    private List<ShowSeatEntity> createShowSeats(List<TheaterSeatsEntity> theaterSeatsEntity) {

        List<ShowSeatEntity> seats=new ArrayList<>();
        for(TheaterSeatsEntity theaterSeats:theaterSeatsEntity){
            ShowSeatEntity showSeatEntity=ShowSeatEntity.builder().seatNo(theaterSeats.getSeatNo()).seatType(theaterSeats.getSeatType()).build();
           seats.add(showSeatEntity);
        }
        showSeatsRepo.saveAll(seats);
        return seats;
    }
}
