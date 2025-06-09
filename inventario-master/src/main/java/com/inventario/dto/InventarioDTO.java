package com.inventario.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDTO {

    private Integer idInventario;
    private Integer stockDisponible;
    private Integer idProducto;
    private Integer idSucursal;
    private Integer idUsuario;

}
