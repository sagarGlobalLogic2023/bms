package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.ShowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private List<String> allotedSeats;
    private int amount;
    private int userId;
    private int showId;

}
