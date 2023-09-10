package com.example.Book.my.show.Repository;

import com.example.Book.my.show.models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
