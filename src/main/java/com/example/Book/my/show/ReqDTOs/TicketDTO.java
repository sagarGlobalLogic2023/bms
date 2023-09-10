package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.ShowEntity;
import lombok.Data;

import java.util.List;
@Data
public class TicketDTO {
    private List<String> allotedSeats;
    private int userId;
    private int showId;
}
