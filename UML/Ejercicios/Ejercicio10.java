package SegundoParcialPruebas.Ejercicios;

import java.time.LocalDate;

public class Ejercicio10 {

    public abstract static class Animal {
        protected LocalDate fechaNacimiento;

        public Animal(LocalDate fecha) {
            this.fechaNacimiento = fecha;
        }

        public int getEdad() {
            return LocalDate.now().getYear() - fechaNacimiento.getYear();
        }

        public abstract boolean necesitaVacunaAnual();
    }

    public static class Gato extends Animal {
        public Gato(LocalDate fecha) {
            // Línea del campus:
            // {1:MCS:=super(fecha);~this(fecha);~Animal(fecha);~super.fechaNacimiento = fecha;}
            super(fecha); // ✅ Correcto: invoca explícitamente al constructor de la clase abstracta Animal.
            // this(fecha);               // ❌ No compila: no existe un constructor alternativo en Gato que reciba LocalDate.
            // Animal(fecha);             // ❌ No compila: no se puede invocar el constructor de la superclase sin "super".
            // super.fechaNacimiento = fecha; // ❌ No compila: se estaría asignando directamente el atributo heredado sin llamar al constructor de Animal, rompiendo la inicialización esperada.
        }

        @Override
        public boolean necesitaVacunaAnual() {
            return getEdad() > 1;
        }
    }

    // Se asume que existe una clase Perro similar a Gato.
    public static class Perro extends Animal {
        public Perro(LocalDate fecha) {
            super(fecha);
        }

        @Override
        public boolean necesitaVacunaAnual() {
            return true; // ejemplo: política de clínica
        }
    }

    public static class ClinicaControl {
        public void verificarVacunacion(Animal animal) {
            // Selecciona la opción que debe provocar error de compilación al descomentar:
            // Animal animalGenerico = {2:MCS:=new Animal(LocalDate.now());~new Gato(LocalDate.now());~null;~new Perro(LocalDate.now());}
            // ✅ RESPUESTA CORRECTA
            // Animal animalGenerico = new Animal(LocalDate.now()); // ❌ Correcto para la consigna: no compila porque Animal es abstracto y no puede instanciarse.
            // Animal animalGenerico = new Gato(LocalDate.now()); // ⚠️ Compila y es válido: crea un Gato concreto, no genera error.
            // Animal animalGenerico = null;                      // ⚠️ Compila y es válido: asignación nula permitida, no genera error.
            // Animal animalGenerico = new Perro(LocalDate.now()); // ⚠️ Compila y es válido: Perro es una clase concreta.

            // boolean necesita = animal.{3:MCS:=necesitaVacunaAnual()~checkVacuna()~getNecesitaVacuna()~vacunaAnual()};
            boolean necesita = animal.necesitaVacunaAnual(); // ✅ Correcto: método abstracto implementado por Gato y Perro.
            // boolean necesita = animal.checkVacuna();        // ❌ No compila: método no existe.
            // boolean necesita = animal.getNecesitaVacuna();  // ❌ No compila: método no existe.
            // boolean necesita = animal.vacunaAnual();        // ❌ No compila: método no existe.

            if (necesita) {
                System.out.println("Necesita vacuna.");
            } else {
                System.out.println("No necesita vacuna.");
            }
        }

        public void procesarGato() {
            // Línea del campus:
            // Gato g = {4:MCS:=new Gato(LocalDate.of(2022, 5, 10))~new Animal(LocalDate.of(2022, 5, 10))~new Object()~(Gato) new Animal(LocalDate.now())};
            Gato g = new Gato(LocalDate.of(2022, 5, 10)); // ✅ Correcto: crea un Gato válido con fecha de nacimiento.
            // Gato g = new Animal(LocalDate.of(2022, 5, 10)); // ❌ No compila: Animal es abstracto y no puede instanciarse.
            // Gato g = new Object();                          // ❌ No compila: Object no es subtipo de Gato, no hay relación de herencia.
            // Gato g = (Gato) new Animal(LocalDate.now());    // ❌ No compila: no se puede instanciar un abstracto para luego castear. Error en la primera parte.

            verificarVacunacion(g);
        }
    }
}
