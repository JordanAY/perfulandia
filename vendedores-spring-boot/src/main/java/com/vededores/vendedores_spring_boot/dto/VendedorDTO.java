package com.vededores.vendedores_spring_boot.dto;

import lombok.Data;

@Data
public class VendedorDTO {
    private Integer idVendedor;
    private Integer idUsuario;
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private Integer rut;
    private String areaVentas;
    
}
