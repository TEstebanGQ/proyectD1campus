package com.pruebad1.proyectD1campus.repository;

import com.pruebad1.proyectD1campus.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("""
        SELECT v FROM Venta v
        WHERE MONTH(v.fecha) = :mes
        AND YEAR(v.fecha) = :anho
        """)
    List<Venta> findByMesYAnho(
            @Param("mes") int mes,
            @Param("anho") int anho
    );

    List<Venta> findByTotalGreaterThanEqual(BigDecimal precio);

    List<Venta> findByFechaBetween(
            Date fechaInicio,
            Date fechaFin
    );
}