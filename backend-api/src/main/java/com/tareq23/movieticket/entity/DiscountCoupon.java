package com.tareq23.movieticket.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "DISCOUNT_COUPONS")
public class DiscountCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_coupon_sequence_generator")
    @SequenceGenerator(name = "discount_coupon_sequence_generator", sequenceName = "DISCOUNT_COUPON_SEQ", allocationSize = 1)
    @Column(name = "discount_id", nullable = false)
    private Integer id;

    @Column(name = "code", unique = true, nullable = false, length = 50)
    private String code;

    @Column(name = "discount_type", nullable = false)
    private String discountType;

    @Column(name = "discount_value", nullable = false)
    private BigDecimal  discountValue;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "max_uses")
    @ColumnDefault("0")
    private Integer maxUses;

    @Column(name = "current_uses")
    @ColumnDefault("0")
    private Integer currentUses;

    @Column(name = "min_order_amount")
    @ColumnDefault("0")
    private BigDecimal minOrderAmount;

    @Column(name = "is_active")
    @ColumnDefault("true")
    private boolean isActive;

}
