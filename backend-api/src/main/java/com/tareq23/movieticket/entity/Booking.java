package com.tareq23.movieticket.entity;

import com.tareq23.movieticket.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "BOOKINGS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence_generator")
    @SequenceGenerator(name = "booking_sequence_generator", sequenceName = "BOOKING_SEQ", allocationSize = 1)
    @Column(name = "BOOKING_ID", nullable = false)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "screening_ref", nullable = false)
    @Max(15)
    private String screeningRef;

    @Column(name = "BOOKING_TIME", nullable = false)
    private LocalDateTime bookingTime;

    @Column(name = "TOTAL_AMOUNT", nullable = false)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private BookingStatus status;



}
