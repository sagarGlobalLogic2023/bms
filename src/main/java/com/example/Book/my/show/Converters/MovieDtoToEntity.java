package com.example.Book.my.show.Converters;

import com.example.Book.my.show.ReqDTOs.MovieDTO;
import com.example.Book.my.show.models.MovieEntity;

public class MovieDtoToEntity {
    public static MovieEntity converterDTOtoEntity(MovieDTO movieDTO){
        MovieEntity movie= MovieEntity.builder()
                .name(movieDTO.getName())
                .image(movieDTO.getImage())
                .bannerImage(movieDTO.getBannerImage())
                .releasedate(movieDTO.getReleasedate())
                .duration(movieDTO.getDuration())
                .category(movieDTO.getCategory())
                .howManyInterested((movieDTO.getHowManyInterested()))
                .aboutTheMovie(movieDTO.getAboutTheMovie())
                .crew(movieDTO.getCrew())
                .cast(movieDTO.getCast())
                .build();
        return movie;
    }
}
