package com.pruebad1.proyectD1campus.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class VentasResponse extends VentaResponse {
    public VentasResponse(Long id, Date fecha, BigDecimal total) {
        super(id, fecha, total);
    }
}
