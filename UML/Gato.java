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

    public Gato(String nombre, int edad, EstadoAnimal estado, List<Turno> turnos, String color) {
        super(nombre, edad, estado, turnos);
        this.color = color;
    }
}
