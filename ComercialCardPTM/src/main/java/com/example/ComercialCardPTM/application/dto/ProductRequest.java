package com.example.ComercialCardPTM.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductRequest {
    @NotBlank
    public String name;

    public String description;

    @NotNull @Min(0)
    public BigDecimal price;

    @Min(0)
    public int stock;
}
