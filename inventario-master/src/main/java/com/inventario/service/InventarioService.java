package com.inventario.service;

import com.inventario.models.Inventario;
import com.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> findById(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById(Integer id){
        return inventarioRepository.findById(id);
    }

    public Inventario savInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public void deleteInventario(Integer id){
        inventarioRepository.deleteById(id);
    }

    public Inventario ActualizarInventario(Integer id, Inventario inventario) {
        Inventario inventarioExistente = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
        
        inventarioExistente.setStockDisponible(inventario.getStockDisponible());
        return inventarioRepository.save(inventarioExistente);
    }

    public Inventario CrearInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }


}
