package com.example.sales_system_sm.Brand.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoUpdate(

        Long id,
        @NotBlank
        String nameBrand


       )

{
}
