package com.example.Book.my.show.Service;

import com.example.Book.my.show.Converters.TheaterDtoToEntity;
import com.example.Book.my.show.Enums.SeatType;
import com.example.Book.my.show.Repository.MovieRepo;
import com.example.Book.my.show.Repository.ShowRepo;
import com.example.Book.my.show.Repository.TheaterRepo;
import com.example.Book.my.show.Repository.TheaterSeatsRepo;
import com.example.Book.my.show.ReqDTOs.TheaterDTO;
import com.example.Book.my.show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {


    @Autowired
    TheaterRepo theaterRepo;
    @Autowired
    TheaterSeatsRepo theaterSeatsRepo;
    @Autowired
    TheaterSeatsService theaterSeatsService;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ShowRepo showRepo;


    public String AddTheater(TheaterDTO theaterDTO){
        TheaterEntity theater= TheaterEntity.builder().name(theaterDTO.getName()).city(theaterDTO.getCity()).address(theaterDTO.getAddress()).build();
        List<TheaterSeatsEntity> list= theaterSeatsService.setTheaterSeats();
        theater.setTheaterSeatsEntity(list);//Bydirectional mapping
//        for each theater seat we need to set the theaterEntity
//        like forighn key
        for(TheaterSeatsEntity st:list){
            st.setTheaterEntity(theater);
        }
        theaterRepo.save(theater);
        return "THEATER SUCCESSFULLY ADDED";
    }

    public TheaterDTO getTheater(int id){
        TheaterEntity theater=theaterRepo.findById(id).get();
        TheaterDTO theaterDTO=new TheaterDTO();
        theaterDTO.setName(theater.getName());
        theaterDTO.setCity(theater.getCity());
        theaterDTO.setAddress(theater.getAddress());
        return theaterDTO;
    }

    public List<TheaterDTO> getAllTheares() {
        List<TheaterDTO> theaters=new ArrayList<>();
        List<TheaterEntity> theaterEntities=theaterRepo.findAll();
        for(TheaterEntity th: theaterEntities){
            TheaterDTO theaterDTO=new TheaterDTO();
            theaterDTO.setAddress(th.getAddress());
            theaterDTO.setName(th.getName());
            theaterDTO.setCity((th.getCity()));

            theaters.add(theaterDTO);
        }
        return theaters;
    }

    public TheaterDTO getTheaterByName(String name){
        TheaterEntity theater=theaterRepo.findByName(name);
        TheaterDTO theaterDTO=new TheaterDTO();
        theaterDTO.setName(theater.getName());
        theaterDTO.setCity(theater.getCity());
        theaterDTO.setAddress(theater.getAddress());
        return theaterDTO;
    }
    public List<TheaterDTO> getTheatersByMovie(String name){
        List<TheaterDTO> theaterDTOList=new ArrayList<>();

        List<ShowEntity> showEntities=showRepo.findAll();

        for(ShowEntity show: showEntities){
          MovieEntity movie=show.getMovie();
          if(movie.getName().equals(name)){
              TheaterEntity theater=show.getTheater();
              TheaterDTO theaterDTO=new TheaterDTO();
              theaterDTO.setName(theater.getName());
              theaterDTO.setCity(theater.getCity());
              theaterDTO.setAddress(theater.getAddress());
              if (!theaterDTOList.contains(theaterDTO)){
                  theaterDTOList.add(theaterDTO);
              }
          }
      }
        return theaterDTOList;
    }



}
