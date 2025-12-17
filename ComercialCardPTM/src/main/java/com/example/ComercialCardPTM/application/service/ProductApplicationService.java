package com.example.ComercialCardPTM.application.service;

import com.example.ComercialCardPTM.api.error.NotFoundException;
import com.example.ComercialCardPTM.application.dto.InventorySummaryResponse;
import com.example.ComercialCardPTM.application.dto.ProductRequest;
import com.example.ComercialCardPTM.application.dto.ProductResponse;
import com.example.ComercialCardPTM.application.mapper.ProductMapper;
import com.example.ComercialCardPTM.domain.model.Product;
import com.example.ComercialCardPTM.domain.repository.ProductRepository;
import com.example.ComercialCardPTM.domain.service.ProductDomainService;
import com.example.ComercialCardPTM.application.dto.CombinationItemResponse;
import com.example.ComercialCardPTM.application.dto.CombinationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductApplicationService {
    private final ProductRepository repository;
    private final ProductDomainService domainService = new ProductDomainService();

    public ProductApplicationService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProductResponse create(ProductRequest req) {
        var domain = new Product(null, req.name, req.description, req.price, req.stock);
        var saved = repository.save(domain);
        return ProductMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> list() {
        return repository.findAll().stream().map(ProductMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        var p = repository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        return ProductMapper.toResponse(p);
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest req) {
        if (!repository.existsById(id)) throw new NotFoundException("Product not found: " + id);
        var domain = new Product(id, req.name, req.description, req.price, req.stock);
        var saved = repository.save(domain);
        return ProductMapper.toResponse(saved);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) throw new NotFoundException("Product not found: " + id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public InventorySummaryResponse inventorySummary() {
        var products = repository.findAll();
        var total = domainService.totalInventoryValue(products);
        var max = domainService.maxInventoryValueProduct(products);

        var resp = new InventorySummaryResponse();
        resp.totalInventoryValue = total;
        resp.maxInventoryValueProduct = (max == null) ? null : ProductMapper.toResponse(max);
        return resp;
    }

    @Transactional(readOnly = true)
    public List<CombinationItemResponse> combinations(CombinationRequest req) {

        var products = repository.findAll();

        return domainService.findValidCombinations(products, req.budget)
                .stream()
                .map(c -> {
                    var r = new CombinationItemResponse();
                    r.productNames = c.names();
                    r.sumPrices = c.sum();
                    return r;
                })
                .toList();
    }
}
