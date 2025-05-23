package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SCREENINGS")
public class Screening {


    @EmbeddedId
    private ScreeningKey screeningKey;

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime   startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime   endTime;


}
