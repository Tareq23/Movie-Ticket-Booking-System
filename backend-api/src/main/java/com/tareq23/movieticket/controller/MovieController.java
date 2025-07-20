package com.tareq23.movieticket.controller;


import com.tareq23.movieticket.dto.request.MovieRequest;
import com.tareq23.movieticket.entity.Movie;
import com.tareq23.movieticket.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {


    private final MovieService movieService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.ok(movieService.save(movieRequest));
    }

}
