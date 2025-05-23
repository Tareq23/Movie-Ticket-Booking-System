package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "MOVIE_CATEGORIES")
public class MovieCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_category_sequence_generator")
    @SequenceGenerator(name = "movie_category_sequence_generator", sequenceName = "MOVIE_CATEGORIES_SEQ", allocationSize = 1)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "CATEGORY_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

}
