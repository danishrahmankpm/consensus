package com.consensus.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PricingService {

    /**
     * LMSR cost function:
     * C(q_yes, q_no) = b * ln( exp(q_yes / b) + exp(q_no / b) )
     */
    public double cost(double yesShares, double noShares, double liquidity) {
        return liquidity * Math.log(
                Math.exp(yesShares / liquidity) +
                Math.exp(noShares / liquidity)
        );
    }

    /**
     * Cost paid when buying YES shares
     */
    public double costToBuyYes(
            double yesShares,
            double noShares,
            double quantity,
            double liquidity
    ) {
        double oldCost = cost(yesShares, noShares, liquidity);
        double newCost = cost(yesShares + quantity, noShares, liquidity);
        return newCost - oldCost;
    }

    /**
     * Cost paid when buying NO shares
     */
    public double costToBuyNo(
            double yesShares,
            double noShares,
            double quantity,
            double liquidity
    ) {
        double oldCost = cost(yesShares, noShares, liquidity);
        double newCost = cost(yesShares, noShares + quantity, liquidity);
        return newCost - oldCost;
    }

    /**
     * Current YES price
     */
    public double yesPrice(double yesShares, double noShares, double liquidity) {
        double expYes = Math.exp(yesShares / liquidity);
        double expNo  = Math.exp(noShares / liquidity);
        return expYes / (expYes + expNo);
    }

    /**
     * Current NO price
     */
    public double noPrice(double yesShares, double noShares, double liquidity) {
        return 1.0 - yesPrice(yesShares, noShares, liquidity);
    }

    /**
     * Initial shares to start market at 0.5 / 0.5
     */
    public double initialShares(double liquidity) {
        return liquidity * Math.log(2);
    }
}

