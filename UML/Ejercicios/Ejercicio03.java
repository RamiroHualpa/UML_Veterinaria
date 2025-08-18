package SegundoParcialPruebas.Ejercicios;

import java.util.List;

public class Ejercicio03 {

    public abstract static class Animal {
        private Duenio duenio;

        public Duenio getDuenio() {
            return this.duenio;
        }

        public void setDuenio(Duenio d) {
            this.duenio = d;
        }

        // Línea del campus:
        // public {1:MCS:=abstract~void~static~final} String emitirSonido();
        public abstract String emitirSonido(); // ✅ Correcto: al ser Animal abstracto, definir un método abstracto es
                                                // lo apropiado para que cada subclase lo implemente.
        // public void String emitirSonido();    // ❌ No compila: "void" no puede coexistir con "String" como tipo de retorno.
        // public static String emitirSonido();  // ❌ Compilaría, pero sería incorrecto: un método static no es polimórfico,
                                                //no puede sobrescribirse en Perro y Gato, lo cual rompe el objetivo del ejercicio.
        // public final String emitirSonido();  // ❌ Compilaría, pero sería incorrecto: un método final no puede ser sobrescrito,
                                                // imposibilitando que las subclases (Perro, Gato) personalicen el sonido.
    }

    public static class Perro extends Animal {
        @Override
        public String emitirSonido() {
            return " ladrido";
        }
    }

    public static class Gato extends Animal {
        @Override
        public String emitirSonido() {
            return " maullido";
        }
    }

    public static class Duenio {
        private String nombre;
        private List<Animal> animales;

        public Duenio(String n) {
            this.nombre = n;
        }

        public String getNombre() {
            return this.nombre;
        }
    }

    public static class ReporteService {
        // Línea del campus:
        // public void generarReporteDeMascotas({2:MCS:=List⟨Animal⟩~List~ArrayList~List⟨Object⟩} animales) {
        public void generarReporteDeMascotas(List<Animal> animales) { // ✅ Correcto: mantiene el tipado genérico, permite polimorfismo y seguridad de tipos.
             //public void generarReporteDeMascotas(List animales) {
                 // ❌ Compilaría con warning: usa raw types, se pierde seguridad de tipos y puede causar ClassCastException en tiempo de ejecución.
            // public void generarReporteDeMascotas(ArrayList animales) {
                 // ❌ Compila, pero mala práctica: rompe el principio de programar contra interfaces (List) en lugar de implementaciones concretas.
            // public void generarReporteDeMascotas(List<Object> animales) {
                 // ❌ Compila, pero incorrecto: no permite pasar List<Animal> porque List<Object> no es supertipo de List<Animal>, perderíamos polimorfismo.

            // Línea del campus:
            // for ({3:MCS:=Animal animal : animales~animal : animales~Object animal : animales~var animal < animales}) {
            for (Animal animal : animales) { // ✅ Correcto: recorre la lista de animales usando polimorfismo.
                // for (animal : animales) {            // ❌ No compila: falta declarar el tipo de la variable.
                // for (Object animal : animales) {     // ❌ Compila, pero obliga a castear "animal" a Animal en cada uso,
                                                        // perdiendo polimorfismo y generando posibles ClassCastException.
                // for (var animal < animales) {        // ❌ No compila: la sintaxis "<" no existe para el for-each en Java.

                Duenio d = animal.getDuenio();
                String nombreDuenio = d != null ? d.getNombre() : "Sin dueño";

                // Línea del campus:
                // String sonido = animal.{4:MCS:=emitirSonido()~getSonido()~sonido()~produceSound()};
                String sonido = animal.emitirSonido(); // ✅ Correcto: método definido en Animal y sobrescrito en Perro y Gato.
                // String sonido = animal.getSonido();     // ❌ No compila: no existe un método getSonido() en Animal.
                // String sonido = animal.sonido();        // ❌ No compila: no existe un método sonido().
                // String sonido = animal.produceSound();  // ❌ No compila: no existe un método produceSound().

                System.out.println(nombreDuenio + " tiene una mascota que hace un" + sonido);
            }
        }
    }
}
