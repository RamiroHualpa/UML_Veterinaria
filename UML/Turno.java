/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hualp
 */
class Turno {
    private LocalDate fecha;
    private Animal animal; //Asociación
    private Veterinario veterinario; //Asociación
    private List<TratamientoRealizado> tratamientos; //Composición

    public Turno(LocalDate fecha, List<TratamientoRealizado> tratamientos) {
        this.fecha = fecha;
        this.tratamientos = new ArrayList<>(tratamientos);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public List<TratamientoRealizado> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<TratamientoRealizado> tratamientos) {
        this.tratamientos = tratamientos;
    }

    @Override
    public String toString() {
        return "Turno{" + "fecha=" + fecha + ", animal=" + animal + ", veterinario=" + veterinario + ", tratamientos=" + tratamientos + '}';
    }
    
    
    
    
    
}
