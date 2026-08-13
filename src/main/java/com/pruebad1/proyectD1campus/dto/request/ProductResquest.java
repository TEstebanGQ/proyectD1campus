package com.pruebad1.proyectD1campus.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductResquest(
        @NotBlank(message = "No se permite el nombre vacio")
        @Size(min = 2, max = 50, message = "Error el nombre debe de tener entre 2 y 50 caracteres")
        String nombre,
        @NotBlank(message = "No se permite la descripcion")
        @Size(min = 2, max = 50, message = "Error el nombre debe de tener entre 2 y 50 caracteres")
        String descripcion,
        @NotNull(message = "El precio de compra no puede estar nulo")
        @Positive(message = "El precio de compra debe ser postivo")
        @Digits(integer = 10, fraction = 2, message = "El precio puede tener mas de 2 numeros")
        BigDecimal precioCompra,
        @NotNull(message = "El precio de venta no puede estar nulo")
        @Positive(message = "El precio de venta debe ser postivo")
        @Digits(integer = 10, fraction = 2, message = "El precio de venta debe tner maximo 10 numeros y dos decimales")
        BigDecimal precioVenta) {
}
