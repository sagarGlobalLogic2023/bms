package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.MovieEntity;
import com.example.Book.my.show.models.SeatsEntity;
import com.example.Book.my.show.models.TheaterEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@ToString
public class ShowResponseDto {
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieEntity movie;
    private TheaterEntity theater;

}
