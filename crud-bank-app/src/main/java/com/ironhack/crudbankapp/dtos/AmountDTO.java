package com.ironhack.crudbankapp.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class AmountDTO {
    @Max(value = 1000000, message = "The amount cannot be more than 400 dollars")
    @Min(value = 0, message = "The amount cannot be less than 0 dollars")
    private Double amount;

    public AmountDTO() {
    }

    public AmountDTO(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
