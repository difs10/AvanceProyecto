/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavance;

/**
 *
 * @author David
 */
public class Cliente {

    String nombreCliente;
    String telefonoCliente;
    String direccion;
    String nombreMascota;
    String edadMascota;
    String especie;
    String raza;

    public Cliente(String nombreCliente, String telefonoCliente, String direccion, String nombreMascota, String edadMascota, String especie, String raza) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccion = direccion;
        this.nombreMascota = nombreMascota;
        this.edadMascota = edadMascota;
        this.raza = raza;
        this.especie = especie;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(String edadMascota) {
        this.edadMascota = edadMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

}
