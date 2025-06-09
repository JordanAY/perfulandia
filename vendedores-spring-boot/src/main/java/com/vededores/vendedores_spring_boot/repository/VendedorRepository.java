package com.vededores.vendedores_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vededores.vendedores_spring_boot.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}
