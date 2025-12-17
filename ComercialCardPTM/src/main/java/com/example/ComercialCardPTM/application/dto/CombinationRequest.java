package com.example.ComercialCardPTM.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CombinationRequest {
    @NotNull
    @Min(0)
    public BigDecimal budget;
}
