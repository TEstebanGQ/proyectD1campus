package com.pruebad1.proyectD1campus.repository;

import com.pruebad1.proyectD1campus.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DetalleventaRepository extends JpaRepository<DetalleVenta, Long> {

    List<DetalleVenta> findByVentaId(Long ventaId);
    List<DetalleVenta> findByProductoId(Long productoId);
    List<DetalleVenta> findByCantidadGreaterThanEqual(Double cantidad);
    List<DetalleVenta> findByCantidadLessThanEqual(Double cantidad);
    List<DetalleVenta> findBySubtotalGreaterThanEqual(BigDecimal subtotal);
}