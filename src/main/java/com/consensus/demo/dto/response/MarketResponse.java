package com.consensus.demo.dto.response;

import com.consensus.demo.domain.market.MarketStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MarketResponse {
    long marketId;
    MarketStatus status;
   
}
