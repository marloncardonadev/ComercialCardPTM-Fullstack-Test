package com.example.ComercialCardPTM.infrastructure.persistence.mapper;

import com.example.ComercialCardPTM.domain.model.Product;
import com.example.ComercialCardPTM.infrastructure.persistence.entity.ProductEntity;

public class ProductEntityMapper {
    public static Product toDomain(ProductEntity e) {
        return new Product(e.getId(), e.getName(), e.getDescription(), e.getPrice(), e.getStock());
    }

    public static ProductEntity toEntity(Product d) {
        var e = new ProductEntity();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setPrice(d.getPrice());
        e.setStock(d.getStock());
        return e;
    }
}
