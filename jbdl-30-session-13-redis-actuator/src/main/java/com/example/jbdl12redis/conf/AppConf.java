package com.example.jbdl12redis.conf;

import com.example.jbdl12redis.entity.MovieRating;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConf {
    @Bean
    RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration standaloneConfiguration
                = new RedisStandaloneConfiguration();
        standaloneConfiguration.setDatabase(0);

        return new JedisConnectionFactory(standaloneConfiguration);
    }

    @Bean
    RedisTemplate<String,MovieRating> redisTemplate(){
        RedisTemplate<String, MovieRating> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

}
