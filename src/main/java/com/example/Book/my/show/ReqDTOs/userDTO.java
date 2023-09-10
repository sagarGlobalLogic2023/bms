package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.userEntity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class userDTO {
    @Column(nullable = false)
      private String name;
    @Column(nullable = false,unique = true)
      private String modile;

    }


