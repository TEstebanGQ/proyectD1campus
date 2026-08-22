package com.pruebad1.proyectD1campus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaResponse {
    private Long id;
    private VentasResponse venta;
    private ProductoResponse producto;
    private Double cantidad;
    private BigDecimal subtotal;

    public Long id() { return id; }
    public VentasResponse venta() { return venta; }
    public ProductoResponse producto() { return producto; }
    public Double cantidad() { return cantidad; }
    public BigDecimal subtotal() { return subtotal; }
}
