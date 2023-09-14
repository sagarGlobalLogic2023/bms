package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity,Integer> {
}
