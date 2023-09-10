package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepo extends JpaRepository<TheaterEntity,Integer> {
TheaterEntity findByNameAndCity(String name ,String city);
TheaterEntity findByName(String name);
}
