package com.pruebad1.proyectD1campus.service.impl;

import com.pruebad1.proyectD1campus.dto.request.VentaRequest;
import com.pruebad1.proyectD1campus.dto.response.VentasResponse;
import com.pruebad1.proyectD1campus.mapper.VentaMapper;
import com.pruebad1.proyectD1campus.model.Venta;
import com.pruebad1.proyectD1campus.repository.VentaRepository;
import com.pruebad1.proyectD1campus.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;

    @Override
    public VentasResponse guardar(VentaRequest dto) {
        Venta venta = ventaMapper.dtoToEntity(dto);
        Venta ventaGuardada = ventaRepository.save(venta);
        return ventaMapper.entityToDto(ventaGuardada);
    }

    @Override
    public List<VentasResponse> obtenerTodas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream().map(ventaMapper::entityToDto).toList();
    }

    @Override
    public VentasResponse obtenerPorId(Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la venta con id: " + id));
        return ventaMapper.entityToDto(venta);
    }

    @Override
    public VentasResponse actualizarVenta(Long id, VentaRequest dto) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la venta con id: " + id));
        ventaMapper.updateEntityFromDto(venta, dto);
        Venta ventaActualizada = ventaRepository.save(venta);
        return ventaMapper.entityToDto(ventaActualizada);
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la venta con id: " + id));
        ventaRepository.delete(venta);
    }

    @Override
    public List<VentasResponse> buscarPorMesYAnho(int mes, int anho) {
        List<Venta> ventas = ventaRepository.findByMesYAnho(mes, anho);
        return ventas.stream().map(ventaMapper::entityToDto).toList();
    }

    @Override
    public List<VentasResponse> filtrarTotalMayorQue(BigDecimal precio) {
        List<Venta> ventas = ventaRepository.findByTotalGreaterThanEqual(precio);
        return ventas.stream().map(ventaMapper::entityToDto).toList();
    }

    @Override
    public List<VentasResponse> filtrarFechaEntre(Date fechaInicio, Date fechaFin) {
        List<Venta> ventas = ventaRepository.findByFechaBetween(fechaInicio, fechaFin);
        return ventas.stream().map(ventaMapper::entityToDto).toList();
    }
}
