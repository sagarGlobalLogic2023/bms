package com.example.Book.my.show.ReqDTOs;

import java.util.Optional;

import com.example.Book.my.show.models.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
   
	private String token;
	private Optional<userEntity> user;
}
