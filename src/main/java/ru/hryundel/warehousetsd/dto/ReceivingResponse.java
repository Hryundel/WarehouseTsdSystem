package ru.hryundel.warehousetsd.dto;

public record ReceivingResponse(Long operationId, String message, boolean discrepancy) {}
