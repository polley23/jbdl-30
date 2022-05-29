package com.example.jbdl12redis;

import com.example.jbdl12redis.entity.MovieRating;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableRedisRepositories
public interface MovieRatingRepo extends CrudRepository<MovieRating,String> {
    Optional<MovieRating> findByName(String name);
}
