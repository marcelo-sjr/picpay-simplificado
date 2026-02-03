package com.picpay.picpay_simplificado.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "db_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id", nullable = false, unique = true)
    private UUID public_id;

    @Column(name = "time_stamp", nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private BigDecimal ammount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "payer_id",
            nullable = false
    )
    private User payer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "payee_id",
            nullable = false
    )
    private User payee;

    @PrePersist
    public void generatePublicId() {
        if (public_id == null) {
            public_id = UUID.randomUUID();
        }
    }
}
