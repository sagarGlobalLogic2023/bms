package com.example.Book.my.show.ReqDTOs;


import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO {
    private String name;
    private String image;
    private String bannerImage;
    @Temporal(TemporalType.DATE)
    private Date releasedate;
    private double duration;
    private String category;
    private String howManyInterested;
    private String aboutTheMovie;
    private String cast;
    private String crew;
}