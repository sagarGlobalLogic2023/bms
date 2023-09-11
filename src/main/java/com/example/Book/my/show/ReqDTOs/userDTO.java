package com.example.Book.my.show.ReqDTOs;

import lombok.Data;

import jakarta.persistence.Column;

@Data
public class userDTO {
   
	 @Column(nullable = false,unique = true, length=255)
	    private String name;

	    @Column(nullable= false, length=255)
	    private String email;
	    
	    @Column(nullable=false, length=255)
	    private String password;

    }


