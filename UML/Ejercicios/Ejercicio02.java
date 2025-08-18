package SegundoParcialPruebas.Ejercicios;

public class Ejercicio02 {

    // Clase abstracta base
    public abstract static class Animal {
        protected EstadoAnimal estado;

        public Animal() {
            this.estado = EstadoAnimal.SALUDABLE;
        }

        public EstadoAnimal getEstado() {
            return estado;
        }

        public void setEstado(EstadoAnimal estado) {
            this.estado = estado;
        }
    }

    public static class Perro extends Animal {
        private Raza raza;

        // Línea del campus:
        // {1:MCS:=super();~this();~Animal.init();~super.estado = EstadoAnimal.SALUDABLE;}
        public Perro(Raza raza) {
            super(); // ✅ Correcto: se llama al constructor de la clase padre (Animal).
            // this();                       // ❌ Incorrecto: "this()" solo puede invocar a otro constructor de la misma clase, no aplica aquí.
            // Animal.init();                // ❌ Incorrecto: no existe un método init() en la clase Animal.
            // super.estado = EstadoAnimal.SALUDABLE; // ❌ Incorrecto: aunque compilaría, rompe la encapsulación ya que
                                                    // la lógica de inicialización ya está en el constructor de Animal.
            this.raza = raza;
        }

        public Raza getRaza() {
            return raza;
        }
    }

    public static class ClinicaService {
        public Perro registrarNuevoPerro(String nombreRaza) {
            Raza r = new Raza(nombreRaza, "Canina");
            Perro p = new Perro(r);

            // Línea del campus:
            // {2:MCS:=Animal a = p;~Object o = p;~Perro p2 = (Perro) new Animal();~Animal a = new Animal();}
            Animal a = p; // ✅ Correcto: un Perro puede asignarse a una referencia de tipo Animal (polimorfismo).
            // Object o = p;                     // ❌ Incorrecto en este contexto: aunque válido, se pierde acceso a métodos de Animal (como setEstado).
            // Perro p2 = (Perro) new Animal();  // ❌ Incorrecto: no se puede instanciar una clase abstracta.
            // Animal a = new Animal();          // ❌ Incorrecto: no se puede instanciar una clase abstracta.

            // Línea del campus:
            // a.setEstado({3:MCS:=EstadoAnimal.EN_TRATAMIENTO~"EN_TRATAMIENTO"~Estado.TRATAMIENTO~EstadoAnimal.NUEVO});
            a.setEstado(EstadoAnimal.EN_TRATAMIENTO); // ✅ Correcto: se asigna un valor válido del enum.
            // a.setEstado("EN_TRATAMIENTO");           // ❌ Incorrecto: el método espera un EstadoAnimal, no un String.
            // a.setEstado(Estado.TRATAMIENTO);        // ❌ Incorrecto: no existe un enum Estado, el correcto es EstadoAnimal.
            // a.setEstado(EstadoAnimal.NUEVO);        // ❌ Incorrecto: el literal NUEVO no está definido en el enum.

            System.out.println("Se registró el animal en estado: " + a.getEstado());
            return p;
        }
    }

    enum EstadoAnimal { SALUDABLE, EN_TRATAMIENTO, RECUPERADO }

    static class Raza {
        String nombre;
        String especie;

        public Raza(String n, String e) {
            this.nombre = n;
            this.especie = e;
        }
    }
}
