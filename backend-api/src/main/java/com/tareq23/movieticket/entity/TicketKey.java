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
public class TicketKey {


    @Column(name = "CINEMA_ID", nullable = false)
    private Integer cinemaId;

    @Column(name = "AUDITORIUM_ID", nullable = false)
    private Integer auditoriumId;

    @Column(name = "ROW", nullable = false, length = 3)
    private String row;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketKey)) return false;
        TicketKey that = (TicketKey) o;
        return Objects.equals(cinemaId, that.cinemaId) &&
                Objects.equals(auditoriumId, that.auditoriumId) &&
                Objects.equals(row, that.row) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaId, auditoriumId, row, number);
    }
}
