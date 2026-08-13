package com.pruebad1.proyectD1campus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(name = "precio_compra", nullable = false)
    private BigDecimal precioCompra;
    @Column(name = "precio_venta",nullable = false)
    private BigDecimal precioVenta;

}
