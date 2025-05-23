package com.tareq23.movieticket.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class AuditoriumKey {


    @Column(name = "cinema_id", nullable = false)
    private Integer cinemaId;


    @Column(name = "auditorium_id", nullable = false)
    private Integer auditoriumId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditoriumKey that)) return false;

        return Objects.equals(cinemaId, that.cinemaId) &&
                Objects.equals(auditoriumId, that.auditoriumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaId, auditoriumId);
    }

}
