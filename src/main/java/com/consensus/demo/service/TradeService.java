package com.consensus.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.consensus.demo.domain.market.Market;
import com.consensus.demo.domain.market.MarketState;
import com.consensus.demo.domain.trade.Trade;
import com.consensus.demo.domain.trade.TradeType;

public class TradeService {
    @Autowired
    MarketService marketService;
    @Autowired
    PricingService pricingService;
    @Autowired
    WalletService walletService;
    @Autowired
    TradeService tradeService;
    
    public Trade executeTrade(Long userId, Long marketId, Double amount, TradeType tradeType) {
        // Trade execution logic
        try{
            Market market = marketService.getMarketById(marketId);
        }
        catch(Exception e){
           throw e;
        }
        MarketState marketState = marketService.getMarketStateById(marketId);
        double price;
        if(tradeType==TradeType.BUY){
            price=pricingService.costToBuyYes(marketState.getYesShares(), marketState.getNoShares(), amount, marketState.getLiquidity());
        }
        else{
            price=pricingService.costToBuyNo(marketState.getYesShares(), marketState.getNoShares(), amount, marketState.getLiquidity());
        }

        walletService.debit(userId, price, tradeType.toString(), userId);

        return new Trade(userId, marketState.getMarketId(), tradeType, amount, price);
    }
    
}
