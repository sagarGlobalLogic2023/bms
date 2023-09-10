package com.example.Book.my.show.models;

import com.example.Book.my.show.Enums.SeatType;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "Show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean boocked;


    private Date bookedOn;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;


    @ManyToOne
    @JoinColumn
    private TicketEntity tickets;





}
