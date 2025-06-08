package com.soporte.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SoporteTicketDTO {
   private Integer idTicket;
   private Integer idUsuario;
   private String tipoTicket;
   private String descripcion;
   private String estado;
   private Date fechaCreacion;
   private Date fechaResolucion;
}
