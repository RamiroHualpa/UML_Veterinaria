/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SegundoParcialPruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hualp
 */
class Turno {
    private LocalDate fecha;
    private Animal animal; //Asociación
    private Veterinario veterinario; //Asociación
    private List<TratamientoRealizado> tratamientosRealizados; //Composición

    public Turno(LocalDate fecha) {
        this.fecha = fecha;
        this.tratamientosRealizados = new ArrayList<>();
    }

    public void agregarTratamiento(Tratamiento tratamiento, LocalDate fecha){
        this.tratamientosRealizados.add(new TratamientoRealizado(tratamiento,fecha));
    }

    public boolean removerTratamiento(Tratamiento tratamiento,LocalDate fecha){
        TratamientoRealizado encontrado = null;

        for (TratamientoRealizado tr : tratamientosRealizados) {
            if (tr.getTratamiento() == tratamiento && tr.getFecha().equals(fecha)) {
                encontrado = tr;
                break; // lo encontramos, no seguimos
            }
        }

        if (encontrado != null) {
            tratamientosRealizados.remove(encontrado);
            return true;
        }
        return false;

        /*MÉTODO CORTO
        return tratamientosRealizados.removeIf(tr ->
        tr.getTratamiento() == tratamiento && tr.getFecha().equals(fecha)
        );
        * */
    }

    //Método solicitado en el ejercicio, se utiliza el pricipio tell don't ask para agregar medicamentos a TratamientoRealizado
    public void registrarTratamiento(Tratamiento tratamiento, LocalDate fecha, List<Medicamento> meds){
        TratamientoRealizado tr = new TratamientoRealizado(tratamiento,fecha);
        for (Medicamento m : meds){
            tr.agregarMedicamento(m);
        }
        this.tratamientosRealizados.add(tr);
    }

    public void diagnosticar(String descripcion){
        if(this.animal != null && this.animal.getFichaMedica() != null && this.animal.getFichaMedica().getDiagnosticos() != null){
            //En este punto se puede agregar la fecha actual, consideré mejor idea usar la misma del turno.
            this.animal.getFichaMedica().agregarDiagnostico(descripcion, this.fecha);
        }
    }
}
