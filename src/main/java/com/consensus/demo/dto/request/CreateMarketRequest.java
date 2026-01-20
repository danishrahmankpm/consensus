package com.consensus.demo.dto.request;

import java.time.LocalDateTime;

public class CreateMarketRequest {
    
    String question;
    String description;
    LocalDateTime expiryTime;
    double initialYesPrice;
    double liquidity;

}
