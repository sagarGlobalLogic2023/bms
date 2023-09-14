package com.example.Book.my.show.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MovieEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;

    private String image;
    private String bannerImage;

    private double duration;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date releasedate;

    private String category;
    private String howManyInterested;
    private String aboutTheMovie;
    private String cast;
    private String  crew;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows;

}
