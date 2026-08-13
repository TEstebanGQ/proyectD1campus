package com.pruebad1.proyectD1campus.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public record VentasResponse(
        Long id,
        Date fecha,
        BigDecimal total
) {
}
