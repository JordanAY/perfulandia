package com.clientes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
