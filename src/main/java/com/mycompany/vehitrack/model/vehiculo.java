package com.mycompany.vehitrack.model;

public class vehiculo {
    private int idVehiculo;
    private int idUsuario;
    private String tipo; // Moto, Carro, etc.
    private String marca;
    private String modelo;
    private String placa;

    public vehiculo() {}

    public vehiculo(int idUsuario, String tipo, String marca, String modelo, String placa) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    // Getters y Setters
    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
}
