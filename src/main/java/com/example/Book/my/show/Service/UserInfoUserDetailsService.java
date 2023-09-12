package com.example.Book.my.show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.Book.my.show.Config.UserInfoUserDetails;
import com.example.Book.my.show.Repository.UserReop;
import com.example.Book.my.show.models.userEntity;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	 @Autowired
	 private UserReop repository;
    	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<userEntity> userInfo = repository.findByName(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
	}

}
