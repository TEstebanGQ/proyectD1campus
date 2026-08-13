package com.pruebad1.proyectD1campus.dto.response;

import java.math.BigDecimal;

public record ProductoResponse(
        Long id,
        String nombre,
        BigDecimal precioCompra,
        BigDecimal precioVenta
) {
}
