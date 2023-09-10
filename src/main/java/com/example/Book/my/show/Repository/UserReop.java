package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.userEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReop extends JpaRepository<userEntity,Integer> {
	
    Optional<userEntity> findOneByEmailAndPassword(String email, String password);
	
	userEntity findByEmail(String email);
	
}
