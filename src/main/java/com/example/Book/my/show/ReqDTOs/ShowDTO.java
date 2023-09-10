package com.example.Book.my.show.ReqDTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowDTO {
    private LocalDate showDate;
    private LocalTime showTime;
    private  double multiplayer;
    private String movieName;
    private int theaterId;
}
