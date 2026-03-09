package com.mycompany.vehitrack.principal;

import com.mycompany.vehitrack.DAO.UsuarioDAO;
import com.mycompany.vehitrack.DAO.VehiculoDAO;
import com.mycompany.vehitrack.model.usuario;
import com.mycompany.vehitrack.model.vehiculo;

public class main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        VehiculoDAO vDao = new VehiculoDAO();
        String emailPrueba = "jeison@vehitrack.com";
        String placaPrueba = "ABC12D";

        System.out.println("=== INICIANDO CICLO CRUD COMPLETO ===");

        // 1. REGISTRAR USUARIO
        System.out.println("\n--- Paso 1: Registrando usuario ---");
        usuario nuevo = new usuario("Jeison", "Guzman", emailPrueba, "admin123");
        dao.registrarUsuario(nuevo);

        // 2. BUSCAR USUARIO
        System.out.println("\n--- Paso 2: Buscando para obtener ID ---");
        usuario encontrado = dao.buscarPorEmail(emailPrueba);
        
        if (encontrado != null) {
            // 3. ACTUALIZAR USUARIO
            System.out.println("\n--- Paso 3: Actualizando datos ---");
            encontrado.setNombre("Jeison Alvin");
            dao.actualizarUsuario(encontrado);

            // 4. VINCULAR VEHÍCULO
            System.out.println("\n--- Paso 4: Registrando vehículo ---");
            vehiculo miMoto = new vehiculo(encontrado.getIdUsuario(), "Motocicleta", "Yamaha", "FZ25", placaPrueba);
            vDao.registrarVehiculo(miMoto);

            // 5. ELIMINAR (Orden correcto para evitar error de Llave Foránea)
            System.out.println("\n--- Paso 5: Iniciando limpieza de datos ---");
            
            // 5.1 Primero eliminamos el vehículo (el hijo)
            vDao.eliminarVehiculo(placaPrueba); 
            
            // 5.2 Luego eliminamos el usuario (el padre)
            dao.eliminarUsuario(emailPrueba);
            
            // Verificación final
            usuario verificado = dao.buscarPorEmail(emailPrueba);
            if (verificado == null) {
                System.out.println("Confirmado: El ciclo de vida de los datos se completó correctamente.");
            }

        } else {
            System.out.println("No se pudo completar el ciclo porque el usuario no existe.");
        }

        System.out.println("\n=== PRUEBA DE ACTIVIDAD FINALIZADA ===");
    }
}