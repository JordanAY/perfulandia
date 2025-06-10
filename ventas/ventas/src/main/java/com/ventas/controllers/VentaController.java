package com.ventas.controllers;

import com.ventas.dto.VentaDTOConDetalles;
import com.ventas.dto.VentaDTO;
import com.ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @PostMapping
    public ResponseEntity<VentaDTO> crear(@RequestBody VentaDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<VentaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTOConDetalles> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerVentaCompleta(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDTO> actualizar(@PathVariable Integer id, @RequestBody VentaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
