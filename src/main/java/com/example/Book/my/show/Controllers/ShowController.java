package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.ShowDTO;
import com.example.Book.my.show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@CrossOrigin
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> addShow(@RequestBody()ShowDTO showDTO){
    String req= showService.addShow(showDTO);
    return new ResponseEntity<>(req, HttpStatus.ACCEPTED);
    }
}
