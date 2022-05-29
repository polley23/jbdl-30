package com.example.jbdl12redis;

import com.example.jbdl12redis.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movie,Long> {
    Optional<Movie> findByName(String name);
}
