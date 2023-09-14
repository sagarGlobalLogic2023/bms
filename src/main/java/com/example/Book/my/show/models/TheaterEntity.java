package com.example.Book.my.show.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "theater")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor

public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfSeats;


  /*
    //COMMENT LATER FOR SEATS IMPLEMENTATION
    //      list of Theater seats
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheaterSeatsEntity> theaterSeatsEntity;

*/
}
