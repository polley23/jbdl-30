package com.example.jbdl12redis;

import com.example.jbdl12redis.entity.Movie;
import com.example.jbdl12redis.entity.MovieRating;
import com.example.jbdl12redis.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieManagerImpl implements MovieManager{
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MovieRatingRepo movieRatingRepo;
    @Autowired
    RedisTemplate<String,MovieRating> movieRatingRedisTemplate;
    @Override
    public void add(MovieRequest movieRequest) {
        Movie movie = Movie.builder().name(movieRequest.movieName).build();
        movieRepo.save(movie);

    }

    @Override
    public Double getRating(String movieName) {
        Optional<MovieRating> movieRatingOptional= movieRatingRepo.findById(movieName);
        if( movieRatingOptional.isPresent()){
            return movieRatingOptional.get().getRating();
        }else{

            Movie movie = movieRepo.findByName(movieName).get();
            MovieRating movieRating = new MovieRating();
            Double rating  = 0d;
            if(movie.getRatings()==null){
                movieRating.setRating(rating);
            }else{
                double total = 0d;
               for(Rating r : movie.getRatings()){
                   total+= r.getRating();
               }
               rating = total/ movie.getRatings().size();
                movieRating.setRating(rating);
                movieRating.setMovieName(movieName);

            }
            movieRatingRepo.save(movieRating);
            return rating;
        }
    }

    @Override
    public void postRating(String movieName, Double rating) {
        Movie movie = movieRepo.findByName(movieName).get();
        if(movie.getRatings()==null){
            movie.setRatings(new ArrayList<>());
        }
        movie.getRatings().add(Rating.builder().rating(rating).build());
        movieRepo.save(movie);
        Optional<MovieRating> movieRatingOptional =  movieRatingRepo.findById(movieName);
        if(movieRatingOptional.isEmpty())
            return;
        MovieRating movieRating = movieRatingRepo.findById(movieName).get();
        movieRatingRepo.delete(movieRating);

    }
}
