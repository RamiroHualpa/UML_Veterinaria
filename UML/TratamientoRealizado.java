/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hualp
 */
class TratamientoRealizado {
    private Tratamiento tratamiento;
    private List<Medicamento> medicamentos; //Agregación
    private LocalDate fecha;

    public TratamientoRealizado(Tratamiento tratamiento, List<Medicamento> medicamentos, LocalDate fecha) {
        this.tratamiento = tratamiento;
        this.medicamentos = medicamentos;
        this.fecha = fecha;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TratamientoRealizado{" + "tratamiento=" + tratamiento + ", medicamentos=" + medicamentos + ", fecha=" + fecha + '}';
    }
    
    
}
