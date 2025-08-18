package SegundoParcialPruebas.Ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio17 {

    public static class FichaMedica {
        private List<Diagnostico> diagnosticos;

        public FichaMedica() {
            this.diagnosticos = new ArrayList<>();
        }

        public void agregarDiagnostico(Diagnostico d) {
            if (d != null) {
                // Línea del campus:
                // {1:MCS:=this.diagnosticos.add(d);~diagnosticos.push(d);~this.diagnosticos = d;~diagnosticos.set(d);}
                this.diagnosticos.add(d); // ✅ Correcto: agrega el diagnóstico a la lista existente de forma segura.
                // diagnosticos.push(d);     // ❌ No compila: List no tiene método push().
                // this.diagnosticos = d;    // ❌ No compila: tipo incompatible; se espera List<Diagnostico>, no Diagnostico.
                // diagnosticos.set(d);      // ❌ No compila: set requiere índice y objeto; no se puede pasar solo el objeto.
            }
        }

        public List<Diagnostico> getDiagnosticos() {
            // Debe respetar el encapsulamiento, tal como se trabaja en la cátedra
            // Línea del campus:
            // return {2:MCS:=Collections.unmodifiableList(this.diagnosticos)~this.diagnosticos~new ArrayList<>(this.diagnosticos)~this.diagnosticos.clone()};
            return Collections.unmodifiableList(this.diagnosticos); // ✅ Correcto: devuelve lista inmutable, evitando modificaciones externas.
            // return this.diagnosticos;                // ⚠️ Compila, pero rompe encapsulamiento; el cliente podría modificar la lista directamente.
            // return new ArrayList<>(this.diagnosticos); // ⚠️ Compila y protege parcialmente; retorna copia, pero permite modificaciones de la copia.
            // return this.diagnosticos.clone();        // ❌ No compila: List no tiene método clone().
        }
    }

    public static class AuditoriaService {
        public void auditarFicha(FichaMedica ficha) {
            List<Diagnostico> logs = ficha.getDiagnosticos();
            try {
                // La siguiente línea debe fallar en tiempo de ejecución.
                // Línea del campus:
                // logs.{3:MCS:=add(new Diagnostico("Intento de modificación"))~get(0)~size()~isEmpty()};
                logs.add(new Diagnostico("Intento de modificación")); // ✅ Correcto: fallará con UnsupportedOperationException, demostrando encapsulamiento.
                // logs.get(0);    // ❌ No provoca excepción; solo obtiene un elemento.
                // logs.size();    // ❌ No provoca excepción; retorna tamaño.
                // logs.isEmpty(); // ❌ No provoca excepción; retorna boolean.
            } catch (UnsupportedOperationException e) {
                System.out.println("Modificación no permitida, encapsulamiento correcto.");
            }
        }
    }

    public static class Diagnostico {
        private String descripcion;

        public Diagnostico(String d) {
            this.descripcion = d;
        }
    }

    public static class Turno {
        public void registrarNuevoDiagnostico(FichaMedica f, String desc) {
            Diagnostico diag = new Diagnostico(desc);
            // Línea del campus:
            // f.{4:MCS:=agregarDiagnostico(diag)~getDiagnosticos().add(diag)~diagnosticos.add(diag)~setDiagnosticos(diag)};
            f.agregarDiagnostico(diag); // ✅ Correcto: utiliza el método público y respeta encapsulamiento.
            // f.getDiagnosticos().add(diag); // ⚠️ Compila, pero rompe encapsulamiento; permite modificar la lista interna directamente.
            // f.diagnosticos.add(diag);      // ❌ No compila: "diagnosticos" es privado.
            // f.setDiagnosticos(diag);       // ❌ No compila: método inexistente y tipo incompatible.
        }
    }
}
