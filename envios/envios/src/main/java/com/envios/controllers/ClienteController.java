package com.envios.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.envios.dto.EnvioDTO;
import com.envios.services.EnvioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class ClienteController {
    
    @Autowired
    private EnvioService service;

    @PostMapping
    public ResponseEntity<EnvioDTO> crear(@RequestBody EnvioDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EnvioDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO> actualizar(@PathVariable Integer id, @RequestBody EnvioDTO dto) {
        return service.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return service.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{estadoEnvio}")
    public ResponseEntity<List<EnvioDTO>> buscarPorEstado(@PathVariable String estadoEnvio) {
        return ResponseEntity.ok(service.buscarPorEstado(estadoEnvio));
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<EnvioDTO>> buscarPorVenta(@PathVariable Integer idVenta) {
        return ResponseEntity.ok(service.buscarPorVenta(idVenta));
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<EnvioDTO>> buscarPorRangoFechas(
            @RequestParam("inicio") Date inicio,
            @RequestParam("fin") Date fin) {
        return ResponseEntity.ok(service.buscarPorRangoFechas(inicio, fin));
    }


}
