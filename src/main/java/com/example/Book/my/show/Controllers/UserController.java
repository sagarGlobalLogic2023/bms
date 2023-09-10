package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.userDTO;
import com.example.Book.my.show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody()userDTO userDTO){
        String statement=userService.add_user(userDTO);
        return new ResponseEntity<>(statement, HttpStatus.CREATED) ;
    }
}
