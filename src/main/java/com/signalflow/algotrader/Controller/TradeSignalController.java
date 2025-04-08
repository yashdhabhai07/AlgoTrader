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
public class TradeSignalController {
    private TradeSignalService tradeSignalService;
    public TradeSignalController(TradeSignalService tradeSignalService) {
        this.tradeSignalService = tradeSignalService;
    }
    @PostMapping("/create")
    public ResponseEntity<TradeSignal> createSignal(@RequestBody TradeSignal signal) {
        TradeSignal savedSignal = tradeSignalService.saveSignal(signal);
        signal.setSignalDate(LocalDateTime.now());
        return new ResponseEntity<>(savedSignal, HttpStatus.CREATED);
    }
    @GetMapping
    public List<TradeSignal> getAllSignals() {
        return tradeSignalService.getAllSignals();
    }
}
