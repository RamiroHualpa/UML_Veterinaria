package SegundoParcialPruebas.Ejercicios;

import java.util.List;
import java.util.ArrayList;

public class Ejercicio08 {

    public abstract static class Animal {
        public abstract String getDieta();
    }

    public static class Perro extends Animal {
        @Override
        public String getDieta() {
            return "Alimento balanceado para perros";
        }
    }

    public static class Gato extends Animal {
        @Override
        public String getDieta() {
            return "Alimento balanceado para gatos";
        }

        public String getRazaFelina() {
            return "Siames";
        }
    }

    public static class ReporteNutricional {
        private List<Animal> animales;

        public ReporteNutricional() {
            this.animales = new ArrayList<>();
            this.animales.add(new Perro());

            // Línea del campus:
            // this.animales.add({1:MCS:=new Gato()~new Animal()~Gato.class.newInstance()~new Object()});
            this.animales.add(new Gato()); // ✅ Correcto: se instancia directamente un Gato, que hereda de Animal y sobrescribe getDieta().

            // this.animales.add(new Animal()); // ❌ No compila: Animal es abstracto, no puede instanciarse directamente.
            // this.animales.add(Gato.class.newInstance()); // ⚠️ Compila con reflexión, pero es mala práctica: newInstance() está deprecado y requiere manejar excepciones checked (IllegalAccessException, InstantiationException).
            // this.animales.add(new Object()); // ❌ No compila: Object no es subtipo de Animal, por lo que no se puede agregar a List<Animal>.
        }

        public void imprimirReporte() {
            for (Animal animal : animales) {
                // Línea del campus:
                // System.out.println("Dieta: " + animal.{2:MCS:=getDieta()~dieta()~fetchDieta()~obtenerDieta()});
                System.out.println("Dieta: " + animal.getDieta()); // ✅ Correcto: método definido en Animal y sobrescrito en Perro y Gato.
                // System.out.println("Dieta: " + animal.dieta());        // ❌ No compila: no existe el método dieta().
                // System.out.println("Dieta: " + animal.fetchDieta());   // ❌ No compila: no existe el método fetchDieta().
                // System.out.println("Dieta: " + animal.obtenerDieta()); // ❌ No compila: no existe el método obtenerDieta().

                // Línea del campus:
                // if (animal {3:MCS:=instanceof Gato~esGato~is Gato~Gato.class.isInstance(animal)}) {
                if (animal instanceof Gato) { // ✅ Correcto: verifica si el objeto es instancia de Gato para poder castear.
                    // if (animal esGato) {                 // ❌ No compila: "esGato" no es palabra clave ni método existente.
                    // if (animal is Gato) {                // ❌ No compila: "is" no es operador válido en Java, es propio de otros lenguajes (ej. Kotlin).
                    // if (Gato.class.isInstance(animal)) { // ⚠️ Compila y es correcto técnicamente, pero menos legible que "instanceof"; usar reflexión en este caso es innecesario.

                    Gato gato = (Gato) animal;

                    // Línea del campus:
                    // System.out.println("Raza: " + gato.{4:MCS:=getRazaFelina()~razaFelina~get raza()~raza()});
                    System.out.println("Raza: " + gato.getRazaFelina()); // ✅ Correcto: método definido en Gato.
                    // System.out.println("Raza: " + gato.razaFelina());   // ❌ No compila: no existe método con ese nombre.
                    // System.out.println("Raza: " + gato.get raza());     // ❌ No compila: contiene un espacio, sintaxis inválida.
                    // System.out.println("Raza: " + gato.raza());         // ❌ No compila: no existe método raza().
                }
            }
        }
    }
}
