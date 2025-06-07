package com.soporte.repository;

import com.soporte.repository.model.SoporteTicket; //esta wea es importante pero nose como solucionarlo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SoporteTicketRepository extends JpaRepository<com.soporte.models.SoporteTicket, Integer> {

}
