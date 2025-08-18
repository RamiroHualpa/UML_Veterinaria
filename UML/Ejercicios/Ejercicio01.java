package SegundoParcialPruebas.Ejercicios;

public class Ejercicio01 {

    // ====== Código provisto ======
    // import java.util.List;
    // import java.util.ArrayList;
    //
    // Lo comento porque no se usan en este ejercicio
    // ==============================

    // Clase abstracta base
    public abstract static class Animal {
        private String nombre;
        private int edad;

        public Animal(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }
    }

    // Línea del campus:
    // public class Gato {1:MCS:=extends Animal~implements Animal~<> Animal~uses Animal} {
    public class Gato extends Animal {   // ✅ Correcto: hereda de Animal, lo cual permite usar super() en el constructor.
        // public class Gato implements Animal {   // ❌ Incorrecto: Animal es una clase abstracta, no una interfaz; no se puede implementar.
        // public class Gato  <> Animal {          // ❌ Incorrecto: "<>" no es sintaxis válida en Java.
        // public class Gato uses Animal {         // ❌ Incorrecto: "uses" no existe como palabra reservada en Java.

        private String color;

        // Línea del campus:
        // {2:MCS:=super(nombre, edad);~this(nombre, edad);~Animal(nombre, edad);~super.init(nombre, edad);}
        public Gato(String nombre, int edad, String color) {
            super(nombre, edad); // ✅ Correcto: llama al constructor de la clase padre (Animal).
            // this(nombre, edad);       // ❌ Incorrecto: "this()" sólo invoca a otro constructor de la misma clase, no existe con esos parámetros.
            // Animal(nombre, edad);     // ❌ Incorrecto: no se puede invocar un constructor de la clase padre de esta forma.
            // super.init(nombre, edad); // ❌ Incorrecto: no existe un método "init", sólo se usa "super(...)" para invocar al constructor.
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public class GestorAnimales {
        public Gato crearGatoDomestico(String nombre) {
            int edadInicial = 1;
            String colorComun = "Naranja";

            // Línea del campus:
            // Gato nuevoGato = {3:MCS:=new Gato(nombre, edadInicial, colorComun)~new Animal(nombre, edadInicial)~Gato.create(nombre)~new Gato()};
            Gato nuevoGato = new Gato(nombre, edadInicial, colorComun); // ✅ Correcto: se instancia un Gato pasando los parámetros correctos.
            // Gato nuevoGato = new Animal(nombre, edadInicial);  // ❌ Incorrecto: no se pueden instanciar clases abstractas.
            // Gato nuevoGato = Gato.create(nombre);              // ❌ Incorrecto: no existe método estático create() en la clase Gato.
            // Gato nuevoGato = new Gato();                       // ❌ Incorrecto: no existe constructor sin parámetros definido en la clase Gato.

            return nuevoGato;
        }

        public String obtenerNombreAnimal(Animal animal) {
            // Línea del campus:
            // return animal.{4:MCS:=getNombre()~nombre~obtenerNombre()~getName()};
            return animal.getNombre(); // ✅ Correcto: getNombre() es el método público definido en Animal.
            // return animal.nombre;          // ❌ Incorrecto: el atributo es private y no es accesible fuera de la clase.
            // return animal.obtenerNombre(); // ❌ Incorrecto: no existe un método con ese nombre en la clase.
            // return animal.getName();       // ❌ Incorrecto: no existe este método en la clase Animal (en Java estándar sería en String, no aquí).
        }
    }
}
