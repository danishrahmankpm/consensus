package com.consensus.demo.domain.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wallets")
@Data
public class Wallet {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private double balance;

    @Version
    private Long version; // optimistic locking fallback

    protected Wallet() {}

    public Wallet(Long userId, double initialBalance) {
        this.userId = userId;
        this.balance = initialBalance;
    }

    public void debit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Debit amount must be positive");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        this.balance += amount;
    }

    
}

