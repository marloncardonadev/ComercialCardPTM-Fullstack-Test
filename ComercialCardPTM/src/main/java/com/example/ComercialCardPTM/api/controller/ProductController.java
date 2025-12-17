package com.example.ComercialCardPTM.api.controller;

import com.example.ComercialCardPTM.application.dto.InventorySummaryResponse;
import com.example.ComercialCardPTM.application.dto.ProductRequest;
import com.example.ComercialCardPTM.application.dto.ProductResponse;
import com.example.ComercialCardPTM.application.service.ProductApplicationService;
import com.example.ComercialCardPTM.application.dto.CombinationItemResponse;
import com.example.ComercialCardPTM.application.dto.CombinationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductApplicationService service;

    public ProductController(ProductApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inventory/summary")
    public ResponseEntity<InventorySummaryResponse> inventorySummary() {
        return ResponseEntity.ok(service.inventorySummary());
    }

    @PostMapping("/combinations")
    public ResponseEntity<List<CombinationItemResponse>> combinations(
            @Valid @RequestBody CombinationRequest request
    ) {
        return ResponseEntity.ok(service.combinations(request));
    }
}
