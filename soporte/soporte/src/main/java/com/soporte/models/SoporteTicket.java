package com.soporte.models;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "soporte")
@Data
public class SoporteTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "tipo_ticket")
    private String tipoTicket;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fecha_resolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;




}
