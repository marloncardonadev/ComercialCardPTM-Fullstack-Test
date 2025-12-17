package com.example.ComercialCardPTM.domain.service;

import com.example.ComercialCardPTM.domain.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductDomainService {
    public BigDecimal totalInventoryValue(List<Product> products) {
        return products.stream()
                .map(Product::inventoryValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Product maxInventoryValueProduct(List<Product> products) {
        return products.stream()
                .max((a, b) -> a.inventoryValue().compareTo(b.inventoryValue()))
                .orElse(null);
    }

    public record Combination(List<String> names, BigDecimal sum) {}

    public List<Combination> findValidCombinations(
            List<Product> products,
            BigDecimal budget
    ) {
        List<Combination> result = new ArrayList<>();

        int n = products.size();

        // Combinaciones de 2
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                addIfValid(products.get(i), products.get(j), budget, result);
            }
        }

        // Combinaciones de 3
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    addIfValid(products.get(i), products.get(j), products.get(k), budget, result);
                }
            }
        }

        return result.stream()
                .sorted(Comparator.comparing(Combination::sum).reversed())
                .limit(5)
                .toList();
    }

    private void addIfValid(
            Product a,
            Product b,
            BigDecimal budget,
            List<Combination> result
    ) {
        BigDecimal sum = a.getPrice().add(b.getPrice());
        if (sum.compareTo(budget) <= 0) {
            result.add(new Combination(
                    List.of(a.getName(), b.getName()),
                    sum
            ));
        }
    }

    private void addIfValid(
            Product a,
            Product b,
            Product c,
            BigDecimal budget,
            List<Combination> result
    ) {
        BigDecimal sum = a.getPrice()
                .add(b.getPrice())
                .add(c.getPrice());

        if (sum.compareTo(budget) <= 0) {
            result.add(new Combination(
                    List.of(a.getName(), b.getName(), c.getName()),
                    sum
            ));
        }
    }
}
