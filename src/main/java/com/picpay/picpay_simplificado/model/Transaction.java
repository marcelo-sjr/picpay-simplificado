package com.picpay.picpay_simplificado.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
