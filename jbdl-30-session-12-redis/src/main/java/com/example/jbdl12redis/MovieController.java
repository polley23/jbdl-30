package com.example.jbdl12redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieManager movieManager;
    @PostMapping("/movie")
    ResponseEntity createMovie(@RequestBody MovieRequest movie){
        movieManager.add(movie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/movie/{movie_name}")
    ResponseEntity getMovieRating(@PathVariable("movie_name") String movieName){
        return ResponseEntity.ok().body(movieManager.getRating(movieName));
    }

    @PutMapping("/movie/{movie_name}/rating/{rating}")
    ResponseEntity getMovieRating(@PathVariable("movie_name") String movieName,
                                  @PathVariable("rating") Double rating){
        return ResponseEntity.ok().build();
    }

}
