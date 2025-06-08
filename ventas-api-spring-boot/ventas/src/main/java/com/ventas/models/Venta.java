package com.ventas.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    private Integer idCliente;  

    private Integer idVendedor; 

    private LocalDate fechaVenta;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalles;
}
