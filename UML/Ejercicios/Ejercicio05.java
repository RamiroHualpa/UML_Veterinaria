package SegundoParcialPruebas.Ejercicios;

import java.util.List;

public class Ejercicio05 {

    public abstract static class Animal {
        public abstract String getIdentificacion();
    }

    public static class Perro extends Animal {
        private String idChip;
        public Perro(String idChip) { this.idChip = idChip; }
        @Override
        public String getIdentificacion() {
            return "Chip: " + idChip;
        }
    }

    public static class Gato extends Animal {
        private String color;
        public Gato(String color) { this.color = color; }
        @Override
        public String getIdentificacion() {
            return "Color: " + this.color;
        }
        public String maullar() {
            return "Miau";
        }
    }

    public static class ProcesadorAnimales {
        public void procesarLista(List<Animal> lista) {
            for (Animal a : lista) {
                // Línea del campus:
                // System.out.println("ID: " + a.{1:MCS:=getIdentificacion()~getId()~identificacion()~fetchId()});
                System.out.println("ID: " + a.getIdentificacion()); // ✅ Correcto: método abstracto en Animal, sobrescrito en Perro y Gato.
                // System.out.println("ID: " + a.getId());            // ❌ No compila: no existe un método getId() en Animal.
                // System.out.println("ID: " + a.identificacion());   // ❌ No compila: no existe un método identificacion().
                // System.out.println("ID: " + a.fetchId());          // ❌ No compila: no existe un método fetchId().

                // Línea del campus:
                // if (a {2:MCS:=instanceof Gato~is Gato~type Gato~Gato.isInstance(a)}) {
                if (a instanceof Gato) { // ✅ Correcto: operador estándar en Java para verificar tipo en tiempo de ejecución.
                    // if (a is Gato) {              // ❌ No compila: "is" no es una palabra clave en Java (es de C#/Kotlin).
                    // if (a type Gato) {            // ❌ No compila: sintaxis inválida en Java.
                    // if (Gato.isInstance(a)) {     // ❌ No compila: "isInstance" es un método de Class, no existe como método estático en Gato.

                    // Línea del campus:
                    // Gato g = ({3:MCS:=(Gato) a~a.toGato()~Gato.cast(a)~(new Gato()) a});
                    Gato g = (Gato) a; // ✅ Correcto: un cast explícito válido tras verificar instanceof.
                    // Gato g = a.toGato();          // ❌ No compila: no existe un método toGato() en Animal ni en Gato.
                    // Gato g = Gato.cast(a);        // ❌ No compila: no existe un método estático cast en la clase Gato.
                    // Gato g = (new Gato()) a;      // ❌ No compila: la sintaxis es inválida, en Java no se puede castear así.

                    System.out.println(g.maullar());
                }
            }
        }
    }

    // Línea del campus (explicativa, no código):
    // El código utiliza polimorfismo para {4:MCS:=permitir tratar objetos de diferentes subclases a través de una referencia de la superclase~crear múltiples instancias idénticas~evitar el uso de constructores~limitar el acceso a los atributos}
    // ✅ Correcto: "permitir tratar objetos de diferentes subclases a través de una referencia de la superclase".
    // ❌ Incorrecto: "crear múltiples instancias idénticas" → no es el objetivo del polimorfismo, sino de patrones de clonación.
    // ❌ Incorrecto: "evitar el uso de constructores" → no tiene relación con polimorfismo.
    // ❌ Incorrecto: "limitar el acceso a los atributos" → se refiere a encapsulamiento, no a polimorfismo.
}

