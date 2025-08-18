package SegundoParcialPruebas.Ejercicios;

public class Ejercicio12 {

    public abstract static class Animal {
        public abstract String getDescripcion();
    }

    public static class Perro extends Animal {
        private String raza;
        public Perro(String raza) { this.raza = raza; }
        @Override
        public String getDescripcion() { return "Perro de raza " + raza; }
    }

    public static class Gato extends Animal {
        private String color;
        public Gato(String color) { this.color = color; }
        @Override
        public String getDescripcion() { return "Gato de color " + color; }
    }

    public static class AnimalFactory {
        // Línea del campus:
        // public static {1:MCS:=Animal~Perro~Gato~String} crearAnimal(String tipo, String detalle) {
        public static Animal crearAnimal(String tipo, String detalle) { // ✅ Correcto: la fábrica puede devolver distintas subclases; el tipo de retorno debe ser el supertipo común (Animal) para permitir polimorfismo.
            // public static Perro crearAnimal(String tipo, String detalle) { // ❌ No compila con el cuerpo actual: en la rama "gato" se retorna un Gato, incompatible con retorno Perro (error de tipos).
            // public static Gato crearAnimal(String tipo, String detalle) {  // ❌ No compila con el cuerpo actual: en la rama "perro" se retorna un Perro, incompatible con retorno Gato (error de tipos).
            // public static String crearAnimal(String tipo, String detalle) { // ❌ No compila: el método retorna objetos Animal/Perro/Gato; "String" no es compatible.

            if ("perro".equalsIgnoreCase(tipo)) {
                // Línea del campus:
                // return {2:MCS:=new Perro(detalle)~new Animal(detalle)~Perro.create(detalle)~new Object()};
                return new Perro(detalle); // ✅ Correcto: se instancia la clase concreta Perro, que es un Animal.
                // return new Animal(detalle);      // ❌ No compila: Animal es abstracto; no se puede instanciar.
                // return Perro.create(detalle);    // ❌ No compila: no existe un método de fábrica estático "create" en Perro.
                // return new Object();             // ❌ No compila: Object no es subtipo de Animal (no se puede convertir implicitamente a Animal).
            } else if ("gato".equalsIgnoreCase(tipo)) {
                return new Gato(detalle); // ✅ Coincide con la firma que retorna Animal.
            }
            return null; // ⚠️ Válido pero discutible: en una fábrica real podría lanzarse IllegalArgumentException para tipos no soportados.
        }
    }

    public static class SistemaVeterinaria {
        public void registrarYMostrar(String tipo, String detalle) {
            // Línea del campus:
            // {3:MCS:=Animal nuevoAnimal = AnimalFactory.crearAnimal(tipo, detalle);~Object nuevoAnimal = AnimalFactory.crearAnimal(tipo, detalle);~Perro nuevoAnimal = (Perro)AnimalFactory.crearAnimal(tipo, detalle);~Gato nuevoAnimal = (Gato)AnimalFactory.crearAnimal(tipo, detalle);}

            Animal nuevoAnimal = AnimalFactory.crearAnimal(tipo, detalle);
            // ✅ Correcto: mantiene el polimorfismo y la seguridad de tipos para invocar métodos de Animal.

            // Object nuevoAnimal = AnimalFactory.crearAnimal(tipo, detalle);
            // ❌ No compila con el uso posterior: "nuevoAnimal" sería de tipo Object y no tendría getDescripcion();
            // fallaría en la línea de impresión.

            // Perro nuevoAnimal = (Perro) AnimalFactory.crearAnimal(tipo, detalle);
            // ⚠️ Compila, pero es incorrecto/arriesgado: si tipo="gato", se retorna Gato y el cast provocará
            // ClassCastException en tiempo de ejecución.

            // Gato nuevoAnimal = (Gato) AnimalFactory.crearAnimal(tipo, detalle);
            // ⚠️ Compila, pero es incorrecto/arriesgado: si tipo="perro", el cast fallará con ClassCastException en tiempo de ejecución.

            if (nuevoAnimal != null) {
                // Línea del campus:
                // System.out.println("Registrado: " + nuevoAnimal.{4:MCS:=getDescripcion()~descripcion()~fetchDescripcion()~verDescripcion()});
                System.out.println("Registrado: " + nuevoAnimal.getDescripcion()); // ✅ Correcto: método declarado en Animal y sobrescrito en Perro/Gato.
                // System.out.println("Registrado: " + nuevoAnimal.descripcion());     // ❌ No compila: no existe el método descripcion() en la jerarquía.
                // System.out.println("Registrado: " + nuevoAnimal.fetchDescripcion()); // ❌ No compila: no existe el método fetchDescripcion().
                // System.out.println("Registrado: " + nuevoAnimal.verDescripcion());  // ❌ No compila: no existe el método verDescripcion().
            }
        }
    }
}
