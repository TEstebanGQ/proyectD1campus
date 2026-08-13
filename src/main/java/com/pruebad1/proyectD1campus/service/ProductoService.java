package com.pruebad1.proyectD1campus.service;

import com.pruebad1.proyectD1campus.dto.response.ProductoResponse;
import com.pruebad1.proyectD1campus.dto.request.ProductResquest;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoService {
    ProductoResponse guardar(ProductResquest dto);
    List<ProductoResponse> obtenerTodas();
    ProductoResponse obtenerPorId(Long id);
    ProductoResponse actualizarProducto(Long id, ProductResquest dto);
    void eliminarProducto(Long id);
    List<ProductoResponse> buscarPorNombre(String nombre);
    List<ProductoResponse> filtrarPrecioVentaMayorQue(BigDecimal precio);
    List<ProductoResponse> filtrarPrecioVentaMenorQue(BigDecimal precio);
    List<ProductoResponse> filtrarPrecioVentaEntre(BigDecimal precio1, BigDecimal precio2);
    List<ProductoResponse> filtrarPorNombreYPrecioVentaMayorQue(String nombre, BigDecimal precio);
}
