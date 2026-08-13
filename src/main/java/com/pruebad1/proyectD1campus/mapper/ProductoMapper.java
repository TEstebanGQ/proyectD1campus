package com.pruebad1.proyectD1campus.mapper;

import com.pruebad1.proyectD1campus.dto.request.ProductResquest;
import com.pruebad1.proyectD1campus.dto.response.ProductoResponse;
import com.pruebad1.proyectD1campus.model.Producto;
import org.springframework.stereotype.Component;

@Component

public class ProductoMapper {

    public ProductoResponse entityToDto(Producto producto) {
        if (producto == null) {
            return null;
        }
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta()
        );

    }

    public Producto dtoToEntity(ProductResquest dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setPrecioVenta(dto.precioVenta());
        return producto;
    }

    public void updateEntityFromDto(Producto producto, ProductResquest dto) {
        if (dto == null || producto == null) {
            return;
        }

        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setPrecioVenta(dto.precioVenta());
    }

}
