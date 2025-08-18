package SegundoParcialPruebas.Ejercicios;

public class Ejercicio20 {

    public static class Turno {
        private Animal animal;

        public Turno(Animal a) {
            this.animal = a;
        }

        public Animal getAnimal() {
            return animal;
        }
    }

    public static class GestorTurnos {
        public void imprimirNombreMascota(Turno turno) {
            // Línea del campus:
            // {1:MCS:=try~if (turno != null)~while(true)~for(;;)}
            try { // ✅ Correcto: try permite capturar excepciones si turno o animal son nulos.
                // if (turno != null)     // ⚠️ Solo valida null, pero puede lanzar NullPointerException al obtener animal nulo.
                // while(true)             // ❌ No tiene sentido; genera bucle infinito.
                // for(;;)                 // ❌ No tiene sentido; genera bucle infinito.

                Animal a = turno.getAnimal();
                String nombre = a.getNombre();
                System.out.println("Mascota del turno: " + nombre);
            }
            // Línea del campus:
            // {2:MCS:=catch (NullPointerException e)~catch (Exception e)~catch (Error e)~catch (RuntimeException e)}
            catch (NullPointerException e) { // ✅ Correcto: captura null en turno o animal.
                // catch (Exception e)        // ⚠️ Captura más amplio; menos específico que NullPointerException.
                // catch (Error e)            // ❌ No compila; errores son distintos y no deseados para control normal.
                // catch (RuntimeException e) // ⚠️ Captura más amplio; NullPointerException es RuntimeException, pero menos específico.
                System.out.println("Error: El turno o el animal es nulo.");
            }
            // Línea del campus:
            // {3:MCS:=finally~else~after~complete}
            finally { // ✅ Correcto: bloque que siempre se ejecuta después del try/catch.
                // else     // ❌ Sintaxis incorrecta; else se usa con if.
                // after    // ❌ No existe en Java.
                // complete // ❌ No existe en Java.
                System.out.println("Procesamiento del turno finalizado.");
            }
        }

        public void ejecutar() {
            Turno turnoValido = new Turno(new Animal("Fido"));
            Turno turnoInvalido = new Turno(null);
            imprimirNombreMascota(turnoValido);
            // Línea del campus:
            // {4:MCS:=turnoInvalido~null~new Turno(new Animal(null))~new Turno()}
            imprimirNombreMascota(turnoInvalido); // ✅ Correcto: pasa el turno con animal nulo para probar manejo de excepción.
            // null                         // ❌ No compila: se espera un Turno, no null directamente.
            // new Turno(new Animal(null))  // ⚠️ Compila, pero dispararía IllegalStateException en getNombre(); es otra prueba.
            // new Turno()                   // ❌ No compila: constructor por defecto inexistente.
        }
    }

    public static class Animal {
        private String nombre;

        public Animal(String n) {
            this.nombre = n;
        }

        public String getNombre() {
            if (this.nombre == null) throw new IllegalStateException(); // ✅ Correcto: evita retornar nombre nulo.
            return this.nombre;
        }
    }
}
