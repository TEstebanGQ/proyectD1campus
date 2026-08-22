package com.pruebad1.proyectD1campus.dto.response;

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
public class VentaResponse {
    private Long id;
    private Date fecha;
    private BigDecimal total;

    public Long id() { return id; }
    public Date fecha() { return fecha; }
    public BigDecimal total() { return total; }
}
