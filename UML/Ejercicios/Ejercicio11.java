package SegundoParcialPruebas.Ejercicios;

public class Ejercicio11 {

    public abstract static class Veterinario {
        private String nombre;

        public Veterinario(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void atender() {
            System.out.println(getNombre() + " está atendiendo.");
        }

        public abstract String getEspecialidad();
    }

    public static class VeterinarioGeneral extends Veterinario {
        public VeterinarioGeneral(String nombre) {
            // Línea del campus:
            // {1:MCS:=super(nombre);~this(nombre);~Veterinario(nombre);~new Veterinario(nombre);}
            super(nombre); // ✅ Correcto: invoca el constructor de la superclase para inicializar el estado heredado.
            // this(nombre);            // ❌ No compila: no existe otro constructor en VeterinarioGeneral con esa firma para encadenar con this(...).
            // Veterinario(nombre);     // ❌ No compila: no es sintaxis válida; para invocar al constructor padre se debe usar "super(...)"; esto se interpreta como llamada a método inexistente.
            // new Veterinario(nombre); // ❌ No compila: Veterinario es abstracto y no puede instanciarse directamente.
        }

        // Línea del campus:
        // {2:MCS:=@Override~@Abstract~@Implements~@Final}
        @Override                  // ✅ Correcto: sobrescribe el método abstracto definido en Veterinario.
        // @Abstract               // ❌ No compila: no existe esta anotación en Java SE; "abstract" es un modificador, no una anotación.
        // @Implements             // ❌ No compila: anotación inexistente en Java SE; confunde con la palabra clave "implements" para interfaces.
        // @Final                  // ❌ No compila: no existe esta anotación en Java SE; "final" es un modificador, no una anotación.
        public String getEspecialidad() {
            return "Medicina General";
        }
    }

    public static class Clinica {
        public void procesarAtencion(Veterinario v) {
            // Línea del campus:
            // v.{3:MCS:=atender()~doAtender()~realizarAtencion()~atencion()};
            v.atender(); // ✅ Correcto: método definido en la clase base Veterinario.
            // v.doAtender();        // ❌ No compila: no existe el método doAtender() en la jerarquía.
            // v.realizarAtencion(); // ❌ No compila: no existe el método realizarAtencion().
            // v.atencion();         // ❌ No compila: no existe el método atencion().

            // Línea del campus:
            // System.out.println("Especialidad: " + v.{4:MCS:=getEspecialidad()~especialidad()~fetchEspecialidad()~getTipoEspecialidad()});
            System.out.println("Especialidad: " + v.getEspecialidad()); // ✅ Correcto: método abstracto en Veterinario e implementado en VeterinarioGeneral.
            // System.out.println("Especialidad: " + v.especialidad());        // ❌ No compila: no existe el método especialidad().
            // System.out.println("Especialidad: " + v.fetchEspecialidad());   // ❌ No compila: no existe el método fetchEspecialidad().
            // System.out.println("Especialidad: " + v.getTipoEspecialidad()); // ❌ No compila: no existe el método getTipoEspecialidad().
        }

        public void iniciarJornada() {
            VeterinarioGeneral vet = new VeterinarioGeneral("Dr. Pérez");
            procesarAtencion(vet);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Clinica clinica = new Clinica();
            clinica.iniciarJornada();
        }
    }
}
