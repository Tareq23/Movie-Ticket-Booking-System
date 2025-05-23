package com.tareq23.movieticket.entity;

import com.tareq23.movieticket.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SEATS")
public class Seat {

    @EmbeddedId
    private SeatKey seatKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 10)
    private SeatType seatType;


}
