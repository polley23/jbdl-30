package com.example.jbdl12redis.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRating {
    @Id
    String movieName;
    Double rating;
}
