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
    @Override
    public TradeSignal updateSignal(Long id, TradeSignal updatedSignal) {
        TradeSignal savedSignal = tradeSignalRepo.findTradeSignalById(id)
                .orElseThrow( () -> new TradeSignalNotFoundException("TradeSignal not found with id: " + id ));
        savedSignal.setSignalDate(updatedSignal.getSignalDate());
        savedSignal.setSignalType(updatedSignal.getSignalType());
        savedSignal.setQuantity(updatedSignal.getQuantity());
        savedSignal.setPrice(updatedSignal.getPrice());
        return tradeSignalRepo.save(savedSignal);
    }
}
