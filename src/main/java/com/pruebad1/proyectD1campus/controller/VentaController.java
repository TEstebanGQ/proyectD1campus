package com.pruebad1.proyectD1campus.controller;

import com.pruebad1.proyectD1campus.dto.request.VentaRequest;
import com.pruebad1.proyectD1campus.dto.response.VentasResponse;
import com.pruebad1.proyectD1campus.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
// http://localhost:8080/api/ventas
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @PostMapping
    public ResponseEntity<VentasResponse> crearVenta(@Valid @RequestBody VentaRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VentasResponse>> listarVentas() {
        return ResponseEntity.ok(ventaService.obtenerTodas());
    }

    // http://localhost:8080/api/ventas/1
    @GetMapping("/{id}")
    public ResponseEntity<VentasResponse> obtenerVentaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentasResponse> actualizar(@PathVariable Long id, @Valid @RequestBody VentaRequest dto) {
        return ResponseEntity.ok(ventaService.actualizarVenta(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // http://localhost:8080/api/ventas/mes-anho?mes=8&anho=2026
    @GetMapping("/mes-anho")
    public ResponseEntity<List<VentasResponse>> buscarPorMesYAnho(@RequestParam int mes, @RequestParam int anho) {
        return ResponseEntity.ok(ventaService.buscarPorMesYAnho(mes, anho));
    }

    // http://localhost:8080/api/ventas/total-mayor?precio=50000
    @GetMapping("/total-mayor")
    public ResponseEntity<List<VentasResponse>> filtrarTotalMayorQue(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(ventaService.filtrarTotalMayorQue(precio));
    }

    // http://localhost:8080/api/ventas/fecha-entre?inicio=2026-01-01&fin=2026-12-31
    @GetMapping("/fecha-entre")
    public ResponseEntity<List<VentasResponse>> filtrarFechaEntre(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
        return ResponseEntity.ok(ventaService.filtrarFechaEntre(inicio, fin));
    }
}
