package ru.hryundel.warehousetsd.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hryundel.warehousetsd.dto.*;
import ru.hryundel.warehousetsd.service.ReceivingService;

@RestController
@RequestMapping("/api/receiving")
public class ReceivingController {
    private final ReceivingService receivingService;
    public ReceivingController(ReceivingService receivingService) { this.receivingService = receivingService; }

    @PostMapping
    public ResponseEntity<ReceivingResponse> receive(@Valid @RequestBody ReceivingRequest request) {
        return ResponseEntity.ok(receivingService.receive(request));
    }
}
