package com.ventas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Integer idProducto;
    private String nombre;
    private Double precio;
   
}