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
@Table(name = "CINEMAS")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_sequence_generator")
    @SequenceGenerator(name = "cinema_sequence_generator", sequenceName = "CINEMA_SEQ", allocationSize = 1)
    @Column(name = "CINEMA_ID", nullable = false)
    private Integer id;

    @Column(name = "CINEMA_NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS",columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "FACILITIES", columnDefinition = "TEXT")
    private String facilities;

}
