package org.example;

import org.example.controller.ClienteController;
import org.example.controller.VentaController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean bandera = true;
        ClienteController clienteController = new ClienteController();
        VentaController ventaController=new VentaController();

        while (bandera) {
            switch (JOptionPane.showInputDialog("1.agregarCliente\n2.buscarCliente\n3.eliminarCliente\n4.modificar\n5.listar\n6.venta")) {
                case "1":
                    clienteController.agregar();
                    break;
                case "2":

                    clienteController.buscar();
                    break;
                case "3":
                    clienteController.eliminar();
                    break;
                case "4":
                  clienteController.modificar();

                    break;
                case "5":
                    clienteController.listar();
                    break;
                case "6":
                    ventaController.venta(clienteController.getClienteService());
                    break;


            }
        }
    }
}