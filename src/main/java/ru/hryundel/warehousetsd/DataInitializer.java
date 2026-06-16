package ru.hryundel.warehousetsd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.hryundel.warehousetsd.model.*;
import ru.hryundel.warehousetsd.repository.*;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final StockCellRepository stockCellRepository;

    public DataInitializer(ProductRepository productRepository, StockCellRepository stockCellRepository) {
        this.productRepository = productRepository;
        this.stockCellRepository = stockCellRepository;
    }

    @Override
    public void run(String... args) {
        productRepository.save(new Product("Товар тестовый", "460000000001"));
        stockCellRepository.save(new StockCell("A-01"));
    }
}
