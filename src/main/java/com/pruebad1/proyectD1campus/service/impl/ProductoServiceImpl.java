package com.pruebad1.proyectD1campus.service.impl;

import com.pruebad1.proyectD1campus.dto.request.ProductResquest;
import com.pruebad1.proyectD1campus.dto.response.ProductoResponse;
import com.pruebad1.proyectD1campus.exception.ResourceNotFoundException;
import com.pruebad1.proyectD1campus.mapper.ProductoMapper;
import com.pruebad1.proyectD1campus.model.Producto;
import com.pruebad1.proyectD1campus.repository.ProductoRepository;
import com.pruebad1.proyectD1campus.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public ProductoResponse guardar(ProductResquest dto) {
        Producto producto = productoMapper.dtoToEntity(dto);
        Producto productoGuardado = productoRepository.save(producto);
        return productoMapper.entityToDto(productoGuardado);
    }

    @Override
    public List<ProductoResponse> obtenerTodas() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(productoMapper::entityToDto).toList();
    }

    @Override
    public ProductoResponse obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con id: " + id));
        return productoMapper.entityToDto(producto);
    }

    @Override
    public ProductoResponse actualizarProducto(Long id, ProductResquest dto) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con id: " + id));
        productoMapper.updateEntityFromDto(producto, dto);
        Producto productoActualizado = productoRepository.save(producto);
        return productoMapper.entityToDto(productoActualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto para eliminar con id: " + id));
        productoRepository.delete(producto);
    }

    @Override
    public List<ProductoResponse> buscarPorNombre(String nombre) {
        List<Producto> productos = productoRepository.findByNombre(nombre);
        return productos.stream().map(productoMapper::entityToDto).toList();
    }

    @Override
    public List<ProductoResponse> filtrarPrecioVentaMayorQue(BigDecimal precio) {
        List<Producto> productos = productoRepository.findByPrecioVentaGreaterThanEqual(precio);
        return productos.stream().map(productoMapper::entityToDto).toList();
    }

    @Override
    public List<ProductoResponse> filtrarPrecioVentaMenorQue(BigDecimal precio) {
        List<Producto> productos = productoRepository.findByPrecioVentaLessThanEqual(precio);
        return productos.stream().map(productoMapper::entityToDto).toList();
    }

    @Override
    public List<ProductoResponse> filtrarPrecioVentaEntre(BigDecimal precio1, BigDecimal precio2) {
        List<Producto> productos = productoRepository.findByPrecioVentaBetween(precio1, precio2);
        return productos.stream().map(productoMapper::entityToDto).toList();
    }

    @Override
    public List<ProductoResponse> filtrarPorNombreYPrecioVentaMayorQue(String nombre, BigDecimal precio) {
        List<Producto> productos = productoRepository.findByNombreAndPrecioVentaGreaterThanEqual(nombre, precio);
        return productos.stream().map(productoMapper::entityToDto).toList();
    }
}
