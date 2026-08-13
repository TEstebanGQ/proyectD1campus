package com.pruebad1.proyectD1campus.service;

import com.pruebad1.proyectD1campus.dto.request.VentaRequest;
import com.pruebad1.proyectD1campus.dto.response.VentasResponse;
import org.hibernate.mapping.List;



public interface VentaService {
    VentasResponse guardar(VentaRequest dto);
    List<VentasResponse> obtenerTodas();
    VentasResponse obtenerPorId(Long id);
    VentasResponse actualizarVenta(Long id, VentaRequest dto);
    void eliminarVenta(Long id);
    List<VentasResponse> buscarPorMesYAnho(int mes, int anho);
    List<VentasResponse> filtrarTotalMayorQue(BigDecimal precio);
    List<VentasResponse> filtrarFechaEntre(Date fechaInicio, Date fechaFin);
}
