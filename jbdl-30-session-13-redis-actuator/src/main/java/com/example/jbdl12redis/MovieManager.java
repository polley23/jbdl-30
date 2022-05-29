package com.example.jbdl12redis;

public interface MovieManager {
    void add(MovieRequest movieRequest);
    Double getRating(String movieName);
    void postRating(String movieName, Double rating);
}
