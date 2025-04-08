package com.signalflow.algotrader.Services;

import com.signalflow.algotrader.Models.TradeSignal;
import com.signalflow.algotrader.Repository.TradeSignalRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfTradeSignalService")
public class SelfTradeSignalService implements TradeSignalService {

    private TradeSignalRepo tradeSignalRepo;
    public SelfTradeSignalService(TradeSignalRepo tradeSignalRepo) {
        this.tradeSignalRepo = tradeSignalRepo;
    }

    @Override
    public TradeSignal saveSignal(TradeSignal signal) {
        return tradeSignalRepo.save(signal);
    }

    @Override
    public List<TradeSignal> getAllSignals() {
        return List.of();
    }
}
