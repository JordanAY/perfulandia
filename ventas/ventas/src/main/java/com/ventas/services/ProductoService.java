package com.ventas.services;

import org.springframework.web.client.RestTemplate;

import com.ventas.dto.ProductoDTO;

public class ProductoService {
    
    private final RestTemplate restTemplate;

    public ProductoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductoDTO obtenerProductoPorId(Integer idProducto) {
        String url = "http://url-api-productos/api/productos/" + idProducto;
        return restTemplate.getForObject(url, ProductoDTO.class);
    }
}
