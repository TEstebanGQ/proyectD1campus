package com.pruebad1.proyectD1campus.controller;

import com.pruebad1.proyectD1campus.dto.request.DetalleVentaRequest;
import com.pruebad1.proyectD1campus.dto.response.DetalleVentaResponse;
import com.pruebad1.proyectD1campus.service.DetalleVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @PostMapping
    public ResponseEntity<DetalleVentaResponse> crearDetalleVenta(@Valid @RequestBody DetalleVentaRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaResponse>> listarDetallesVenta() {
        return ResponseEntity.ok(detalleVentaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleVentaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody DetalleVentaRequest dto) {
        return ResponseEntity.ok(detalleVentaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleVentaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<List<DetalleVentaResponse>> buscarPorIdProducto(@PathVariable Long id) {
        return ResponseEntity.ok(detalleVentaService.buscarPorIdProducto(id));
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity<List<DetalleVentaResponse>> buscarPorIdDetalleVenta(@PathVariable Long id) {
        return ResponseEntity.ok(detalleVentaService.buscarPorIdDetalleVenta(id));
    }

    @GetMapping("/cantidad-menor-igual")
    public ResponseEntity<List<DetalleVentaResponse>> filtrarPorCantidadesMenorOIgualQue(@RequestParam Double cantidad) {
        return ResponseEntity.ok(detalleVentaService.filtrarPorCantidadesMenorOIgualQue(cantidad));
    }
}
