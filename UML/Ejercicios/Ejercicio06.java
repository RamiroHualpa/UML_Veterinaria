package SegundoParcialPruebas.Ejercicios;

public class Ejercicio06 {

    public abstract static class Animal {
        public void realizarChequeo() {
            System.out.println("Realizando chequeo general de animal.");
        }
    }

    public static class Perro extends Animal {
        // Línea del campus:
        // {1:MCS:=@Override~@Override(Animal)~@Overwrite~@Final}
        @Override // ✅ Correcto: indica que estamos sobrescribiendo un método de la superclase.
        // @Override(Animal) // ❌ No compila: la anotación @Override no acepta parámetros.
        // @Overwrite        // ❌ No compila: no existe la anotación @Overwrite en Java estándar.
        // @Final            // ❌ No compila: no existe la anotación @Final en Java estándar (final es un modificador, no una anotación).
        public void realizarChequeo() {
            super.realizarChequeo();
            System.out.println("Verificando vacunas de rabia.");
        }
    }

    public static class Gato extends Animal {
        @Override
        public void realizarChequeo() {
            super.realizarChequeo();
            System.out.println("Realizando chequeo de leucemia felina.");
        }
    }

    public static class Turno {
        private Animal animal;

        public Turno(Animal animal) {
            this.animal = animal;
        }

        public void ejecutarChequeo() {
            if (this.animal != null) {
                // Línea del campus:
                // this.animal.{2:MCS:=realizarChequeo();~chequeo();~doCheck();~executeChequeo();};
                this.animal.realizarChequeo(); // ✅ Correcto: llama al método definido en Animal y sobrescrito en subclases.
                // this.animal.chequeo();       // ❌ No compila: no existe un método chequeo().
                // this.animal.doCheck();       // ❌ No compila: no existe un método doCheck().
                // this.animal.executeChequeo();// ❌ No compila: no existe un método executeChequeo().
            } else {
                System.out.println("No hay animal asignado para este turno.");
            }
        }
    }

    public static class Clinica {
        public void iniciarTurnos() {
            Perro miPerro = new Perro();
            Gato miGato = new Gato();

            // Línea del campus:
            // Turno turnoPerro = new Turno({3:MCS:=miPerro~new Animal()~miGato.toAnimal()~(Animal) new Perro()});
            Turno turnoPerro = new Turno(miPerro); // ✅ Correcto: pasamos la instancia de Perro (subclase de Animal).
            // Turno turnoPerro = new Turno(new Animal());     // ❌ No compila: Animal es abstracto, no puede instanciarse.
            // Turno turnoPerro = new Turno(miGato.toAnimal()); // ❌ No compila: no existe el método toAnimal() en Gato.
            // Turno turnoPerro = new Turno((Animal) new Perro()); // ❌ Compila, pero es redundante: el cast es innecesario porque Perro ya es un Animal.

            Turno turnoGato = new Turno(miGato);

            // Línea del campus:
            // turnoGato.{4:MCS:=ejecutarChequeo();~run();~start();~chequeoGato();};
            turnoGato.ejecutarChequeo(); // ✅ Correcto: llama al método definido en Turno.
            // turnoGato.run();            // ❌ No compila: no existe el método run() en Turno.
            // turnoGato.start();          // ❌ No compila: no existe el método start() en Turno.
            // turnoGato.chequeoGato();    // ❌ No compila: no existe el método chequeoGato().
        }
    }
}
