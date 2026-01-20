package com.consensus.demo.domain.market;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class MarketState {

  Long marketId;
  double yesShares;
  double noShares;
  double liquidity;

}
