package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TICKETS")
public class Ticket {

    @EmbeddedId
    private TicketKey id;

    @Column(name = "BOOKING_ID", nullable = false)
    private Long bookingId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;




}
