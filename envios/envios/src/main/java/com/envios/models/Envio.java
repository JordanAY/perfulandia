package com.envios.models;


import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "envio")

public class Envio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;
    private Integer idVenta;
    private String direccionEnvio;
    private String estadoEnvio;
    private Date fechaEnvio;
    private Date fechaEntrega;

}
