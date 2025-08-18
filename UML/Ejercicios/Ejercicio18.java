package SegundoParcialPruebas.Ejercicios;

public class Ejercicio18 {

    public static class Animal {
        private String nombre;
        // Línea del campus:
        // {1:MCS:=private EstadoAnimal estado;~public EstadoAnimal estado;~protected EstadoAnimal estado;~EstadoAnimal estado;}
        private EstadoAnimal estado; // ✅ Correcto: encapsula el campo para controlar acceso mediante getter y setter.
        // public EstadoAnimal estado;   // ⚠️ Compila, pero rompe encapsulamiento; cualquiera podría modificarlo directamente.
        // protected EstadoAnimal estado; // ⚠️ Compila, acceso limitado a subclases y mismo paquete; no garantiza control total.
        // EstadoAnimal estado;          // ⚠️ Package-private: visible solo dentro del paquete; podría no ser deseable.

        public Animal(String nombre) {
            this.nombre = nombre;
            this.estado = EstadoAnimal.SALUDABLE;
        }

        public EstadoAnimal getEstado() {
            return this.estado;
        }

        public void setEstado(EstadoAnimal nuevoEstado) {
            if (nuevoEstado != null) {
                // Línea del campus:
                // {2:MCS:=this.estado = nuevoEstado;~this.getEstado() = nuevoEstado;~estado = new EstadoAnimal();~this.estado.set(nuevoEstado);}
                this.estado = nuevoEstado; // ✅ Correcto: asigna de forma segura el nuevo estado al campo privado.
                // this.getEstado() = nuevoEstado; // ❌ No compila: getEstado() devuelve valor, no referencia asignable.
                // estado = new EstadoAnimal();     // ❌ No compila: EstadoAnimal es enum; no se puede instanciar con new.
                // this.estado.set(nuevoEstado);    // ❌ No compila: enum no tiene método set().
            }
        }
    }

    public static class TurnoService {
        public void procesarCirugia(Animal animal) {

            // La siguiente línea NO compila por nivel de acceso.
            // animal.{3:MCS:=estado = EstadoAnimal.EN_TRATAMIENTO;~setEstado(EstadoAnimal.EN_TRATAMIENTO);~getEstado();~toString();}
            // animal.estado = EstadoAnimal.EN_TRATAMIENTO; // ❌ No compila: estado es privado.
            // animal.setEstado(EstadoAnimal.EN_TRATAMIENTO); // ✅ Correcto: método público para modificar el estado.
            // animal.getEstado(); // ❌ No compila para asignación: solo devuelve el estado.
            // animal.toString();  // ❌ No modifica estado, solo retorna representación en String.

            if (animal.getEstado() == EstadoAnimal.SALUDABLE) {
                animal.setEstado(EstadoAnimal.EN_TRATAMIENTO);
            }
        }

        public void darDeAlta(Animal animal) {
            if (animal.getEstado() == EstadoAnimal.EN_TRATAMIENTO) {
                // Línea del campus:
                // animal.{4:MCS:=setEstado(EstadoAnimal.RECUPERADO)~estado = EstadoAnimal.RECUPERADO~setEstado("RECUPERADO")~changeState(EstadoAnimal.RECUPERADO)};
                animal.setEstado(EstadoAnimal.RECUPERADO); // ✅ Correcto: se usa el setter público para cambiar estado.
                // animal.estado = EstadoAnimal.RECUPERADO;  // ❌ No compila: estado es privado.
                // animal.setEstado("RECUPERADO");           // ❌ No compila: setter requiere EstadoAnimal, no String.
                // animal.changeState(EstadoAnimal.RECUPERADO); // ❌ No compila: método inexistente.
            }
        }
    }

    enum EstadoAnimal { SALUDABLE, EN_TRATAMIENTO, RECUPERADO }
}
