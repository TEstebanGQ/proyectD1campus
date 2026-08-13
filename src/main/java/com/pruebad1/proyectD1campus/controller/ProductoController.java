package com.pruebad1.proyectD1campus.controller;

import com.pruebad1.proyectD1campus.dto.request.ProductResquest;
import com.pruebad1.proyectD1campus.dto.response.ProductoResponse;
import com.pruebad1.proyectD1campus.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
//http://localhost:8080/api/productos
@RequestMapping("/api/productos")
@RequiredArgsConstructor

public class ProductoController {
    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@Valid @RequestBody ProductResquest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> listarProductos(){
        return ResponseEntity.ok(productoService.obtenerTodas());
    }

    // http://localhost:8080/api/productos/2
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtenerProductoPorId(@PathVariable Long id){
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizar(@PathVariable Long id, @Valid @RequestBody ProductResquest dto){
        return ResponseEntity.ok(productoService.actualizarProducto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // http://localhost:8080/api/productos/buscar?nombre=Galletas
    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoResponse>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(productoService.buscarPorNombre(nombre));
    }

    // http://localhost:8080/api/productos/precio-mayor?precio=5000
    @GetMapping("/precio-mayor")
    public ResponseEntity<List<ProductoResponse>> filtrarPrecioVentaMayorQue(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(productoService.filtrarPrecioVentaMayorQue(precio));
    }

    // http://localhost:8080/api/productos/precio-menor?precio=10000
    @GetMapping("/precio-menor")
    public ResponseEntity<List<ProductoResponse>> filtrarPrecioVentaMenorQue(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(productoService.filtrarPrecioVentaMenorQue(precio));
    }

    // http://localhost:8080/api/productos/precio-entre?precio1=1000&precio2=5000
    @GetMapping("/precio-entre")
    public ResponseEntity<List<ProductoResponse>> filtrarPrecioVentaEntre(
            @RequestParam BigDecimal precio1,
            @RequestParam BigDecimal precio2) {
        return ResponseEntity.ok(productoService.filtrarPrecioVentaEntre(precio1, precio2));
    }

    // http://localhost:8080/api/productos/buscar-filtro?nombre=Galletas&precio=2000
    @GetMapping("/buscar-filtro")
    public ResponseEntity<List<ProductoResponse>> filtrarPorNombreYPrecioVentaMayorQue(
            @RequestParam String nombre,
            @RequestParam BigDecimal precio) {
        return ResponseEntity.ok(productoService.filtrarPorNombreYPrecioVentaMayorQue(nombre, precio));
    }
}



















