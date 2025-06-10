package com.envios.repository;

import com.envios.models.Envio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Integer> {
    
    List<Envio> findByEstadoEnvio(String estadoEnvio);
    List<Envio> findByIdVenta(Integer idVenta);
    List<Envio> findByFechaEnvioBetween(Date fechaInicio, Date fechaFin);
}
