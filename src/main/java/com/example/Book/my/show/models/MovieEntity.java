package com.example.Book.my.show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private double duration;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date releasedate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows;

}
