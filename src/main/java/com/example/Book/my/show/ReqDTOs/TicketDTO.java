package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.ShowEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class TicketDTO {
    private List<String> allotedSeats;
    private int amount;
    private int userId;
    private int showId;

}
