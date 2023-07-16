package org.example.controller;

import org.example.model.Cliente;
import org.example.service.serviceImpl.ClienteServiceImpl;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteController {
    ClienteServiceImpl clienteService=new ClienteServiceImpl();

    public void agregar(){
        Long id= Long.valueOf(JOptionPane.showInputDialog("ingrese el id"));


        String nombre= JOptionPane.showInputDialog("ingrese el nombre del cliente");
        String producto=JOptionPane.showInputDialog("ingrese el nombre del producto");
        int cantidad=Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad"));
        int precio=Integer.parseInt(JOptionPane.showInputDialog("ingrese el precio"));
        clienteService.guardar(id,nombre,producto,cantidad,precio);
    }
    public void listar(){
        clienteService.listar();
    }
    public  void eliminar(){
        String eliminar=JOptionPane.showInputDialog("ingrese el nombre para eliminar");
        clienteService.eliminar(eliminar);
    }
    public void buscar(){
        String buscar=JOptionPane.showInputDialog("ingrese el nombre para buscar");
        clienteService.buscar(buscar);
    }
    public void modificar(){
        String nombreModificar=JOptionPane.showInputDialog("ingrese el nombre a modificar");
        String nombreProductoNuevo=JOptionPane.showInputDialog("ingrese el nombre del producto nuevo");
        String nombreNuevo=JOptionPane.showInputDialog("ingrese nombre nuevo");
        int cantidad=Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad nuevo"));
        int precio=Integer.parseInt(JOptionPane.showInputDialog("ingrese precio nuevo"));
        clienteService.modificar(nombreModificar,nombreProductoNuevo,nombreNuevo,cantidad,precio);
    }


    public ClienteServiceImpl getClienteService() {
        return clienteService;
    }
}
