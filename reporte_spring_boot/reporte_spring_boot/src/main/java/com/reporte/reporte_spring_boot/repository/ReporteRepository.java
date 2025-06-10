package com.reporte.reporte_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reporte.reporte_spring_boot.models.Reporte;

public interface ReporteRepository  extends JpaRepository<Reporte, Integer>{
    

}
