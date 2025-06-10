package com.reporte.reporte_spring_boot.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name ="reporte" )
public class Reporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;
    private String tipoReporte;
    private Date fechaGeneracion;
    private String descripcion;
    private String jsonDatos;

    



}
