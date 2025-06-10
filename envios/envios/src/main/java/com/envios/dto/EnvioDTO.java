package com.envios.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class EnvioDTO {
    
    private Integer idEnvio;
    private Integer idVenta;
    private String direccionEnvio;
    private String estadoEnvio;
    private Date fechaEnvio;
    private Date fechaEntrega;

}
