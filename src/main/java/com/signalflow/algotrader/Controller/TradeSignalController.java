package com.signalflow.algotrader.Controller;

import com.signalflow.algotrader.Models.TradeSignal;
import com.signalflow.algotrader.Services.TradeSignalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/signals")
public class    TradeSignalController {
    private TradeSignalService tradeSignalService;
    public TradeSignalController(TradeSignalService tradeSignalService) {
        this.tradeSignalService = tradeSignalService;
    }
    @PostMapping("/create")
    public ResponseEntity<TradeSignal> createSignal(@RequestBody TradeSignal signal) {
        signal.setSignalDate(LocalDateTime.now());
        TradeSignal savedSignal = tradeSignalService.saveSignal(signal);
        return new ResponseEntity<>(savedSignal, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TradeSignal> getSignalById(@PathVariable Long id) {
        TradeSignal signal = tradeSignalService.findSignalById(id);
        return new ResponseEntity<>(signal, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TradeSignal>> getAllTradeSignals() {
        List<TradeSignal> signals = tradeSignalService.getAllSignals();
        return new ResponseEntity<>(signals, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteTradeSignal(@PathVariable("id") Long Id){
        tradeSignalService.deleteSignalById(Id);
    }
}
