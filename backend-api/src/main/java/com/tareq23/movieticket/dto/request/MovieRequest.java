package com.tareq23.movieticket.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record MovieRequest(

 String title,

 String description,

 LocalDate releaseDate,

 Integer duration,

 String language,

 String genre,

 String posterUrl,

 String trailerUrl

) {
}
