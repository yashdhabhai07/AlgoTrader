package com.signalflow.algotrader.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "trade_signals")
public class TradeSignal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String signalType;// e.g., BUY / SELL
    private Long quantity;
    private LocalDateTime signalDate;
    private Double price;
}
