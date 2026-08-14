package com.pruebad1.proyectD1campus.mapper;

import com.pruebad1.proyectD1campus.dto.request.DetalleVentaRequest;
import com.pruebad1.proyectD1campus.dto.response.DetalleVentaResponse;
import com.pruebad1.proyectD1campus.dto.response.ProductoResponse;
import com.pruebad1.proyectD1campus.dto.response.VentasResponse;
import com.pruebad1.proyectD1campus.model.DetalleVenta;
import com.pruebad1.proyectD1campus.model.Producto;
import com.pruebad1.proyectD1campus.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {

    private final VentaMapper ventaMapper;
    private final ProductoMapper productoMapper;

    public DetalleVentaMapper(VentaMapper ventaMapper, ProductoMapper productoMapper) {
        this.ventaMapper = ventaMapper;
        this.productoMapper = productoMapper;
    }

    public DetalleVentaResponse entityToDto(DetalleVenta detalleVenta) {
        if (detalleVenta == null) return null;
        return new DetalleVentaResponse(
                detalleVenta.getId(),
                ventaMapper.entityToDto(detalleVenta.getVenta()),
                productoMapper.entityToDto(detalleVenta.getProducto()),
                detalleVenta.getCantidad(),
                detalleVenta.getSubtotal()
        );
    }

    public DetalleVentaResponse entityToDto(DetalleVenta detalleVenta, VentasResponse ventaResponse, ProductoResponse productoResponse) {
        if (detalleVenta == null) return null;
        return new DetalleVentaResponse(
                detalleVenta.getId(),
                ventaResponse,
                productoResponse,
                detalleVenta.getCantidad(),
                detalleVenta.getSubtotal()
        );
    }

    public DetalleVenta dtoToEntity(DetalleVentaRequest dto, Venta venta, Producto producto) {
        if (dto == null) return null;
        DetalleVenta detalle = new DetalleVenta();
        detalle.setVenta(venta);
        detalle.setProducto(producto);
        detalle.setCantidad(dto.cantidad());
        detalle.setSubtotal(dto.subtotal());
        return detalle;
    }

    public void updateEntityFromDto(DetalleVenta detalleVenta, DetalleVentaRequest dto, Venta venta, Producto producto) {
        if (dto == null || detalleVenta == null) return;
        detalleVenta.setVenta(venta);
        detalleVenta.setProducto(producto);
        detalleVenta.setCantidad(dto.cantidad());
        detalleVenta.setSubtotal(dto.subtotal());
    }
}
