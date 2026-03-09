package com.mycompany.vehitrack.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/vehitrack_db";
    private static final String USER = "root"; 
    private static final String PASS = "1234"; // ¡Asegúrate de que esta sea tu clave!

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Esta línea fuerza la carga del conector que pusimos en el pom.xml
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}