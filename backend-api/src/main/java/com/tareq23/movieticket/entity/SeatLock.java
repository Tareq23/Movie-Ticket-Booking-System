package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "seat_locks")
public class SeatLock {
    @Id
    @Column(name = "seat_ref")
    private String seatRef;

    @Column(name = "screening_ref", nullable = false)
    private String screeningRef;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "expires_at", nullable = false)
    private Instant expiresAt;

}
