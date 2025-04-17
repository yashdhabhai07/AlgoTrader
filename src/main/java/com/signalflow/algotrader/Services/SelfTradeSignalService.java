package com.signalflow.algotrader.Services;

import com.signalflow.algotrader.Exceptions.TradeSignalNotFoundException;
import com.signalflow.algotrader.Models.TradeSignal;
import com.signalflow.algotrader.Repository.TradeSignalRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return tradeSignalRepo.findAll();
    }

    @Override
    @Transactional
    public void deleteSignalById(Long id) {
        tradeSignalRepo.deleteById(id);
    }

    @Override
    public TradeSignal findSignalById(Long id) throws TradeSignalNotFoundException {
        return tradeSignalRepo.findTradeSignalById(id)
                .orElseThrow(() -> new TradeSignalNotFoundException("Trade signal with id " + id + " not found"));
    }


}
