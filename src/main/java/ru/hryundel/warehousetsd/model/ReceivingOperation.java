package ru.hryundel.warehousetsd.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReceivingOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentNumber;
    @ManyToOne private Product product;
    @ManyToOne private StockCell cell;
    private int quantity;
    private boolean discrepancy;
    private LocalDateTime createdAt = LocalDateTime.now();

    public ReceivingOperation() {}
    public ReceivingOperation(String documentNumber, Product product, StockCell cell, int quantity, boolean discrepancy) {
        this.documentNumber = documentNumber; this.product = product; this.cell = cell; this.quantity = quantity; this.discrepancy = discrepancy;
    }
    public Long getId() { return id; }
    public boolean isDiscrepancy() { return discrepancy; }
}
