package com.envios.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envios.dto.EnvioDTO;
import com.envios.models.Envio;
import com.envios.repository.EnvioRepository;

@Service
public class EnvioService {
    
    @Autowired
    private EnvioRepository repository;

    public EnvioDTO guardar(EnvioDTO dto) {
        Envio envio = toEntity(dto);
        Envio saved = repository.save(envio);
        return toDTO(saved);
    }

    public List<EnvioDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EnvioDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    public Optional<EnvioDTO> actualizar(Integer id, EnvioDTO dto) {
        return repository.findById(id).map(envio -> {
            envio.setIdVenta(dto.getIdVenta());
            envio.setDireccionEnvio(dto.getDireccionEnvio());
            envio.setEstadoEnvio(dto.getEstadoEnvio());
            envio.setFechaEnvio(dto.getFechaEnvio());
            envio.setFechaEntrega(dto.getFechaEntrega());
            return toDTO(repository.save(envio));
        });
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<EnvioDTO> buscarPorEstado(String estadoEnvio) {
        return repository.findByEstadoEnvio(estadoEnvio).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<EnvioDTO> buscarPorVenta(Integer idVenta) {
        return repository.findByIdVenta(idVenta).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<EnvioDTO> buscarPorRangoFechas(Date inicio, Date fin) {
        return repository.findByFechaEnvioBetween(inicio, fin).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Métodos auxiliares
    private EnvioDTO toDTO(Envio envio) {
        EnvioDTO dto = new EnvioDTO();
        dto.setIdEnvio(envio.getIdEnvio());
        dto.setIdVenta(envio.getIdVenta());
        dto.setDireccionEnvio(envio.getDireccionEnvio());
        dto.setEstadoEnvio(envio.getEstadoEnvio());
        dto.setFechaEnvio(envio.getFechaEnvio());
        dto.setFechaEntrega(envio.getFechaEntrega());
        return dto;
    }

    private Envio toEntity(EnvioDTO dto) {
        Envio envio = new Envio();
        envio.setIdEnvio(dto.getIdEnvio());
        envio.setIdVenta(dto.getIdVenta());
        envio.setDireccionEnvio(dto.getDireccionEnvio());
        envio.setEstadoEnvio(dto.getEstadoEnvio());
        envio.setFechaEnvio(dto.getFechaEnvio());
        envio.setFechaEntrega(dto.getFechaEntrega());
        return envio;
    }


}
