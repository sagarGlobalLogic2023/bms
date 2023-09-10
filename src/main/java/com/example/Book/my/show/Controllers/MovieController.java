package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.MovieDTO;
import com.example.Book.my.show.ReqDTOs.MovieResponceDto;
import com.example.Book.my.show.Service.MovieService;
import com.example.Book.my.show.Service.UserService;
import com.example.Book.my.show.models.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody() MovieDTO movieDTO){
        String res=movieService.addMovie(movieDTO);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @GetMapping("/Get_movie")
    public ResponseEntity<MovieResponceDto> getMovieByName(@RequestParam("MovieName") String MvName){
        MovieResponceDto movie=movieService.getMovie(MvName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("Get_All_Movies")
    public ResponseEntity<List<MovieResponceDto>> getMovies(){
        List<MovieResponceDto> movies=movieService.getMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }




}
