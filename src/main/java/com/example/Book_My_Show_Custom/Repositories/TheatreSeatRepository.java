package com.example.Book_My_Show_Custom.Repositories;

import com.example.Book_My_Show_Custom.Entities.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
