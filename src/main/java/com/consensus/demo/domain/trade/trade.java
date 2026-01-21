package com.consensus.demo.domain.trade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "trades")
@Data
@AllArgsConstructor

public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long marketId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeType tradeType;

    @Column(nullable = false)
    private double quantity;   

    @Column(nullable = false)
    private double cost;       

    @Column(nullable = false)
    private Instant createdAt;

    public Trade(Long userId, Long marketId, TradeType tradeType, double quantity, double cost) {
        this.userId = userId;
        this.marketId = marketId;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.cost = cost;
        this.createdAt = Instant.now();
    }
}