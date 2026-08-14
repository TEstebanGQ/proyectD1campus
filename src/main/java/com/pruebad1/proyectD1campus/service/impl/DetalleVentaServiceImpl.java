package com.pruebad1.proyectD1campus.service.impl;

import com.pruebad1.proyectD1campus.dto.request.DetalleVentaRequest;
import com.pruebad1.proyectD1campus.dto.response.DetalleVentaResponse;
import com.pruebad1.proyectD1campus.mapper.DetalleVentaMapper;
import com.pruebad1.proyectD1campus.mapper.ProductoMapper;
import com.pruebad1.proyectD1campus.mapper.VentaMapper;
import com.pruebad1.proyectD1campus.model.DetalleVenta;
import com.pruebad1.proyectD1campus.model.Producto;
import com.pruebad1.proyectD1campus.model.Venta;
import com.pruebad1.proyectD1campus.repository.DetalleventaRepository;
import com.pruebad1.proyectD1campus.repository.ProductoRepository;
import com.pruebad1.proyectD1campus.repository.VentaRepository;
import com.pruebad1.proyectD1campus.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleventaRepository detalleVentaRepository;
    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;
    private final DetalleVentaMapper detalleVentaMapper;
    private final VentaMapper ventaMapper;
    private final ProductoMapper productoMapper;

    @Override
    public DetalleVentaResponse crear(DetalleVentaRequest dto) {
        Venta venta = ventaRepository.findById(dto.ventaId()).orElseThrow(() -> new RuntimeException("No existe la venta a relacionar con el detalle con id: " + dto.ventaId()));
        Producto producto = productoRepository.findById(dto.productoId()).orElseThrow(() -> new RuntimeException("No existe dicho producto a vender con id: " + dto.productoId()));
        DetalleVenta detalleVenta = detalleVentaMapper.dtoToEntity(dto, venta, producto);
        DetalleVenta guardado = detalleVentaRepository.save(detalleVenta);
        return detalleVentaMapper.entityToDto(guardado, ventaMapper.entityToDto(venta), productoMapper.entityToDto(producto));
    }

    @Override
    public DetalleVentaResponse actualizar(Long id, DetalleVentaRequest dto) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra el detalle de venta a actualizar con id: " + id));
        Producto producto = productoRepository.findById(dto.productoId()).orElseThrow(() -> new RuntimeException("No existe dicho producto a vender con id: " + dto.productoId()));
        Venta venta = ventaRepository.findById(dto.ventaId()).orElseThrow(() -> new RuntimeException("No existe la venta a relacionar con el detalle con id: " + dto.ventaId()));
        detalleVentaMapper.updateEntityFromDto(detalleVenta, dto, venta, producto);
        DetalleVenta actualizado = detalleVentaRepository.save(detalleVenta);
        return detalleVentaMapper.entityToDto(actualizado, ventaMapper.entityToDto(venta), productoMapper.entityToDto(producto));
    }

    @Override
    public void eliminar(Long id) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra el detalle de venta a eliminar con id: " + id));
        detalleVentaRepository.delete(detalleVenta);
    }

    @Override
    public List<DetalleVentaResponse> listarTodos() {
        return detalleVentaRepository.findAll().stream().map(
                p -> detalleVentaMapper.entityToDto(p,
                        ventaMapper.entityToDto(p.getVenta()),
                        productoMapper.entityToDto(p.getProducto()))
        ).toList();
    }

    @Override
    public DetalleVentaResponse buscarPorId(Long id) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra el detalle de venta con id: " + id));
        return detalleVentaMapper.entityToDto(detalleVenta, ventaMapper.entityToDto(detalleVenta.getVenta()), productoMapper.entityToDto(detalleVenta.getProducto()));
    }

    @Override
    public List<DetalleVentaResponse> buscarPorIdProducto(Long id) {
        return detalleVentaRepository.findByProductoId(id).stream().map(
                p -> detalleVentaMapper.entityToDto(p,
                        ventaMapper.entityToDto(p.getVenta()),
                        productoMapper.entityToDto(p.getProducto()))
        ).toList();
    }

    @Override
    public List<DetalleVentaResponse> buscarPorIdDetalleVenta(Long id) {
        return detalleVentaRepository.findByVentaId(id).stream().map(
                p -> detalleVentaMapper.entityToDto(p,
                        ventaMapper.entityToDto(p.getVenta()),
                        productoMapper.entityToDto(p.getProducto()))
        ).toList();
    }

    @Override
    public List<DetalleVentaResponse> filtrarPorCantidadesMenorOIgualQue(Double cantidad) {
        return detalleVentaRepository.findByCantidadLessThanEqual(cantidad).stream().map(
                p -> detalleVentaMapper.entityToDto(p,
                        ventaMapper.entityToDto(p.getVenta()),
                        productoMapper.entityToDto(p.getProducto()))
        ).toList();
    }
}
