package com.signalflow.algotrader.Services;

import com.signalflow.algotrader.Exceptions.TradeSignalNotFoundException;
import com.signalflow.algotrader.Models.TradeSignal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TradeSignalService {
    TradeSignal saveSignal(TradeSignal signal);
    List<TradeSignal> getAllSignals();
    void deleteSignalById(Long id);
    TradeSignal findSignalById(Long id) throws TradeSignalNotFoundException;
}
