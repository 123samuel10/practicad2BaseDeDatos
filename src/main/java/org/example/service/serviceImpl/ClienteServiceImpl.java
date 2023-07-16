package org.example.service.serviceImpl;

import org.example.ConexionDB;
import org.example.model.Cliente;
import org.example.service.ClienteService;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    List<Cliente> cliente=new ArrayList<>();
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public void guardar(Long id, String producto, String nombre, int cantidad, int precio) {
        cliente.add(new Cliente(id,producto,nombre,cantidad,precio));
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("""
            INSERT INTO producto2(nombreProducto,nombre, precio, cantidad) VALUES (?, ?, ?,?)""")) {
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2, producto);
            preparedStatement.setInt(3,precio);
            preparedStatement.setInt(4,cantidad);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void buscar(String nombre) {
        cliente.stream().forEach(cliente1 -> {
            if (cliente1 != null && cliente1.getNombrePersona().equals(nombre)) {
                JOptionPane.showMessageDialog(null,"Producto: "+cliente1.getProducto()+" cantidad: "+cliente1.getCantidad()+" precio: "+cliente1.getPrecio());

            }
        });
    }

    @Override
    public void eliminar(String nombre) {
        Iterator<Cliente> iterator = cliente.iterator();
        while (iterator.hasNext()) {
            Cliente cliente1 = iterator.next();
            if (cliente1 != null && cliente1.getNombrePersona().equals(nombre)) {
                iterator.remove();
                try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM producto2 WHERE nombre=?")) {
                    preparedStatement.setString(1, nombre);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public void listar() {
        cliente.stream().forEach(cliente -> {
            if (cliente != null) {
                JOptionPane.showMessageDialog(null,"nombre: "+cliente.getNombrePersona()+" producto: "+cliente.getProducto()+" cantidad: "+cliente.getCantidad()+" precio: "+cliente.getPrecio());
            }
        });
    }

    @Override
    public void modificar(String nombreModificar, String nombreProductoNuevo, String nombreNuevo, int cantidadNueva, int precioNuevo) {
        for (Cliente cliente1 : cliente) {
            if (cliente1 != null && cliente1.getNombrePersona().equals(nombreModificar)) {
                cliente1.setNombrePersona(nombreNuevo);
                cliente1.setCantidad(cantidadNueva);
                cliente1.setPrecio(precioNuevo);
                try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                        "UPDATE producto2 SET nombreProducto=?, nombre=?, cantidad=?, precio=? WHERE nombre=?")) {
                    preparedStatement.setString(1,nombreProductoNuevo );
                    preparedStatement.setString(2, nombreNuevo);
                    preparedStatement.setInt(3, cantidadNueva);
                    preparedStatement.setInt(4, precioNuevo);
                    preparedStatement.setString(5, nombreModificar);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private Cliente createProduct(ResultSet resultSet) throws SQLException {
        Cliente producto = new Cliente();
        producto.setId(resultSet.getLong("id"));
        producto.setProducto(resultSet.getString("nombreProducto"));
        producto.setNombrePersona(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getInt("precio"));
       producto.setCantidad(resultSet.getInt("cantidad"));
        return producto;
    }
    @Override
    public Cliente getByName(String nombre) {
        Cliente producto=null;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement(" SELECT  * FROM  producto2 where nombre=?")) {
            preparedStatement.setString(1,nombre);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                producto=createProduct(resultSet);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }
}
