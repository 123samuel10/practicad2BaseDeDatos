package org.example.service;

import org.example.service.serviceImpl.ClienteServiceImpl;

import java.time.LocalDate;

public interface VentaService {
    void venta(LocalDate fecha, ClienteServiceImpl clienteService);
}
