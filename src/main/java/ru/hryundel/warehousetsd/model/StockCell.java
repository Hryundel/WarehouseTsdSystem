package ru.hryundel.warehousetsd.model;

import jakarta.persistence.*;

@Entity
public class StockCell {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    public StockCell() {}
    public StockCell(String code) { this.code = code; }
    public Long getId() { return id; }
    public String getCode() { return code; }
}
