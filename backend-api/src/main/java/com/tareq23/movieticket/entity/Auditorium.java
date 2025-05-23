package com.tareq23.movieticket.entity;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "AUDITORIUMS")
public class Auditorium {

    @EmbeddedId
    private AuditoriumKey id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CAPACITY", nullable = false)
    private Integer capacity;

}
