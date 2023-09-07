package Listas_de_tareas;

import Listas_java.cNodo;
import Listas_java.Lista_enlazada;

import java.util.Scanner;

public class Colaborador {
    private String nombre;
    private Tarea nueva_tarea = new Tarea();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void realizar_tarea(Lista_enlazada lista){
        if (!lista.l_es_vacia()){
            cNodo nodo = (cNodo) lista.l_recuperar();
            System.out.print("Ingrese la tarea que quiere realizar: ");
            Scanner scanner = new Scanner(System.in);
            String tarea = scanner.nextLine();
            
            while (nodo != null) {
                nueva_tarea = (Tarea) nodo.getDato();
                if((nueva_tarea.getDescripcion()).equals(tarea)){
                    if(!nueva_tarea.getEstado()){
                        nueva_tarea.setEstado(2);
                    }
                }
                nodo = nodo.getProximo();
                //
            }
        }
        nueva_tarea.setColaborador(getNombre());
    }

}
