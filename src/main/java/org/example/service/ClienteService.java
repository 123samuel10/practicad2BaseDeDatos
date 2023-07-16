package org.example.service;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface ClienteService {
    void guardar(Long id,String producto,String nombre,int cantidad,int precio);
    void buscar(String nombre);
    void  eliminar(String nombre);
    void modificar(String nombreModicar,String nombreProductoNuevo,String nombreNuevo,int cantidadNueva,int precioNuevo);
    void listar();
    Cliente getByName(String nombre);


}
