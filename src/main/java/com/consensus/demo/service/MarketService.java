package com.consensus.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consensus.demo.domain.market.Market;
import com.consensus.demo.domain.market.MarketState;
import com.consensus.demo.dto.request.CreateMarketRequest;
import com.consensus.demo.repository.MarketRepository;
import com.consensus.demo.repository.MarketStateRepository;
import com.consensus.demo.utils.utils;

import jakarta.transaction.Transactional;
@Service

public class MarketService {
    @Autowired
    MarketStateRepository marketStateRepository;
    @Autowired
    MarketRepository marketRepository;
    
    @Transactional
    public Long CreateMarket(CreateMarketRequest request) {

        
        if (!utils.validateExpiry(request.getExpiryTime())) {
            throw new IllegalArgumentException("Expiry time must be in the future");
        }
        Market market=new Market(request.getQuestion(),request.getDescription(),request.getExpiryTime());
        Market savedMarket=marketRepository.save(market);

        double initialShares=request.getLiquidity()*Math.log(2);
        MarketState marketState=new MarketState(savedMarket.getId(),initialShares,initialShares,request.getLiquidity());

        marketStateRepository.save(marketState);


        return savedMarket.getId(); 
    }
    public Market getMarketById(Long marketId) {
        return marketRepository.findById(marketId)
                .orElseThrow(() -> new IllegalArgumentException("Market not found with id: " + marketId));
    }
    public MarketState getMarketStateById(Long marketId) {
        return marketStateRepository.findById(marketId)
                .orElseThrow(() -> new IllegalArgumentException("MarketState not found with id: " + marketId));
    }
}
