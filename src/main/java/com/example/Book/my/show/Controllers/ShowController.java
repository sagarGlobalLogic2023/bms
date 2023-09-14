package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.MovieResponceDto;
import com.example.Book.my.show.ReqDTOs.SeatResponseDTO;
import com.example.Book.my.show.ReqDTOs.ShowDTO;
import com.example.Book.my.show.ReqDTOs.ShowResponseDto;
import com.example.Book.my.show.Service.ShowService;
import com.example.Book.my.show.models.SeatsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/show")
@CrossOrigin
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> addShow(@RequestBody() ShowDTO showDTO) {
        String req = showService.addShow(showDTO);
        return new ResponseEntity<>(req, HttpStatus.ACCEPTED);
    }

    @GetMapping("/Get_By_City")
    public ResponseEntity<List<ShowResponseDto>> getByCity(String city){
        List<ShowResponseDto> shows = showService.getByCity(city);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }


    /*

    @GetMapping("/shows")
    public ResponseEntity<List<ShowResponseDto>> getAllShows(){
        List<ShowResponseDto> showResponseDtoList = showService.getAllShows();

        return new ResponseEntity<>(showResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/seats")
    public ResponseEntity<SeatResponseDTO> getSeats(@RequestParam("showId") int showId){
        SeatResponseDTO seatResponseDTO = showService.getSeats(showId);

        return new ResponseEntity<>(seatResponseDTO,HttpStatus.OK);
    }
*/



}
