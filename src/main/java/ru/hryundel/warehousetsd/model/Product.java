package ru.hryundel.warehousetsd.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String barcode;

    public Product() {}
    public Product(String name, String barcode) { this.name = name; this.barcode = barcode; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBarcode() { return barcode; }
}
