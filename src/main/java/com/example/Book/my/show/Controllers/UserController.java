package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.LoginDTO;
import com.example.Book.my.show.ReqDTOs.LoginResponse;
import com.example.Book.my.show.ReqDTOs.userDTO;
import com.example.Book.my.show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {
   
	@Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody()userDTO userDTO){
        String statement=userService.add_user(userDTO);
        return new ResponseEntity<>(statement, HttpStatus.CREATED) ;
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDTO loginDTO)
    {
    	LoginResponse res=userService.login(loginDTO);
    	return new ResponseEntity<>(res, HttpStatus.OK);
    }
	
	
}
