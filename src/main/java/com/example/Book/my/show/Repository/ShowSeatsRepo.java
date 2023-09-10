package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepo extends JpaRepository<ShowSeatEntity,Integer> {
}
