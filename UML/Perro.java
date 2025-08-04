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
public class Perro extends Animal{

    public Perro(String nombre, int edad, EstadoAnimal estado, List<Turno> turnos, List<Diagnostico> diagnosticos) {
        super(nombre, edad, estado, turnos, diagnosticos);
    }

    @Override
    public String toString() {
        return "Perro{" + '}';
    }

    
    
}
