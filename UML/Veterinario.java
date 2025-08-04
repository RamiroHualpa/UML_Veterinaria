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
class Veterinario {
    private String nombre;
    private Especialidad especialidad; //Asociación // Recomiendo usar un Enum 
    //o bien una relación bidireccional para poder filtrar los veterinarios por especialidad.
    private List<Animal> animalesAtendidos; //Agregación

    public Veterinario(String nombre, List<Animal> animalesAtendidos) {
        this.nombre = nombre;
        this.animalesAtendidos = animalesAtendidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Animal> getAnimalesAtendidos() {
        return animalesAtendidos;
    }

    public void setAnimalesAtendidos(List<Animal> animalesAtendidos) {
        this.animalesAtendidos = animalesAtendidos;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "nombre=" + nombre + ", especialidad=" + especialidad + ", animalesAtendidos=" + animalesAtendidos + '}';
    }
    
    
    
}
