package com.pruebad1.proyectD1campus.dto.request;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DetalleVentaRequest(
        @NotNull(message = "La venta no puede ser nula")
        @Positive(message = "El codigo de venta debe ser positivo")
        Long ventaId,

        @NotNull(message = "El producto no puede ser nula")
        @Positive(message = "El codigo de producto debe ser positivo")
        Long productoId,

        @NotNull(message = "El total no puede estar nulo")
        @Positive(message = "El total debe ser positivo")
        @Digits(integer = 10, fraction = 2, message = "El total debe tener maximo 10 digitos")
        Double cantidad,

        @NotNull(message = "El total no puede estar nulo")
        @Positive(message = "El total debe ser positivo")
        @Digits(integer = 10, fraction = 2, message = "El total debe tener maximo 10 digitos")
        BigDecimal subtotal

) {
}