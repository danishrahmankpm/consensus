package com.consensus.demo.service;

import com.consensus.demo.domain.user.Ledger;
import com.consensus.demo.domain.user.Wallet;
import com.consensus.demo.repository.LedgerRepository;
import com.consensus.demo.repository.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final LedgerRepository ledgerRepository;

    public WalletService(WalletRepository walletRepository,
                         LedgerRepository ledgerRepository) {
        this.walletRepository = walletRepository;
        this.ledgerRepository = ledgerRepository;
    }

    /**
     * Locks and returns wallet for update.
     * Must be called inside a transaction.
     */
    public Wallet getWalletForUpdate(Long userId) {
        try {
            walletRepository.findByUserId(userId);
        } catch (Exception e) {
            throw e;
        } 
        return walletRepository.findByUserId(userId);
    }

    /**
     * Debit wallet and record ledger entry.
     */
    @Transactional
    public void debit(Long userId,
                      double amount,
                      String reason,
                      Long marketId,
                      Long tradeId) {

        Wallet wallet = getWalletForUpdate(userId);

        wallet.debit(amount);
        walletRepository.save(wallet);

        ledgerRepository.save(
                new Ledger(userId, -amount, reason, marketId, tradeId)
        );
    }

    /**
     * Credit wallet and record ledger entry.
     */
    @Transactional
    public void credit(Long userId,
                       double amount,
                       String reason,
                       Long marketId,
                       Long tradeId) {

        Wallet wallet = getWalletForUpdate(userId);

        wallet.credit(amount);
        walletRepository.save(wallet);

        ledgerRepository.save(
                new Ledger(userId, amount, reason, marketId, tradeId)
        );
    }
}
