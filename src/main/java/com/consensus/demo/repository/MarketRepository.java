package com.consensus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consensus.demo.domain.market.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}