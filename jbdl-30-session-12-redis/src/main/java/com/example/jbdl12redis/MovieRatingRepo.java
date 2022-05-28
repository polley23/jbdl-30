package com.example.jbdl12redis;

import com.example.jbdl12redis.entity.MovieRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRatingRepo extends CrudRepository<MovieRating,String> {
}
