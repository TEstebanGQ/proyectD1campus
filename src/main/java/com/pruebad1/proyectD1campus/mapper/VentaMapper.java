package com.pruebad1.proyectD1campus.mapper;

import com.pruebad1.proyectD1campus.dto.request.VentaRequest;
import com.pruebad1.proyectD1campus.dto.response.VentasResponse;
import com.pruebad1.proyectD1campus.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {

    public VentasResponse entityToDto(Venta venta) {
        if (venta == null) return null;

        return new VentasResponse(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal()
        );
    }

    public Venta dtoToEntity(VentaRequest dto) {
        if (dto == null) return null;

        Venta v = new Venta();
        v.setFecha(dto.fecha());
        v.setTotal(dto.total());

        return v;
    }

    public void updateEntityFromDto(Venta venta, VentaRequest dto) {
        if (dto == null || venta == null) return;

        venta.setFecha(dto.fecha());
        venta.setTotal(dto.total());
    }
}