/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.util.List;

/**
 *
 * @author hualp
 */
public class Duenio {
    private String nombre;
    private Telefono telefono; //Asociación
    private Direccion direccion; // Asociación
    private List<Animal> animales; //Agregación

    public Duenio(String nombre, List<Animal> animales) {
        this.nombre = nombre;
        this.animales = animales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public String toString() {
        return "Duenio{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", animales=" + animales + '}';
    }
    
    
}
