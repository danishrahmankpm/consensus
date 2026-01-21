package com.consensus.demo.domain.market;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Market {
  @Id  
  Long id;
  String question;
  String description;
  LocalDateTime expiryTime;
  MarketStatus status;
  
  public Market(String question, String description, LocalDateTime expiryTime) {
    this.question = question;
    this.description = description;
    this.expiryTime = expiryTime;
    this.status = MarketStatus.OPEN;
  }
    
}
