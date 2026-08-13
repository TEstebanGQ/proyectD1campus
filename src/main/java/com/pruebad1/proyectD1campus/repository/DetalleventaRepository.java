package com.pruebad1.proyectD1campus.repository;

import com.pruebad1.proyectD1campus.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DetalleventaRepository extends JpaRepository<DetalleVenta, Long> {

    // Buscar detalles de una venta específica
    List<DetalleVenta> findByVenta_Id(Long ventaId);

    // Buscar detalles de un producto específico
    List<DetalleVenta> findByProducto_Id(Long productoId);

    // Buscar detalles cuya cantidad sea mayor o igual a un valor
    List<DetalleVenta> findByCantidadGreaterThanEqual(Double cantidad);

    // Buscar detalles cuyo subtotal sea mayor o igual a un valor
    List<DetalleVenta> findBySubtotalGreaterThanEqual(BigDecimal subtotal);

    // Consulta JPQL: obtener detalles de una venta
    @Query("""
        SELECT d
        FROM DetalleVenta d
        WHERE d.venta.id = :ventaId
        """)
    List<DetalleVenta> buscarPorVenta(
            @Param("ventaId") Long ventaId
    );

    // Consulta JPQL: obtener detalles de un producto
    @Query("""
        SELECT d
        FROM DetalleVenta d
        WHERE d.producto.id = :productoId
        """)
    List<DetalleVenta> buscarPorProducto(
            @Param("productoId") Long productoId
    );
}