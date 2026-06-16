package ru.hryundel.warehousetsd.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hryundel.warehousetsd.dto.*;
import ru.hryundel.warehousetsd.model.*;
import ru.hryundel.warehousetsd.repository.*;

@Service
public class ReceivingService {
    private final ProductRepository productRepository;
    private final StockCellRepository stockCellRepository;
    private final ReceivingOperationRepository operationRepository;

    public ReceivingService(ProductRepository productRepository, StockCellRepository stockCellRepository, ReceivingOperationRepository operationRepository) {
        this.productRepository = productRepository;
        this.stockCellRepository = stockCellRepository;
        this.operationRepository = operationRepository;
    }

    @Transactional
    public ReceivingResponse receive(ReceivingRequest request) {
        Product product = productRepository.findByBarcode(request.getBarcode())
                .orElseThrow(() -> new IllegalArgumentException("Товар не найден"));
        StockCell cell = stockCellRepository.findByCode(request.getCellCode())
                .orElseThrow(() -> new IllegalArgumentException("Ячейка не найдена"));
        boolean discrepancy = request.getQuantity() != 10;
        ReceivingOperation operation = new ReceivingOperation(request.getDocumentNumber(), product, cell, request.getQuantity(), discrepancy);
        ReceivingOperation saved = operationRepository.save(operation);
        return new ReceivingResponse(saved.getId(), "Приемка товара успешно сохранена", discrepancy);
    }
}
