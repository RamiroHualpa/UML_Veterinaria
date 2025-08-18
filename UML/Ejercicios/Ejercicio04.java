package SegundoParcialPruebas.Ejercicios;

public class Ejercicio04 {

    public abstract static class Animal {
        private FichaMedica fichaMedica;

        public Animal() {
            // Línea del campus:
            // this.fichaMedica = {1:MCS:=new FichaMedica()~null~FichaMedica.create()~new FichaMedica(this)};
            this.fichaMedica = new FichaMedica(); // ✅ Correcto: se inicializa la ficha médica al crear el Animal.
            //❌ this.fichaMedica = null;                // ❌ Compila, pero es mala práctica: dejaría la ficha sin inicializar y causaría NullPointerException al acceder a métodos.
            // this.fichaMedica = FichaMedica.create(); // ❌ No compila: no existe un método estático create() en la clase FichaMedica.
            // this.fichaMedica = new FichaMedica(this); // ❌ No compila: el constructor de FichaMedica no recibe parámetros (según definición dada).
        }

        public FichaMedica getFichaMedica() {
            return this.fichaMedica;
        }
    }

    public static class Perro extends Animal {
        private String nombre;

        // Línea del campus:
        // {2:MCS:=super();~this();~Animal();~super.init();}
        public Perro(String nombre) {
            super(); // ✅ Correcto: llama al constructor de la clase padre (Animal), inicializando la ficha.
            // this();      // ❌ No compila: "this()" solo invoca a otro constructor de la misma clase; aquí no hay constructor sin parámetros definido.
            // Animal();    // ❌ No compila: no se puede invocar un constructor de la superclase directamente por nombre.
            // super.init(); // ❌ No compila: no existe un método init() en Animal.
            this.nombre = nombre;
        }

        public String getNombre() {
            return this.nombre;
        }
    }

    public static class SistemaRegistro {
        public void registrarDiagnostico(Perro p, Diagnostico d) {
            if (p != null && d != null) {
                // Línea del campus:
                // FichaMedica fm = p.{3:MCS:=getFichaMedica()~fichaMedica~fetchFichaMedica()~copyFichaMedica()};
                FichaMedica fm = p.getFichaMedica(); // ✅ Correcto: accede al objeto mediante el getter público definido en Animal.
                // FichaMedica fm = p.fichaMedica;        // ❌ No compila: el atributo fichaMedica es private en Animal, no accesible desde fuera de la clase.
                // FichaMedica fm = p.fetchFichaMedica(); // ❌ No compila: no existe un método fetchFichaMedica().
                // FichaMedica fm = p.copyFichaMedica();  // ❌ No compila: no existe un método copyFichaMedica().

                fm.agregarDiagnostico(d);
            }
        }
    }

    // Clases auxiliares
    static class FichaMedica {
        public void agregarDiagnostico(Diagnostico d) {
            // Lógica interna, se asume implementada
        }
    }

    static class Diagnostico {
        // Se asume implementación interna
    }
}

