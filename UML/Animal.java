
package SegundoParcialPruebas;

import java.util.List;

/**
 *
 * @author hualp
 */
public abstract class Animal {
    private String nombre;
    private int edad;
    private EstadoAnimal estado; //Enum
    private Duenio duenio; //Asociación
    private Raza raza; //Asociación
    private List<Turno> turnos; //Agregación
    private FichaMedica fichaMedica; //Composición

    public Animal(String nombre, int edad, EstadoAnimal estado, List<Turno> turnos) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.turnos = turnos;
        this.fichaMedica = new FichaMedica();
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }
}
