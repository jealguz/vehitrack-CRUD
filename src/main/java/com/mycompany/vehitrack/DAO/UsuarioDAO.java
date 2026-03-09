package com.mycompany.vehitrack.DAO;

import com.mycompany.vehitrack.conection.ConexionBD;
import com.mycompany.vehitrack.model.usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // INSERTAR 
    public void registrarUsuario(usuario user) {
        String sql = "INSERT INTO usuario (nombre, apellido, email, contraseña) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContraseña());
            ps.executeUpdate();
            System.out.println("Usuario guardado con éxito.");
            
        } catch (SQLException e) {
            System.err.println("Error al registrar: " + e.getMessage());
        }
    }

    // CONSULTAR 
    public usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario u = new usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setContraseña(rs.getString("contraseña"));
                return u;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }
    
    // ACTUALIZAR 
    public void actualizarUsuario(usuario user) {
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, contraseña = ? WHERE email = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getContraseña());
            ps.setString(4, user.getEmail());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR 
    public void eliminarUsuario(String email) {
        String sql = "DELETE FROM usuario WHERE email = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, email);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado con éxito.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
    
    
}