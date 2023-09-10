package com.example.Book.my.show.Converters;

import com.example.Book.my.show.ReqDTOs.MovieDTO;
import com.example.Book.my.show.models.MovieEntity;

public class MovieDtoToEntity {
    public static MovieEntity converterDTOtoEntity(MovieDTO movieDTO){
        MovieEntity movie= MovieEntity.builder()
                .name(movieDTO.getName())
                .releasedate(movieDTO.getReleasedate())
                .duration(movieDTO.getDuration())
                .build();
        return movie;
    }
}
