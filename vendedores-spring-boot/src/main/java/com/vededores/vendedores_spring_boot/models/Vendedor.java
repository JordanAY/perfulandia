package com.vededores.vendedores_spring_boot.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendedores")
@Data
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idVendedor;

    private Integer idUsuario;

    private String pNombre;

    private String sNombre;

    private String pApellido;

    private String sApellido;

    private Integer rut;

    private String areaVentas;
}