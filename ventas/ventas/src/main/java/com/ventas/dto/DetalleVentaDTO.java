package com.ventas.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO {
      private Integer idDetalleVenta;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private ProductoDTO producto;
}
