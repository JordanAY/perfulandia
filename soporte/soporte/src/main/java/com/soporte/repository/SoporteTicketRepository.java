package com.soporte.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.soporte.models.SoporteTicket;

public interface SoporteTicketRepository  extends JpaRepository<SoporteTicket, Integer>{
    

}