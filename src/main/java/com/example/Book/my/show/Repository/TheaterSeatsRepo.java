package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepo extends JpaRepository<TheaterSeatsEntity,Integer> {
}
