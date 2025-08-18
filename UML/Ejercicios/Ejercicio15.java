package SegundoParcialPruebas.Ejercicios;

import java.util.List;
import java.util.ArrayList;

public class Ejercicio15 {

    // Línea del campus:
    // public class ContenedorGenerico< {1:MCS:=T~E~ITEM~K} > {
    public static class ContenedorGenerico<T> { // ✅ Correcto: "T" es el nombre convencional para un parámetro de tipo genérico. Permite que la clase contenga cualquier tipo.
        // public class ContenedorGenerico<E> {      // ⚠️ Correcto también: E se usa como convención para elementos; funcionalmente equivalente.
        // public class ContenedorGenerico<ITEM> {   // ⚠️ Compila, pero no es la convención estándar; podría confundir a quien lea el código.
        // public class ContenedorGenerico<K> {      // ⚠️ Compila, pero K suele usarse para "Key" en mapas; no refleja que es un tipo de elemento de lista.

        private List<T> elementos;

        public ContenedorGenerico() {
            this.elementos = new ArrayList<>();
        }

        public void agregarElemento(T elemento) {
            this.elementos.add(elemento);
        }

        public T obtenerElemento(int indice) {
            if (indice >= 0 && indice < elementos.size()) {
                // Línea del campus:
                // return elementos.{2:MCS:=get(indice)~obtener(indice)~fetch(indice)~elementAt(indice)};
                return elementos.get(indice); // ✅ Correcto: get() es el método de List para obtener un elemento por índice.
                // return elementos.obtener(indice);   // ❌ No compila: List no tiene método obtener().
                // return elementos.fetch(indice);     // ❌ No compila: List no tiene método fetch().
                // return elementos.elementAt(indice); // ❌ No compila: elementAt() pertenece a Vector, no a List.
            }
            return null;
        }
    }

    public static class ClinicaVeterinaria {
        private ContenedorGenerico<Veterinario> staff;
        // Línea del campus:
        // private {3:MCS:=ContenedorGenerico⟨Animal⟩~Contenedor⟨Animal⟩~List⟨Animal⟩} pacientes;
        private ContenedorGenerico<Animal> pacientes; // ✅ Correcto: permite almacenar cualquier Animal y usar métodos genéricos de ContenedorGenerico.
        // private Contenedor<Animal> pacientes;      // ❌ No compila: Contenedor no existe.
        // private List<Animal> pacientes;            // ⚠️ Compila, pero rompe el uso de la clase genérica ContenedorGenerico.

        public ClinicaVeterinaria() {
            this.staff = new ContenedorGenerico<>();
            this.pacientes = new ContenedorGenerico<>();
        }

        public void agregarVeterinario(Veterinario v) {
            this.staff.agregarElemento(v);
        }

        public void registrarPaciente(Animal a) {
            // Línea del campus:
            // this.pacientes.{4:MCS:=agregarElemento(a)~add(a)~registrar(a)~push(a)};
            this.pacientes.agregarElemento(a); // ✅ Correcto: coincide con el método definido en ContenedorGenerico para agregar un elemento.
            // this.pacientes.add(a);       // ❌ No compila: List tiene add(), pero pacientes es ContenedorGenerico, no List.
            // this.pacientes.registrar(a); // ❌ No compila: registrar() no existe en ContenedorGenerico.
            // this.pacientes.push(a);      // ❌ No compila: push() no existe en ContenedorGenerico.
        }
    }

    // Clases Veterinario y Animal se asumen definidas.
    // Clases de ejemplo asumidas
    public static abstract class Veterinario {
        public abstract String getNombre();
    }

    public static abstract class Animal {
        public abstract String getNombre();
    }
}
