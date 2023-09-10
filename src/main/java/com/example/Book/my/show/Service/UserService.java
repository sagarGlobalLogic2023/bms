package com.example.Book.my.show.Service;

import com.example.Book.my.show.Converters.UserDto_to_Entity;
import com.example.Book.my.show.Repository.UserReop;
import com.example.Book.my.show.ReqDTOs.LoginDTO;
import com.example.Book.my.show.ReqDTOs.LoginResponse;
import com.example.Book.my.show.ReqDTOs.userDTO;
import com.example.Book.my.show.models.userEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    
	@Autowired
	   private UserReop userRepo;
	    
	    @Autowired(required = true)
		private BCryptPasswordEncoder beBCryptPasswordEncoder;

	   public String add_user(userDTO userDTO){

	    userEntity user=UserDto_to_Entity.converterUserDtoToEntity(userDTO);
	    user.setPassword(beBCryptPasswordEncoder.encode(user.getPassword()));
	        userRepo.save(user);
	        return "success";
	    }
	   
	   public LoginResponse login(LoginDTO loginDTO) {
	       userEntity user1 = userRepo.findByEmail(loginDTO.getEmail());
	       if (user1 != null) {
	           String password = loginDTO.getPassword();
	           String encodedPassword = user1.getPassword();
	           Boolean isPwdRight = beBCryptPasswordEncoder.matches(password, encodedPassword);
	           if (isPwdRight) {
	               Optional<userEntity> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	               if (user.isPresent()) {
	                   return new LoginResponse("Login Success", true);
	               } else {
	                   return new LoginResponse("Login Failed", false);
	               }
	           } else {
	               return new LoginResponse("password Not Match", false);
	           }
	       }else {
	           return new LoginResponse("Email not exits", false);
	       }
	
	
    }
}
