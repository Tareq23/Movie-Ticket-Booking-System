package com.tareq23.movieticket.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import java.math.BigInteger;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence_generator")
    @SequenceGenerator(name = "movie_sequence_generator", sequenceName = "MOVIE_SEQ", allocationSize = 1)
    @Column(name = "MOVIE_ID")
    private Integer id;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "DURATION_MINUTES")
    private Integer duration;

    @Column(name = "LANGUAGE", length = 50)
    private String language;

    @Column(name = "GENRE", length = 50)
    private String genre;

    @Column(name = "POSTER_URL", length = 255)
    private String posterUrl;

    @Column(name = "TRAILER_URL", length = 300)
    private String trailerUrl;

    @Column(name = "RATING", length = 10)
    private String rating;
}
