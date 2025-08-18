package SegundoParcialPruebas.Ejercicios;

import java.time.LocalDate;

public class Ejercicio13 {

    // Línea del campus:
    // public {1:MCS:=interface~abstract class~class~enum} Imprimible {
    public interface Imprimible { // ✅ Correcto: el enunciado pide un contrato que pueda implementarse en distintas clases. Un "interface" es el mecanismo apropiado en Java.
        // public abstract class Imprimible { // ⚠️ Compila, pero obligaría a extender esta clase, limitando la herencia múltiple. El enunciado claramente apunta a una interfaz.
        // public class Imprimible {         // ❌ No compila con el uso actual: al no ser interfaz, no podría usarse con "implements" en Turno.
        // public enum Imprimible {          // ❌ No compila: un enum no puede declarar un método sin valores de enumeración definidos.

        String getContenidoImpresion();
    }

    public static class Turno implements Imprimible {
        private LocalDate fecha;
        private Animal animal;

        public Turno(LocalDate fecha, Animal animal) {
            this.fecha = fecha;
            this.animal = animal;
        }

        // Línea del campus:
        // {2:MCS:=@Override~@Implements~@Default~@Required}
        @Override // ✅ Correcto: sobrescribe el método definido en la interfaz Imprimible.
        // @Implements  // ❌ No compila: no existe esta anotación en Java SE; se usa la palabra clave "implements" en la declaración de clase.
        // @Default     // ❌ No compila: no existe en Java SE; "default" solo aplica para métodos con implementación en interfaces.
        // @Required    // ❌ No compila: anotación inexistente en Java SE.
        public String getContenidoImpresion() {
            return "Turno del " + fecha.toString() + " para " + animal.getNombre();
        }
    }

    public static class ImpresoraService {
        // Línea del campus:
        // public void imprimirDocumento({3:MCS:=Imprimible doc~Object doc~Turno doc~String doc}) {
        public void imprimirDocumento(Imprimible doc) { // ✅ Correcto: el servicio recibe cualquier objeto que implemente Imprimible, permitiendo polimorfismo.
            // public void imprimirDocumento(Object doc) { // ❌ No compila con el uso: Object no tiene getContenidoImpresion().
            // public void imprimirDocumento(Turno doc) {
                 // ⚠️ Compila, pero rompe la generalidad: solo podría imprimir Turno, no cualquier Imprimible.
            // public void imprimirDocumento(String doc) { // ❌ No compila: String no tiene getContenidoImpresion().

            if (doc != null) {
                String contenido = doc.getContenidoImpresion();
                System.out.println("--- INICIO DOCUMENTO ---");
                System.out.println(contenido);
                System.out.println("--- FIN DOCUMENTO ---");
            }
        }

        public void gestionarImpresion() {
            Animal a = new Perro("Bobby");
            Turno t = new Turno(LocalDate.now(), a);

            // Línea del campus:
            // {4:MCS:=imprimirDocumento(t);~imprimirDocumento(t.toString());~imprimirDocumento((Object)t);~imprimirDocumento(t.getContenidoImpresion());}
            imprimirDocumento(t); // ✅ Correcto: Turno implementa Imprimible, por lo tanto se puede pasar directamente al método.
            // imprimirDocumento(t.toString());          // ❌ No compila: toString() retorna String y el método espera Imprimible.
            // imprimirDocumento((Object)t);             // ❌ No compila: Object no implementa Imprimible, pérdida de la capacidad de invocar getContenidoImpresion().
            // imprimirDocumento(t.getContenidoImpresion()); // ❌ No compila: getContenidoImpresion() retorna String, no un Imprimible.
        }
    }

    public abstract static class Animal {
        public abstract String getNombre();
    }

    public static class Perro extends Animal {
        private String nombre;
        public Perro(String n) { this.nombre = n; }
        public String getNombre() { return nombre; }
    }
}
