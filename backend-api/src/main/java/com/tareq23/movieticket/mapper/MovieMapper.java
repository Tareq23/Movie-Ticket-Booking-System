package com.tareq23.movieticket.mapper;


import com.tareq23.movieticket.dto.request.MovieRequest;
import com.tareq23.movieticket.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {


    public Movie toMovie(MovieRequest movieRequest) {
        return Movie
                .builder()
                .title(movieRequest.title())
                .duration(movieRequest.duration())
                .genre(movieRequest.genre())
                .language(movieRequest.language())
                .posterUrl(movieRequest.posterUrl())
                .releaseDate(movieRequest.releaseDate())
                .trailerUrl(movieRequest.trailerUrl())
                .description(movieRequest.description())
                .build();
    }

}
