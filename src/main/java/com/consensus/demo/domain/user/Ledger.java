package com.consensus.demo.domain.user;



import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "ledger")
@Data
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private double delta; // +credit, -debit

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private Instant createdAt;

    protected Ledger() {}

    public Ledger(Long userId, double delta, String reason) {
        this.userId = userId;
        this.delta = delta;
        this.reason = reason;
        this.createdAt = Instant.now();
    }

    
}

