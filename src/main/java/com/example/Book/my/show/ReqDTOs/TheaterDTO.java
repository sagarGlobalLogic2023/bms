package com.example.Book.my.show.ReqDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDTO {
    private String name;
    private String city;
    private String address;
}
