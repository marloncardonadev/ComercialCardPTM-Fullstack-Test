package com.example.ComercialCardPTM.application.mapper;

import com.example.ComercialCardPTM.application.dto.ProductResponse;
import com.example.ComercialCardPTM.domain.model.Product;

public class ProductMapper {
    public static ProductResponse toResponse(Product p) {
        var r = new ProductResponse();
        r.id = p.getId();
        r.name = p.getName();
        r.description = p.getDescription();
        r.price = p.getPrice();
        r.stock = p.getStock();
        r.inventoryValue = p.inventoryValue();
        return r;
    }
}
