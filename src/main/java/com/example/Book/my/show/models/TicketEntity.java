package com.example.Book.my.show.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ticket")
@Data
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allotedSeats;



    private int amount;

    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private userEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

/*

    //COMMENT LATER FOR SEATS IMPLEMENTATION
    @OneToMany(mappedBy = "tickets",cascade = CascadeType.ALL)
    private  List<ShowSeatEntity> bookSeats;
*/

}
