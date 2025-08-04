/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hualp
 */
class FichaMedica {
    private List<Diagnostico> diagnosticos; //Composición

    public FichaMedica(List<Diagnostico> diagnosticos) {
        this.diagnosticos = new ArrayList<>(diagnosticos);
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    @Override
    public String toString() {
        return "FichaMedica{" + "diagnosticos=" + diagnosticos + '}';
    }
    
    
    
    
}
