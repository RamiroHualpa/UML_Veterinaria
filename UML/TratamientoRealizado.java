/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hualp
 */
class TratamientoRealizado {
    private Tratamiento tratamiento;
    private List<Medicamento> medicamentos; //Agregación
    private LocalDate fecha;

    public TratamientoRealizado(Tratamiento tratamiento, LocalDate fecha) {
        this.tratamiento = tratamiento;
        this.medicamentos = new ArrayList<>();
        this.fecha = fecha;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarMedicamento(Medicamento medicamento){
        if(medicamento != null && !this.medicamentos.contains(medicamento)){
            this.medicamentos.add(medicamento);
        }
    }

    public boolean removerMedicamento(Medicamento medicamento){
        if(this.medicamentos.contains(medicamento)){
            this.medicamentos.remove(medicamento);
            return true;
        }
        return false;
    }

    public List getMedicamentos(){
        List<Medicamento> medicamentosCopy = Collections.unmodifiableList(medicamentos);
        return medicamentosCopy;
    }
}
