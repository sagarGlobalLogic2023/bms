package com.example.Book.my.show.Converters;

import com.example.Book.my.show.ReqDTOs.TheaterDTO;
import com.example.Book.my.show.models.TheaterEntity;

public class TheaterDtoToEntity {
    public  static TheaterEntity converterDtoTOEntity(TheaterDTO theaterDTO){
        TheaterEntity theater= TheaterEntity.builder()
                .name(theaterDTO.getName())
                .address(theaterDTO.getAddress())
                .city(theaterDTO.getCity())
                .build();
        return theater;
    }
}
