package com.example.sales_system_sm.Brand.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoBrandAswer(

        Long id,
        @NotBlank
        String nameBrand,
        @NotNull
        Boolean deleted
) {
}
