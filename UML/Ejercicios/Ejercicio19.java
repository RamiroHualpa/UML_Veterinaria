package SegundoParcialPruebas.Ejercicios;

public class Ejercicio19 {

    public static class FichaInvalidaException extends Exception {
        public FichaInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public static class FichaMedica {
        private boolean estaActiva;

        public FichaMedica(boolean activa) {
            this.estaActiva = activa;
        }

        public boolean isActiva() {
            return estaActiva;
        }

        public void agregarDiagnostico() {
            // Simulación de agregar diagnóstico
        }
    }

    public static class Veterinario {
        public void registrarDiagnostico(FichaMedica ficha) throws FichaInvalidaException {
            // Línea del campus:
            // {1:MCS:=throw new FichaInvalidaException("La ficha médica no es válida.");~throw new Exception();~return null;~System.exit(1);}
            if (ficha == null || !ficha.isActiva()) {
                throw new FichaInvalidaException("La ficha médica no es válida."); // ✅ Correcto: lanza la excepción específica declarada.
                // throw new Exception();      // ❌ No compila: Exception no es declarada en la firma del método.
                // return null;                // ❌ No compila: método void no retorna valor.
                // System.exit(1);             // ⚠️ Compila, pero termina todo el programa; no es correcto para manejo de excepciones.
            }
            ficha.agregarDiagnostico();
            System.out.println("Diagnóstico registrado correctamente.");
        }
    }

    public static class AsistenteVeterinario {
        public void procesarFicha(Veterinario vet, FichaMedica ficha) {
            // Línea del campus:
            // {2:MCS:=try~catch~finally~if} {
            try { // ✅ Correcto: try permite capturar la excepción lanzada.
                vet.registrarDiagnostico(ficha);
            }
            // Línea del campus:
            // {3:MCS:=catch (FichaInvalidaException e)~catch (Exception e)~except FichaInvalidaException e~when FichaInvalidaException e}
            catch (FichaInvalidaException e) { // ✅ Correcto: coincide con la excepción lanzada por registrarDiagnostico.
                // catch (Exception e) {       // ⚠️ Compila, pero captura todas las excepciones; menos específico.
                // except FichaInvalidaException e { // ❌ No existe en Java; sintaxis incorrecta.
                // when FichaInvalidaException e {  // ❌ No existe en Java; sintaxis incorrecta.
                System.out.println("Error al procesar: " + e.getMessage());
            }
        }

        public void test() {
            Veterinario v = new Veterinario();
            FichaMedica fInactiva = new FichaMedica(false);
            // Línea del campus:
            // {4:MCS:=procesarFicha(v, fInactiva);~v.registrarDiagnostico(fInactiva);~new AsistenteVeterinario().procesarFicha(v, fInactiva);~procesarFicha(v, null);}
            procesarFicha(v, fInactiva); // ✅ Correcto: llama al método que maneja la excepción de forma segura.
            // v.registrarDiagnostico(fInactiva); // ❌ No compila directamente: puede lanzar FichaInvalidaException no manejada.
            // new AsistenteVeterinario().procesarFicha(v, fInactiva); // ⚠️ Compila: crea otra instancia, equivalente funcionalmente, pero innecesario.
            // procesarFicha(v, null);        // ⚠️ Compila: prueba null, también será manejado dentro de procesarFicha.
        }
    }
}
