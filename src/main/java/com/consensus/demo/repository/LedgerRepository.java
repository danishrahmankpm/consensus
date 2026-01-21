package com.consensus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consensus.demo.domain.user.Ledger;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {
    
}
