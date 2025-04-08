package com.signalflow.algotrader.Repository;

import com.signalflow.algotrader.Models.TradeSignal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeSignalRepo extends JpaRepository<TradeSignal, Integer> {
    // You can add custom query methods here if needed later
    TradeSignal save(TradeSignal tradeSignal);
}
