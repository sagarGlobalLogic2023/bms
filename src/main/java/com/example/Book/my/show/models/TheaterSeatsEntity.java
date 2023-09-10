package com.example.Book.my.show.models;

import com.example.Book.my.show.Enums.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Theater_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//primary key
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    public TheaterSeatsEntity(String seatNo, SeatType seatType, int rate) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
