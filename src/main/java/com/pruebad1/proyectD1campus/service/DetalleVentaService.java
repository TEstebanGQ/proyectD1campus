package com.pruebad1.proyectD1campus.service;

import com.pruebad1.proyectD1campus.dto.request.DetalleVentaRequest;
import com.pruebad1.proyectD1campus.dto.response.DetalleVentaResponse;

import java.util.List;

public interface DetalleVentaService {

    DetalleVentaResponse crear(DetalleVentaRequest dto);
    DetalleVentaResponse actualizar(Long id, DetalleVentaRequest dto);
    void eliminar(Long id);
    List<DetalleVentaResponse> listarTodos();
    DetalleVentaResponse buscarPorId(Long id);
    List<DetalleVentaResponse> buscarPorIdProducto(Long id);
    List<DetalleVentaResponse> buscarPorIdDetalleVenta(Long id);
    List<DetalleVentaResponse> filtrarPorCantidadesMenorOIgualQue(Double cantidad);
}