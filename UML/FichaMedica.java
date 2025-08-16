/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hualp
 */
class FichaMedica {
    private List<Diagnostico> diagnosticos; //Composición

    public FichaMedica(){
        this.diagnosticos = new ArrayList<>();
    }

    public void agregarDiagnostico(String descripcion, LocalDate fecha){
        diagnosticos.add(new Diagnostico(descripcion, fecha));
    }

    public boolean removerDiagnosticoPorDescripcion(String descripcion){
        for (Diagnostico d : diagnosticos ){
            if(d.getDescripcion().equals(descripcion)){
                diagnosticos.remove(d);
                return true;
            }
        }
        return false;
    }

    public List getDiagnosticos(){
        List<Diagnostico> diagnosticosCopy = Collections.unmodifiableList(this.diagnosticos);
        return diagnosticosCopy;
    }
}
