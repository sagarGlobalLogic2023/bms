package com.example.Book.my.show.ReqDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {
    private LocalDate showDate;
    private LocalTime showTime;
    private int price;
    private  double multiplayer;
    private String movieName;
    private int theaterId;
}
