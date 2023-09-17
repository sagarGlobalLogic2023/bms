package com.example.Book.my.show.Service;

import com.example.Book.my.show.Converters.ObjectTranslator;
import com.example.Book.my.show.Repository.*;
import com.example.Book.my.show.ReqDTOs.MovieDTO;
import com.example.Book.my.show.ReqDTOs.SeatResponseDTO;
import com.example.Book.my.show.ReqDTOs.ShowDTO;
import com.example.Book.my.show.ReqDTOs.ShowResponseDto;
import com.example.Book.my.show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    SeatsRepo seatsRepo;

    @Autowired
    MovieService movieService;

    @Autowired
    TheaterService theaterService;

    @Autowired
    ObjectTranslator translator;

/*

    public String addShow(ShowDTO showDTO){


//        create show entity
        ShowEntity showEntity=ShowEntity.builder()
                .showDate(showDTO.getShowDate())
                .showTime(showDTO.getShowTime())
                .multiplayer(showDTO.getMultiplayer())
                .build();
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

*/

    public List<ShowResponseDto> getAllShows(){
        System.out.println("in service");

        List<ShowEntity> showEntityList = showRepo.findAll();

        List<ShowResponseDto>showResponseDtoList = new ArrayList<>();
        for (ShowEntity showEntity : showEntityList){
            ShowResponseDto showResponseDto = ShowResponseDto.builder()
                    .id(showEntity.getId())
                    .showDate(showEntity.getShowDate())
                    .showTime(showEntity.getShowTime())
                    .price(showEntity.getPrice())
                    .movie(movieService.getMovie(showEntity.getMovie().getName()))
                    .theater(theaterService.getTheaterByName(showEntity.getTheater().getName()))
                    .build();

            showResponseDtoList.add(showResponseDto);

            /*
             MovieEntity movie = showEntity.getMovie();
            MovieDTO movieDTO = new MovieDTO(movie.getName(),movie.getImage(), movie.getBannerImage(),movie.getReleasedate(),movie.getDuration(), movie.getCategory(),movie.getHowManyInterested(),movie.getAboutTheMovie(),movie.getCast(),movie.getCrew());
            showResponseDto.setMovie(movie);
            TheaterEntity theater =  showEntity.getTheater();
            showResponseDto.setTheater(theater);
            */
        }


        return showResponseDtoList;
    }

    public String addShow(ShowDTO showDTO){

        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showDTO.getShowDate())
                .showTime(showDTO.getShowTime())
                .price(showDTO.getPrice())
                .multiplayer(showDTO.getMultiplayer())
                .seats(new SeatsEntity())
                .build();
        //Need to get the MovieRepo
        String name = showDTO.getMovieName();
        MovieEntity movie = movieRepo.findByName(name);

        //Need to get Theater Repository
        TheaterEntity theater = theaterRepo.findById( showDTO.getTheaterId() ).get();

        showEntity.setMovie(movie);
        showEntity.setTheater(theater);
        showRepo.save(showEntity);

        movie.getListOfShows().add(showEntity);
        /*
        theater.getListOfSeats().add(showEntity);
        */
        movieRepo.save(movie);




        return "Show Successfully added";
    }

    public SeatResponseDTO getShowSeats(int showId) {
        ShowEntity showEntity = showRepo.findById(showId).get();
        SeatsEntity seatsEntity = showEntity.getSeats();
        SeatResponseDTO seatResponseDTO = translator.translate(seatsEntity, SeatResponseDTO.class);
        return seatResponseDTO;
    }

    public List<ShowResponseDto> getByCity(String city, String name) {
        List<ShowEntity> shows = showRepo.findAll();
        List<ShowResponseDto> allShows = new ArrayList<>();
        for (ShowEntity show : shows){
            if (show.getTheater().getCity().equals(city) && show.getMovie().getName().equals(name)) {
                ShowResponseDto responseDto = ShowResponseDto.builder()
                        .id(show.getId())
                        .showDate(show.getShowDate())
                        .showTime(show.getShowTime())
                        .price(show.getPrice())
                        .movie(movieService.getMovie(show.getMovie().getName()))
                        .theater(theaterService.getTheaterByName(show.getTheater().getName()))
                        .build();

                allShows.add(responseDto);
            }
        }
        return allShows;
    }

    public List<ShowResponseDto> getByDateAndCity(LocalDate date, String city, String name) {
        List<ShowEntity> shows = showRepo.findAll();
        List<ShowResponseDto> allShows = new ArrayList<>();
        for (ShowEntity show : shows){
            if (show.getShowDate().equals(date) && show.getTheater().getCity().equals(city) && show.getMovie().getName().equals(name)) {
                ShowResponseDto responseDto = ShowResponseDto.builder()
                        .id(show.getId())
                        .showDate(show.getShowDate())
                        .showTime(show.getShowTime())
                        .price(show.getPrice())
                        .movie(movieService.getMovie(show.getMovie().getName()))
                        .theater(theaterService.getTheaterByName(show.getTheater().getName()))
                        .build();
                allShows.add(responseDto);
            }
        }
        return allShows;
    }
}