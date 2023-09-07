package Listas_de_tareas;


import Listas_java.Lista_enlazada;
import Listas_java.cNodo;

import java.time.LocalDate;
import java.util.Scanner;

public class lista_tareas {
    // aca genero todos los metodos que hace tareas
    private Tarea nueva_tarea = new Tarea();
    private Lista_enlazada lista = new Lista_enlazada();
   // private Lista_enlazada listaOrdenada = new Lista_enlazada();
    private Lista_enlazada lista2 = new Lista_enlazada();

    public void agregar_tarea(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantas tareas quiere ingresar a la lista: ");
        int op = scanner.nextInt();
        scanner.nextLine(); // Consume el carácter de nueva línea después del número
        int i = 1, estado;
        while (i <= op) {
            System.out.println("Tarea: " + i);
            nueva_tarea = new Tarea();

            System.out.print("Ingrese la descripcion: ");
            String desc = scanner.nextLine();
            System.out.print("Ingrese la prioridad: ");
            String priori = scanner.nextLine();
            System.out.print("Ingrese la fecha de vencimiento (yyyy-MM-dd): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());
            System.out.print("Ingrese el estado(completa 2, incompleta 1): ");
            estado = scanner.nextInt();
            scanner.nextLine();

            nueva_tarea.setDescripcion(desc);
            nueva_tarea.setPrioridad(priori);
            nueva_tarea.setFecha_vto(fecha);
            nueva_tarea.setEstado(estado);

            lista.agregar(nueva_tarea);
            i++;
        }
    }

    public void completar_tarea(String nombre_tarea){
        if (!lista.l_es_vacia()) {
            cNodo nodo = (cNodo) lista.l_recuperar();

            while (nodo != null) {
                nueva_tarea = (Tarea) nodo.getDato();
                if((nueva_tarea.getDescripcion()).equals(nombre_tarea)){
                    if(!nueva_tarea.getEstado()){
                        nueva_tarea.setEstado(2);
                    }
                }
                else System.out.println("No se encontro la Tarea, intente respetar todos los caracteres");
                nodo = nodo.getProximo();
                //
            }
        }
    }

    public void mostrar_lista(){
        if (!lista.l_es_vacia()){

            cNodo nodo = (cNodo) lista.l_recuperar();

            while( nodo != null){
                nueva_tarea = (Tarea) nodo.getDato();
                //
                LocalDate fecha = nueva_tarea.getFecha_vto();
                LocalDate fecha_actual = LocalDate.now(); // fecha actual

                if((fecha_actual.isAfter(fecha) || fecha_actual.equals(fecha)) && !nueva_tarea.getEstado()){
                    nueva_tarea.setRecordatorio("(Por vencer)");
                }
                if(fecha_actual.equals(fecha) || fecha_actual.plusDays(1) == nueva_tarea.getFecha_vto()) {
                    nueva_tarea.setPrioridad("Alta");
                }

                System.out.println("La tarea a realizar es: " + nueva_tarea.getDescripcion());
                System.out.println("Fecha vencimiento: " + nueva_tarea.getFecha_vto());
                System.out.println("Es de prioridad: " + nueva_tarea.getPrioridad());
                if(fecha.isBefore(fecha_actual) && nueva_tarea.getEstado()){
                    System.out.println("Vencida (Completa)");
                }
                else if (fecha.isBefore(fecha_actual) && !nueva_tarea.getEstado()){
                    System.out.println("Vencida (Incompleta)");
                }

                if(nueva_tarea.getEstado()){
                    System.out.println("Tarea Completada");
                    if(nueva_tarea.getColaborador() != null) {
                        System.out.println("La completó: " + nueva_tarea.getColaborador() + " en la fecha: " + fecha_actual);
                    }
                }

                if (nueva_tarea.getRecordatorio() != ""){
                    System.out.println("RECORDATORIO: " + nueva_tarea.getRecordatorio());
                }
                nodo = nodo.getProximo();


                System.out.println("\n----------------------");
            }
        }
        else System.out.println("Todavia no hay tareas en la lista!");
    }


    public Lista_enlazada getLista(){
        return lista;
    }

}
