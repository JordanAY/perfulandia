package com.ventas.dto;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VentaDTOConDetalles {
    private Integer idVenta;
    private Integer idCliente;
    private Integer idVendedor;
    private LocalDate fechaVenta;
    private List<DetalleVentaDTO> detalles;
}