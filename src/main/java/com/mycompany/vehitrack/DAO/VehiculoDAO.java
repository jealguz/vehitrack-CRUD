package com.mycompany.vehitrack.DAO;

import com.mycompany.vehitrack.conection.ConexionBD;
import com.mycompany.vehitrack.model.vehiculo;
import java.sql.*;

public class VehiculoDAO {
    
    public void registrarVehiculo(vehiculo v) {
        String sql = "INSERT INTO vehiculo (id_usuario, tipo, marca, modelo, placa) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, v.getIdUsuario());
            ps.setString(2, v.getTipo());
            ps.setString(3, v.getMarca());
            ps.setString(4, v.getModelo());
            ps.setString(5, v.getPlaca());
            
            ps.executeUpdate();
            System.out.println("Vehículo registrado con éxito para el usuario ID: " + v.getIdUsuario());
            
        } catch (SQLException e) {
            System.err.println("Error al registrar vehículo: " + e.getMessage());
        }
    }
    public void eliminarVehiculo(String placa) {
        String sql = "DELETE FROM vehiculo WHERE placa = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, placa);
            ps.executeUpdate();
            System.out.println("Vehículo eliminado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar vehículo: " + e.getMessage());
        }
    }
}