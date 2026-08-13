package com.pruebad1.proyectD1campus.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Date;

public record VentaRequest(
        @NotNull(message = "La fecha no puede ser nula")
        Date fecha,
        @NotNull(message = "El precio de venta no puede estar nulo")
        @Positive(message = "El precio de venta debe ser postivo")
        @Digits(integer = 10, fraction = 2, message = "El precio de venta debe tner maximo 10 numeros y dos decimales")
        BigDecimal total
) {
}
