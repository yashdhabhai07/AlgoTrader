package com.signalflow.algotrader.Repository;

import com.signalflow.algotrader.Models.TradeSignal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradeSignalRepo extends JpaRepository<TradeSignal, Integer> {
    // You can add custom query methods here if needed later
    TradeSignal save(TradeSignal tradeSignal);

    void deleteById(Long id);
    List<TradeSignal> findAll();

    Optional<TradeSignal> findTradeSignalById(Long id);
}
