package com.pruebad1.proyectD1campus.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponse(
    Long id,
    VentasResponse venta,
    ProductoResponse producto,
    Double cantidad,
    BigDecimal subtotal
)
{}

