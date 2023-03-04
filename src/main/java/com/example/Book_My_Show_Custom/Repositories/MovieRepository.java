package com.example.Book_My_Show_Custom.Repositories;

import com.example.Book_My_Show_Custom.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByMovieName(String name);
}
