package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.AuthRequest;
import com.example.Book.my.show.ReqDTOs.LoginDTO;
import com.example.Book.my.show.ReqDTOs.LoginResponse;
import com.example.Book.my.show.ReqDTOs.userDTO;
import com.example.Book.my.show.Service.JwtService;
import com.example.Book.my.show.Service.UserService;
import com.example.Book.my.show.models.userEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {
   
	 @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	    @Autowired
	    private JwtService jwtService;
	    

	    @PostMapping("/add-user")
	    public ResponseEntity<userEntity> AddUser(@RequestBody()userDTO userDTO){
	        userEntity user=userService.add_user(userDTO);
	        return new ResponseEntity<>(user, HttpStatus.CREATED) ;
	    }
	    
	    
	    @PostMapping("/authenticate")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getUsername());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }


	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDTO loginDTO)
	    {
	    	LoginResponse res=userService.login(loginDTO);
	    	return new ResponseEntity<>(res, HttpStatus.OK);
	    }	
	    
	    @GetMapping("/getAll")
	    public ResponseEntity<List<userEntity>> getAllUsers()
	    {
	    	List<userEntity>users=userService.getAllUser();
	    	return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	
}
