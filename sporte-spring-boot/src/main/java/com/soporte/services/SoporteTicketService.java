package com.soporte.services;

import com.soporte.dto.SoporteTicketDTO;
import com.soporte.models.SoporteTicket;
import com.soporte.repository.SoporteTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SoporteTicketService {

    @Autowired
    private SoporteTicketRepository repository;

    public SoporteTicketDTO guardar(SoporteTicketDTO dto){
        SoporteTicket SoporteTicket = toEntity(dto);
        SoporteTicket saved = repository.save(SoporteTicket);
        return toDTO(saved);
    }
    public List<SoporteTicketDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
     public Optional<SoporteTicketDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
                }
                
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    
    private SoporteTicketDTO toDTO(SoporteTicket soporteTicket) {
        SoporteTicketDTO dto = new SoporteTicketDTO();
        dto.setIdTicket(soporteTicket.getIdTicket());
        dto.setIdUsuario(soporteTicket.getIdUsuario());
        dto.setTipoTicket(soporteTicket.getTipoTicket());
        dto.setDescripcion(soporteTicket.getDescripcion());
        dto.setEstado(soporteTicket.getEstado());
        dto.setFechaCreacion(soporteTicket.getFechaCreacion());
        dto.setFechaResolucion(soporteTicket.getFechaResolucion());
        return dto;
        }


    private SoporteTicket toEntity(SoporteTicketDTO dto) {
    SoporteTicket soporteTicket = new SoporteTicket();
    soporteTicket.setIdTicket(dto.getIdTicket());
    soporteTicket.setIdUsuario(dto.getIdUsuario());
    soporteTicket.setTipoTicket(dto.getTipoTicket());
    soporteTicket.setDescripcion(dto.getDescripcion());
    soporteTicket.setEstado(dto.getEstado());
    soporteTicket.setFechaCreacion(dto.getFechaCreacion());
    soporteTicket.setFechaResolucion(dto.getFechaResolucion());
    return soporteTicket;
        }
    
    public Optional<SoporteTicketDTO> actualizar(Integer id, SoporteTicketDTO dto) {
    return repository.findById(id)
        .map(entity -> {
            entity.setIdUsuario(dto.getIdUsuario());
            entity.setTipoTicket(dto.getTipoTicket());
            entity.setDescripcion(dto.getDescripcion());
            entity.setEstado(dto.getEstado());
            entity.setFechaCreacion(dto.getFechaCreacion());
            entity.setFechaResolucion(dto.getFechaResolucion());
            SoporteTicket actualizado = repository.save(entity);
            return toDTO(actualizado);
        });
}


    
}
