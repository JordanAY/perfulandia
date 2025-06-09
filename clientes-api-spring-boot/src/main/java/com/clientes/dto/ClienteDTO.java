package com.clientes.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Integer idCliente;
    private Integer idUsuario;
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private String rut;
    private String direccion;
    private String telefono;
    private Integer idComuna;
    
    
}