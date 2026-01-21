package com.consensus.demo.controller;

import org.springframework.stereotype.Controller;

import com.consensus.demo.domain.market.MarketStatus;
import com.consensus.demo.dto.request.CreateMarketRequest;
import com.consensus.demo.dto.response.MarketResponse;
import com.consensus.demo.service.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Controller
public class MarketController {
    @Autowired
    MarketService marketService;
    

    public ResponseEntity<MarketResponse> createMarket(CreateMarketRequest request) {
        Long marketId = marketService.CreateMarket(request);
       
        MarketResponse response = new MarketResponse(marketId, MarketStatus.OPEN);
        return ResponseEntity.ok(response);
    }
}
