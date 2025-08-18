package SegundoParcialPruebas.Ejercicios;

import java.util.List;
import java.util.ArrayList;

public class Ejercicio14 {

    public static class Medicamento {
        private String nombre;
        public Medicamento(String n) { this.nombre = n; }
        public String getNombre() { return nombre; }
    }

    public static class FichaMedica {
        private List<TratamientoRealizado> historial;

        public FichaMedica() {
            // Línea del campus:
            // this.historial = {1:MCS:=new ArrayList⟨⟩()~new List⟨⟩()~new ArrayList⟨Medicamento⟩()~new List⟨Medicamento⟩()};
            this.historial = new ArrayList<>(); // ✅ Correcto: el campo es List<TratamientoRealizado>; el operador diamante <> infiere TratamientoRealizado desde la declaración del campo.
            // this.historial = new List<>();               // ❌ No compila: List es una interfaz; no puede instanciarse directamente.
            // this.historial = new ArrayList<Medicamento>(); // ❌ No compila: tipo incompatible. Se espera List<TratamientoRealizado> y se está creando ArrayList<Medicamento>.
            // this.historial = new List<Medicamento>();      // ❌ No compila: además de ser interfaz, el genérico no coincide con el tipo declarado del campo.
        }

        public void agregarTratamiento(TratamientoRealizado tr) {
            this.historial.add(tr);
        }

        public List<TratamientoRealizado> getHistorialDeTratamientos() {
            return historial;
        }
    }

    public static class TratamientoRealizado {
        // Línea del campus:
        // private {2:MCS:=List⟨Medicamento⟩~Collection⟨Medicamento⟩~Medicamento[]~Set⟨Medicamento⟩} medicamentos;
        private List<Medicamento> medicamentos; // ✅ Correcto: concuerda con el uso (new ArrayList<>(), add(), getMedicamentos() retorna List<Medicamento>).
        // private Collection<Medicamento> medicamentos; // ❌ No compila con el código actual: el método getMedicamentos() retorna List<Medicamento> pero aquí sería Collection<Medicamento>; "return medicamentos;" no satisface la firma.
        // private Medicamento[] medicamentos;           // ❌ No compila: en el constructor se asigna new ArrayList<>(), que no es un arreglo. Además, addMedicamento usa add(), inexistente en arrays.
        // private Set<Medicamento> medicamentos;        // ❌ No compila con el código actual: se asigna new ArrayList<>(), incompatible con Set. También getMedicamentos() retorna List<Medicamento>, no Set.
        public TratamientoRealizado() {
            this.medicamentos = new ArrayList<>();
        }
        public void addMedicamento(Medicamento m) {
            this.medicamentos.add(m);
        }
        public List<Medicamento> getMedicamentos() { return medicamentos; }
    }

    public static class ReporteMedicamentos {
        public void imprimirMedicamentosDeFicha(FichaMedica ficha) {
            for (TratamientoRealizado tr : ficha.getHistorialDeTratamientos()) {
                // Línea del campus:
                // for ({3:MCS:=Medicamento med : tr.getMedicamentos()~med : tr.getMedicamentos()~Object med : tr.getMedicamentos()~var med : tr.medicamentos}) {
                for (Medicamento med : tr.getMedicamentos()) { // ✅ Correcto: getMedicamentos() retorna List<Medicamento>, por lo que el tipo del iterado debe ser Medicamento.
                    // for (med : tr.getMedicamentos()) {      // ❌ No compila: falta el tipo explícito o "var" para inferencia.
                    // for (Object med : tr.getMedicamentos()) { // ❌ El for podría compilar (Object es supertipo), pero la línea siguiente falla: Object no tiene getNombre() → error de compilación.
                    // for (var med : tr.medicamentos) {       // ❌ No compila: "medicamentos" es privado en TratamientoRealizado; además, acceder a campos directamente rompe el encapsulamiento.
                    // Línea del campus:
                    // System.out.println("Medicamento: " + med.{4:MCS:=getNombre()~nombre~fetchNombre()~name()});
                    System.out.println("Medicamento: " + med.getNombre()); // ✅ Correcto: se invoca el getter público definido en Medicamento.
                    // System.out.println("Medicamento: " + med.nombre);        // ❌ No compila: el campo "nombre" es privado en Medicamento.
                    // System.out.println("Medicamento: " + med.fetchNombre()); // ❌ No compila: no existe el método fetchNombre() en Medicamento.
                    // System.out.println("Medicamento: " + med.name());        // ❌ No compila: name() es típico de enum; no existe en esta clase.
                }
            }
        }
    }
}
