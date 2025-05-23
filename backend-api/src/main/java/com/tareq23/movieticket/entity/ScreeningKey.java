package com.tareq23.movieticket.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ScreeningKey {

    @Column(name = "CINEMA_ID", nullable = false)
    private Integer cinemaId;

    @Column(name = "AUDITORIUM_ID", nullable = false)
    private Integer auditoriumId;

    @Column(name = "SCREENING_SL", nullable = false)
    private Integer screeningSl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScreeningKey)) return false;
        ScreeningKey that = (ScreeningKey) o;
        return Objects.equals(cinemaId, that.cinemaId) &&
                Objects.equals(auditoriumId, that.auditoriumId) &&
                Objects.equals(screeningSl, that.screeningSl);
    }

    @Override
    public int hashCode(){
        return Objects.hash(cinemaId, auditoriumId, screeningSl);
    }
}
