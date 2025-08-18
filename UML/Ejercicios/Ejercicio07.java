package SegundoParcialPruebas.Ejercicios;

public class Ejercicio07 {

    public abstract static class Animal {
        private String nombre;
        public Animal(String nombre) { this.nombre = nombre; }
        public String getNombre() { return nombre; }
    }

    public static class Perro extends Animal {
        public Perro(String n) { super(n); }
        public void ladrar() { System.out.println(getNombre() + " ladra."); }
    }

    public static class Gato extends Animal {
        private String color;
        public Gato(String n, String c) { super(n); this.color = c; }
        public String getColor() { return color; }
    }

    public static class Cuidador {
        public void cuidarAnimal(Animal animal) {
            System.out.println("Cuidando a " + animal.getNombre());
            if (animal instanceof Perro) {
                // Línea del campus:
                // Perro p = ({1:MCS:=(Perro) animal~(new Perro())~animal.asPerro()~Perro.from(animal)});
                Perro p = (Perro) animal; // ✅ Correcto: hacemos downcasting de Animal a Perro.
                // Perro p = (new Perro());     // ❌ No compila: falta el parámetro del constructor.
                // Perro p = animal.asPerro();  // ❌ No compila: no existe asPerro() en Animal.
                // Perro p = Perro.from(animal);// ❌ No compila: no existe from() en Perro.

                // p.{2:MCS:=ladrar()~ladra()~getLadrido()~doLadrar()};
                p.ladrar(); // ✅ Correcto: método definido en Perro.
                // p.ladra();      // ❌ No compila: no existe el método ladra().
                // p.getLadrido(); // ❌ No compila: no existe el método getLadrido().
                // p.doLadrar();   // ❌ No compila: no existe el método doLadrar().
            }
        }

        public Gato registrarNuevoGato(String nombre, String color) {
            Gato nuevoGato = new Gato(nombre, color);

            // Línea del campus:
            // {3:MCS:=Animal animalDeClinica = nuevoGato;~Object o = nuevoGato;~Animal a = new Animal("temp");~var a = (Animal) nuevoGato;}
            Animal animalDeClinica = nuevoGato; // ✅ Correcto: se asigna la subclase Gato a la superclase Animal.
            // Object o = nuevoGato;            // ❌ Compila, pero perderíamos acceso a getNombre() sin casteo posterior.
            // Animal a = new Animal("temp");   // ❌ No compila: Animal es abstracto, no puede instanciarse.
            // var a = (Animal) nuevoGato;      // ❌ Falla por el nombre de la variable que se utiliza luego.

            System.out.println(animalDeClinica.getNombre() + " registrado.");

            // Gato g = ({4:MCS:=(Gato) animalDeClinica~animalDeClinica~(new Gato())~Gato.cast(animalDeClinica)});
            Gato g = (Gato) animalDeClinica; // ✅ Correcto: downcasting explícito de Animal a Gato.
            // Gato g = animalDeClinica;       // ❌ No compila: no se puede asignar superclase a subclase sin cast.
            // Gato g = (new Gato());          // ❌ No compila: falta pasar parámetros al constructor de Gato.
            // Gato g = Gato.cast(animalDeClinica); // ❌ No compila: no existe el método cast en Gato.

            System.out.println("Es un gato de color " + g.getColor());

            return nuevoGato;
        }
    }
}
