package SegundoParcialPruebas.Ejercicios;

public class Ejercicio16 {

    public static class Duenio {
        // Línea del campus:
        // {1:MCS:=private String nombre;~public String nombre;~protected String nombre;~String nombre;}
        private String nombre; // ✅ Correcto: encapsula el campo para cumplir con buenas prácticas; se accede mediante getter.
        // public String nombre;   // ⚠️ Compila, pero rompe encapsulamiento; cualquiera puede modificar el campo directamente.
        // protected String nombre; // ⚠️ Compila, acceso limitado a subclases y mismo paquete; no recomendable si queremos control total mediante getter.
        // String nombre;          // ⚠️ Package-private: visible solo dentro del paquete; puede no ser deseable si se accede desde otra clase en otro paquete.

        private Telefono telefono;

        public Duenio(String nombre, String numeroTel) {
            this.nombre = nombre;
            this.telefono = new Telefono(numeroTel);
        }

        public String getNombre() {
            return this.nombre;
        }

        public String getNumeroTelefono() {
            if (this.telefono != null) {
                // Línea del campus:
                // return this.telefono.{2:MCS:=getNumero()~numero~fetchNumero()~leerNumero()};
                return this.telefono.getNumero(); // ✅ Correcto: getNumero() es el getter público (o package-private) definido en Telefono.
                // return this.telefono.numero;     // ❌ No compila: "numero" es privado en Telefono.
                // return this.telefono.fetchNumero(); // ❌ No compila: no existe este método en Telefono.
                // return this.telefono.leerNumero(); // ❌ No compila: no existe este método en Telefono.
            }
            return "N/A";
        }
    }

    public static class Telefono {
        private String numero;

        public Telefono(String n) {
            this.numero = n;
        }

        String getNumero() { return numero; } // ✅ Correcto: método de acceso al campo privado.
        // public String numero() { return numero; } // ❌ No existe en el código proporcionado; nombre incorrecto.
        // String fetchNumero() { return numero; } // ❌ No existe; método inventado.
        // String leerNumero() { return numero; } // ❌ No existe; método inventado.
    }

    public static class SistemaAdministrativo {
        public void imprimirDatosDuenio(Duenio duenio) {
            // Línea del campus:
            // String nombre = duenio.{3:MCS:=getNombre()~get("nombre")~fetchNombre()~getName()};
            String nombre = duenio.getNombre(); // ✅ Correcto: accede al getter público definido en Duenio.
            // String nombre = duenio.get("nombre"); // ❌ No compila: no existe método get(String) en Duenio.
            // String nombre = duenio.fetchNombre(); // ❌ No compila: no existe fetchNombre().
            // String nombre = duenio.getName();     // ❌ No compila: método no definido en Duenio.

            System.out.println("Nombre: " + nombre);
            // Línea del campus:
            // System.out.println("Teléfono: " + duenio.{4:MCS:=getNumeroTelefono()~getTelefono().getNumero()~telefono.numero~getTelefono()});
            System.out.println("Teléfono: " + duenio.getNumeroTelefono()); // ✅ Correcto: se invoca método público seguro de Duenio.
            // System.out.println("Teléfono: " + duenio.getTelefono().getNumero()); // ❌ No compila: getTelefono() no existe; teléfono es privado.
            // System.out.println("Teléfono: " + duenio.telefono.numero);          // ❌ No compila: campos privados inaccesibles directamente.
            // System.out.println("Teléfono: " + duenio.getTelefono());            // ❌ No compila: getTelefono() no existe; retorna Telefono, no String.
        }
    }
}
