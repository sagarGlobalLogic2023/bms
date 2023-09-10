package com.example.Book.my.show.ReqDTOs;


import lombok.Data;


import java.util.Date;
@Data
public class MovieDTO {
    private String name;
    private Date releasedate;
    private double duration;
}
