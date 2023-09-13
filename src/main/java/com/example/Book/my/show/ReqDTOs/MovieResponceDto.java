package com.example.Book.my.show.ReqDTOs;

import lombok.Builder;
import lombok.Data;
//import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
@Data
@Builder
public class MovieResponceDto {
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date releasedate;
    private double duration;
    private List<String> theaters=new ArrayList<>();
}
