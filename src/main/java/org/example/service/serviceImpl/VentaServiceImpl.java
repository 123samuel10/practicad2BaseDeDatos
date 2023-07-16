package org.example.service.serviceImpl;

import org.example.model.Venta;
import org.example.service.VentaService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentaServiceImpl implements VentaService {
    List<Venta>ventas=new ArrayList<>();
    int total=0;
    @Override
    public void venta(LocalDate fecha, ClienteServiceImpl clienteService) {
        ventas.add(new Venta(fecha));
        clienteService.getCliente().stream().forEach(cliente -> {
            if (cliente != null) {
                total=cliente.getCantidad()*cliente.getPrecio();
                JOptionPane.showMessageDialog(null,"total: "+total);
            }
        });


    }
}
