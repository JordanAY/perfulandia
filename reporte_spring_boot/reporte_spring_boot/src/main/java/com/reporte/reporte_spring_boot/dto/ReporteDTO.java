package com.reporte.reporte_spring_boot.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReporteDTO {
    private Integer idReporte;
    private String tipoReporte;
    private Date fechaGeneracion;
    private String descripcion;
    private String jsonDatos;

}
