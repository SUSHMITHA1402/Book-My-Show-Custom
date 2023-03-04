package com.example.Book_My_Show_Custom.Repositories;

import com.example.Book_My_Show_Custom.Entities.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
