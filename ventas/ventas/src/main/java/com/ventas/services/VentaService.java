package com.ventas.services;

import com.ventas.dto.*;
import com.ventas.models.Venta;
import com.ventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoService productoService;

    public VentaDTO crear(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setFechaVenta(dto.getFechaVenta());
        // cliente y vendedor deben venir completos o referenciados (id)
        return toDTO(ventaRepository.save(venta));
    }

    public List<VentaDTO> listar() {
        return ventaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VentaDTO actualizar(Integer id, VentaDTO dto) {
        Venta existente = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        existente.setFechaVenta(dto.getFechaVenta());
        return toDTO(ventaRepository.save(existente));
    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }

    public VentaDTOConDetalles obtenerVentaCompleta(Integer idVenta) {
        Venta venta = ventaRepository.findById(idVenta)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        List<DetalleVentaDTO> detallesDTO = venta.getDetalles().stream()
            .map(detalle -> {
                ProductoDTO producto = productoService.obtenerProductoPorId(detalle.getIdProducto());
                return new DetalleVentaDTO(
                    detalle.getIdDetalleVenta(),
                    detalle.getIdProducto(),
                    detalle.getCantidad(),
                    detalle.getPrecioUnitario(),
                    producto
                );
            })
            .collect(Collectors.toList());

        return new VentaDTOConDetalles(
            venta.getIdVenta(),
            venta.getIdCliente(),    
            venta.getIdVendedor(),   
            venta.getFechaVenta(),
            detallesDTO
        );
    }

    private VentaDTO toDTO(Venta venta) {
        return new VentaDTO(
                venta.getIdVenta(),
                venta.getIdCliente(),
                venta.getIdVendedor(),
                venta.getFechaVenta()
        );
    }
}
