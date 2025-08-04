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
public class Gato extends Animal{
    private String color;

    public Gato(String color, String nombre, int edad, EstadoAnimal estado, List<Turno> turnos, List<Diagnostico> diagnosticos) {
        super(nombre, edad, estado, turnos, diagnosticos);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Gato{" + "color=" + color + '}';
    }

    
    
    
    
}
