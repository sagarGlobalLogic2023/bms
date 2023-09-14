package com.example.Book.my.show.models;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;
    private int price;

    private  double multiplayer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private TheaterEntity theater;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private SeatsEntity seats;



 @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets;

/*

 //COMMENT LATER FOR SEATS IMPLEMENTATION
 @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats;

*/


}

