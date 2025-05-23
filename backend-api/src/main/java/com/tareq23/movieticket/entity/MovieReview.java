package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "MOVIE_REVIEWS")
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_review_sequence_generator")
    @SequenceGenerator(name = "movie_review_sequence_generator", sequenceName = "MOVIE_REVIEW_SEQ", allocationSize = 1)
    @Column(name = "REVIEW_ID")
    private Long id;

    @Column(name = "MOVIE_ID")
    private Integer movieId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "RATING", nullable = false)
    private Integer rating;

    @Column(name = "review_date", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "review_updated_date", insertable = false)
    private LocalDateTime updatedAt;


}
