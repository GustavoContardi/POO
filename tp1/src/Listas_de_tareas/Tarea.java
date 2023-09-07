package Listas_de_tareas;

import java.time.LocalDate;

public class Tarea {
    // aca genero los atributos de una tarea
    private Boolean Estado;
    private String Prioridad;
    private String Descripcion;
    private LocalDate fecha_vto;
    private String recordatorio = "";
    private String colaborador;

    public void setEstado(int estado){
        if(estado == 1) this.Estado = false;
        else if(estado == 2) this.Estado = true;
    }
    public Boolean getEstado(){
        return Estado;
    }
    public void setPrioridad(String prioridad){
        this.Prioridad = prioridad;
    }
    public String getPrioridad(){
        return Prioridad;
    }
    public void setDescripcion(String descripcion){
        this.Descripcion = descripcion;
    }
    public String getDescripcion(){
        return Descripcion;
    }
    public void setFecha_vto(LocalDate fecha){
        this.fecha_vto = fecha;
    }
    public LocalDate getFecha_vto() {
        return fecha_vto;
    }
    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }
    public String getRecordatorio() {
        return recordatorio;
    }
    public void mostrarDesc(){
        System.out.println(getDescripcion());
    }
    public void completar_tarea(){
        setEstado(1);
        //System.out.println("¡Tarea completada!");
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getColaborador() {
        return colaborador;
    }
}
