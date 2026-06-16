package ru.hryundel.warehousetsd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hryundel.warehousetsd.dto.ReceivingRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReceivingServiceTest {
    @Autowired private ReceivingService receivingService;

    @Test
    void shouldCreateReceivingOperation() {
        ReceivingRequest request = new ReceivingRequest();
        request.setDocumentNumber("DOC-001");
        request.setBarcode("460000000001");
        request.setQuantity(10);
        request.setCellCode("A-01");
        var response = receivingService.receive(request);
        assertNotNull(response.operationId());
        assertFalse(response.discrepancy());
    }

    @Test
    void shouldDetectUnknownProduct() {
        ReceivingRequest request = new ReceivingRequest();
        request.setDocumentNumber("DOC-001");
        request.setBarcode("999999999999");
        request.setQuantity(10);
        request.setCellCode("A-01");
        assertThrows(IllegalArgumentException.class, () -> receivingService.receive(request));
    }

    @Test
    void shouldDetectDiscrepancy() {
        ReceivingRequest request = new ReceivingRequest();
        request.setDocumentNumber("DOC-001");
        request.setBarcode("460000000001");
        request.setQuantity(8);
        request.setCellCode("A-01");
        var response = receivingService.receive(request);
        assertTrue(response.discrepancy());
    }
}
