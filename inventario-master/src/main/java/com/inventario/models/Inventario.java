package com.inventario.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inventario")
    private Integer id_Inventario;
    private Integer stockDisponible;
    private Integer id_producto;
    private Integer id_sucursal;
    private Integer id_usuario;

}
