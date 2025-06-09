package com.inventario.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;

import com.inventario.models.Inventario;
import com.inventario.service.InventarioService;


@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;


    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    
    @GetMapping
    public ResponseEntity<List<Inventario>> getAll(){
        return ResponseEntity.ok(inventarioService.findById());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<Inventario> inventario = inventarioService.findById(id);
        if (inventario.isPresent()) {
            return ResponseEntity.ok(inventario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Inventario> CrearInventario(@RequestBody Inventario inventario) {
        Inventario nuevoInventario = inventarioService.savInventario(inventario);
        return ResponseEntity.ok(nuevoInventario);
    }

    @PutMapping("/ajuste/{id}")
    public ResponseEntity<Inventario> ActualizarInventario(@PathVariable Integer id, @RequestBody Inventario inventario) {
       
        Inventario inventarioActalizado = inventarioService.ActualizarInventario(id, inventario);
        return ResponseEntity.ok(inventarioActalizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventario(@PathVariable Integer id) {
        if (inventarioService.findById(id).isPresent()) {
            inventarioService.deleteInventario(id);
            return ResponseEntity.ok("Inventario eliminado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


}
