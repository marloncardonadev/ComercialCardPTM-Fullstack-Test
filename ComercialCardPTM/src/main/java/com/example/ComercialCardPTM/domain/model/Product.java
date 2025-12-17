package com.example.ComercialCardPTM.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int stock;

    public Product(Long id, String name, String description, BigDecimal price, int stock) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (price == null || price.signum() < 0) throw new IllegalArgumentException("price must be >= 0");
        if (stock < 0) throw new IllegalArgumentException("stock must be >= 0");

        this.id = id;
        this.name = name.trim();
        this.description = description == null ? "" : description.trim();
        this.price = price;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }

    public BigDecimal inventoryValue() {
        return price.multiply(BigDecimal.valueOf(stock));
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product that)) return false;
        return Objects.equals(id, that.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
