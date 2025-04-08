package com.signalflow.algotrader.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "trade_signals")
public class TradeSignal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String signalType; // e.g., BUY / SELL
    private LocalDateTime signalDate;
    private Double price;
}
