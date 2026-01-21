package com.consensus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.consensus.demo.domain.trade.Trade;
import com.consensus.demo.dto.request.BuyTradeRequest;
import com.consensus.demo.service.TradeService;

public class TradeController {
    @Autowired
    TradeService tradeService;
    public ResponseEntity<Trade> placeTrade(BuyTradeRequest request) {
        Trade trade=tradeService.executeTrade(request.getUserId(), request.getMarketId(), request.getAmount(), request.getTradeType());

        return ResponseEntity.ok(trade);
    }
}
