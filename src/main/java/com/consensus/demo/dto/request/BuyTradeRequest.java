package com.consensus.demo.dto.request;


import com.consensus.demo.domain.trade.TradeType;

import lombok.Data;

@Data
public class BuyTradeRequest {
    Long userId;
    Long marketId;
    Double amount;
    TradeType tradeType;
}
