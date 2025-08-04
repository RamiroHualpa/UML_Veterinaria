
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

    public Animal(String nombre, int edad, EstadoAnimal estado, List<Turno> turnos, List<Diagnostico> diagnosticos) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.turnos = turnos;
        this.fichaMedica = new FichaMedica(diagnosticos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", edad=" + edad + ", estado=" + estado + ", duenio=" + duenio + ", raza=" + raza + ", turnos=" + turnos + ", fichaMedica=" + fichaMedica + '}';
    }
    
    
}
