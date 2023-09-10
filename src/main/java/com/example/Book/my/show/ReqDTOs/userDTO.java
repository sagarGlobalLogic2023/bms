package com.example.Book.my.show.ReqDTOs;

import com.example.Book.my.show.models.userEntity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class userDTO {
   
	 @Column(nullable = false,unique = true, length=255)
	    private String name;

	    @Column(nullable= false, length=255)
	    private String email;
	    
	    @Column(nullable=false, length=255)
	    private String password;

    }


