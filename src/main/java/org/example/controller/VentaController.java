package org.example.controller;

import org.example.service.serviceImpl.ClienteServiceImpl;
import org.example.service.serviceImpl.VentaServiceImpl;

import java.time.LocalDate;

public class VentaController {

    VentaServiceImpl ventaService=new VentaServiceImpl();
    public void venta(ClienteServiceImpl clienteService){
        LocalDate fecha=LocalDate.now();
        ventaService.venta(fecha,clienteService);
    }


}
