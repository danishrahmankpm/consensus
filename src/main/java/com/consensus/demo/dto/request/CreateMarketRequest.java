package com.consensus.demo.dto.request;

import java.time.LocalDateTime;

import lombok.Data;



@Data
public class CreateMarketRequest {
    
    private String question;
    private String description;
    private LocalDateTime expiryTime;
    private double initialYesPrice;
    private double liquidity;

    

}
