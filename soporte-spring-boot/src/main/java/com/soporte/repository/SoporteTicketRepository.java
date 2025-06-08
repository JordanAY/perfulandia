package com.soporte.repository;

import com.soporte.models.SoporteTicket; //ya lo arregle
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SoporteTicketRepository extends JpaRepository<com.soporte.models.SoporteTicket, Integer> {

}
