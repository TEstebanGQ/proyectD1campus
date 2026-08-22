package com.pruebad1.proyectD1campus.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequest {
    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;

    @NotNull(message = "El precio de venta no puede estar nulo")
    @Positive(message = "El precio de venta debe ser postivo")
    @Digits(integer = 10, fraction = 2, message = "El precio de venta debe tner maximo 10 numeros y dos decimales")
    private BigDecimal total;

    public Date fecha() { return fecha; }
    public BigDecimal total() { return total; }
}
