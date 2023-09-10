package com.example.Book.my.show.Service;

import com.example.Book.my.show.Converters.MovieDtoToEntity;
import com.example.Book.my.show.Repository.MovieRepo;
import com.example.Book.my.show.ReqDTOs.MovieDTO;
import com.example.Book.my.show.ReqDTOs.MovieResponceDto;
import com.example.Book.my.show.models.MovieEntity;
import com.example.Book.my.show.models.ShowEntity;
import com.example.Book.my.show.models.TheaterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public String addMovie(MovieDTO movieDTO){
        MovieEntity movie= MovieDtoToEntity.converterDTOtoEntity(movieDTO);
        movieRepo.save(movie);
        return "success";
    }
    public MovieResponceDto getMovie(String mvName){
        MovieEntity movie=movieRepo.findByName(mvName);
        MovieResponceDto movieres= MovieResponceDto.builder()
                .name(movie.getName())
                .duration(movie.getDuration())
                .releasedate(movie.getReleasedate())
                .build();
        List<String> theaters=new ArrayList<>();
        List<ShowEntity> shows=movie.getListOfShows();
        for(ShowEntity show:shows){
            TheaterEntity theater=show.getTheater();
            if(!theaters.contains(theater)){
                theaters.add(theater.getName());
            }
        }
        movieres.setTheaters(theaters);

        return movieres;
    }
    public List<MovieResponceDto> getMovies(){
        List<MovieEntity> movies=movieRepo.findAll();
        List<MovieResponceDto> Allmovies=new ArrayList<>();
        for (MovieEntity movie:movies){
            MovieResponceDto responceDto= MovieResponceDto.builder().name(movie.getName()).releasedate(movie.getReleasedate()).duration(movie.getDuration()).build();
            List<ShowEntity> showEntities=movie.getListOfShows();
            List<String> theaters=new ArrayList<>();
            for (ShowEntity show:showEntities){
                if(!theaters.contains(show.getTheater())){
                    theaters.add(show.getTheater().getName());
                }
                responceDto.setTheaters(theaters);
            }
            Allmovies.add(responceDto);
        }
        return Allmovies;
    }
}
