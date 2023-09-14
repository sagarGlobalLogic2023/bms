package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByName(String name);
    List<MovieEntity> findByCategory(String category);

}
