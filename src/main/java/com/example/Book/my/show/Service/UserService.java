package com.example.Book.my.show.Service;

import com.example.Book.my.show.Converters.UserDto_to_Entity;
import com.example.Book.my.show.Repository.UserReop;
import com.example.Book.my.show.ReqDTOs.userDTO;
import com.example.Book.my.show.models.userEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserReop userReop;

   public String add_user(userDTO userDTO){

    userEntity user=UserDto_to_Entity.converterUserDtoToEntity(userDTO);
        userReop.save(user);
        return "success";
    }
}
