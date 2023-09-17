package com.example.Book.my.show.ReqDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDTO {
    private List<String> allottedSeats;
    private int amount;
    private int userId;
    private int showId;
    private String movieName;
}