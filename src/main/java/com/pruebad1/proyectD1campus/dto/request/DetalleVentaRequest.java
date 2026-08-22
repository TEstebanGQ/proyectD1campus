package com.pruebad1.proyectD1campus.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaRequest {
    @NotNull(message = "La venta no puede ser nula")
    @Positive(message = "El codigo de venta debe ser positivo")
    private Long ventaId;

    @NotNull(message = "El producto no puede ser nula")
    @Positive(message = "El codigo de producto debe ser positivo")
    private Long productoId;

    @NotNull(message = "El total no puede estar nulo")
    @Positive(message = "El total debe ser positivo")
    @Digits(integer = 10, fraction = 2, message = "El total debe tener maximo 10 digitos")
    private Double cantidad;

    @NotNull(message = "El total no puede estar nulo")
    @Positive(message = "El total debe ser positivo")
    @Digits(integer = 10, fraction = 2, message = "El total debe tener maximo 10 digitos")
    private BigDecimal subtotal;

    public Long ventaId() { return ventaId; }
    public Long productoId() { return productoId; }
    public Double cantidad() { return cantidad; }
    public BigDecimal subtotal() { return subtotal; }
}