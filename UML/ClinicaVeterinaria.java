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
public class ClinicaVeterinaria {
    private String nombre;
    private Direccion direccion; //Asociación
    private List<Veterinario> veterinarios; //Agregación

    public ClinicaVeterinaria(String nombre, List<Veterinario> veterinarios) {
        this.nombre = nombre;
        this.veterinarios = veterinarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    @Override
    public String toString() {
        return "ClinicaVeterinaria{" + "nombre=" + nombre + ", direccion=" + direccion + ", veterinarios=" + veterinarios + '}';
    }
    
    
}
