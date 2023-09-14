package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.MovieEntity;
import com.example.Book.my.show.models.SeatsEntity;
import com.example.Book.my.show.models.TheaterEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ShowResponseDto {
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private int price;
    private MovieResponceDto movie;
    private TheaterDTO theater;

}
