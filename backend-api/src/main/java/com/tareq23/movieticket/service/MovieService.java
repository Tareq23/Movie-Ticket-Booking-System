package com.tareq23.movieticket.service;

import com.tareq23.movieticket.dto.request.MovieRequest;
import com.tareq23.movieticket.repository.MovieDocumentRepository;
import com.tareq23.movieticket.repository.MovieRepository;
import com.tareq23.movieticket.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieDocumentRepository  movieDocumentRepository;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


    public Object save(MovieRequest movieRequest) {

        var movie = movieRepository.save(movieMapper.toMovie(movieRequest));
        return null;
    }
}
