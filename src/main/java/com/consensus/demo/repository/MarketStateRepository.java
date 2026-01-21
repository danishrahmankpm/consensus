package com.consensus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consensus.demo.domain.market.MarketState;

@Repository
public interface MarketStateRepository extends JpaRepository<MarketState, Long> {

    
}
