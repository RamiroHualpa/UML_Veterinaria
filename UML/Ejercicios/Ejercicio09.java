package SegundoParcialPruebas.Ejercicios;

public class Ejercicio09 {

    public abstract static class Animal {
        private String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        // Línea del campus:
        // public {1:MCS:=abstract String~virtual String~String~final String} getTipoAlimentacion();
        public abstract String getTipoAlimentacion(); // ✅ Correcto: un método abstracto obliga a las subclases a implementarlo. Es lo esperado en este escenario.
        // public virtual String getTipoAlimentacion(); // ❌ No compila: "virtual" no existe en Java (es propio de C#).
        // public String getTipoAlimentacion();         // ❌ Compila, pero sería incorrecto: define un método vacío sin cuerpo en una clase abstracta, rompiendo la intención de polimorfismo. Obliga a dar implementación base, aunque debería ser abstracto.
        // public final String getTipoAlimentacion();   // ❌ Compila, pero es incorrecto: final evita que subclases como Perro lo sobrescriban, contradiciendo el objetivo del ejercicio.
    }

    public static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        // Línea del campus:
        // {2:MCS:=@Override~Override~@Implements~Overwrite}
        @Override // ✅ Correcto: asegura que estamos sobrescribiendo el método abstracto definido en la superclase.
        // Override   // ❌ No compila: no es una anotación válida en Java, solo una palabra suelta.
        // @Implements // ❌ No compila: no existe esta anotación en Java estándar, confunde con conceptos de interfaces.
        // @Overwrite  // ❌ No compila en Java SE: es una anotación de algunos frameworks (ej. Minecraft mods), no parte del lenguaje.
        public String getTipoAlimentacion() {
            return "Omnívoro";
        }
    }

    public static class VeterinariaService {
        public void mostrarInfoAlimentacion(Animal animal) {
            if (animal != null) {
                // Línea del campus:
                // String tipo = animal.{3:MCS:=getTipoAlimentacion()~tipoAlimentacion()~fetchAlimentacion()~getAlimentacion()};
                String tipo = animal.getTipoAlimentacion(); // ✅ Correcto: el método está declarado en Animal y sobrescrito en Perro.
                // String tipo = animal.tipoAlimentacion();  // ❌ No compila: no existe un método con ese nombre.
                // String tipo = animal.fetchAlimentacion(); // ❌ No compila: no existe un método con ese nombre.
                // String tipo = animal.getAlimentacion();   // ❌ No compila: no existe un método con ese nombre.

                System.out.println("El animal " + animal.getNombre() + " es " + tipo);
            }
        }

        public void test() {
            Perro p = new Perro("Fido");
            // Esto debe causar un error de compilación.
            // Línea del campus:
            // Animal a = {4:MCS:=new Animal("Rex")~new Perro("Rex")~p~null};
            // ✅ RESPUESTA CORRECTA
            // Animal a = new Animal("Rex"); // ❌ Intencionalmente incorrecto: no compila porque Animal es abstracto y no puede instanciarse directamente.
            // Animal a = new Perro("Rex"); // ⚠️ Compila y es válido: pero no cumple con la consigna ("esto debe causar error de compilación").
            // Animal a = p;                // ⚠️ Compila y es válido: asigna la referencia de Perro a una variable de tipo Animal. También rompe la consigna porque no genera error.
            // Animal a = null;             // ⚠️ Compila y es válido: asigna null, pero no genera error de compilación. Tampoco cumple con la consigna.

            mostrarInfoAlimentacion(p);
        }
    }
}
