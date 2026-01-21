package com.consensus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consensus.demo.domain.user.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    public Wallet findByUserId(Long userId);
    
}
