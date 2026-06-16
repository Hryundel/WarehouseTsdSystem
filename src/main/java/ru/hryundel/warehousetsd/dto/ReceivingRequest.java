package ru.hryundel.warehousetsd.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ReceivingRequest {
    @NotBlank private String documentNumber;
    @NotBlank private String barcode;
    @Min(1) private int quantity;
    @NotBlank private String cellCode;

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getCellCode() { return cellCode; }
    public void setCellCode(String cellCode) { this.cellCode = cellCode; }
}
