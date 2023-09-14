package com.example.Book.my.show.ReqDTOs;


import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class MovieDTO {
    private String name;
    private String image;
    private String bannerImage;
    private Date releasedate;
    private double duration;
    private String category;
    private String howManyInterested;
    private String aboutTheMovie;
    private List<String> cast;
    private List<String> crew;
}
