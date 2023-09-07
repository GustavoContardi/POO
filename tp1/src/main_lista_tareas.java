import Listas_de_tareas.Colaborador;
import Listas_de_tareas.lista_tareas;
import Listas_java.Lista_enlazada;

import java.util.Scanner;

public class main_lista_tareas {
    public static void main(String[] arg){
        lista_tareas lista1 = new lista_tareas();
        Scanner scanner = new Scanner(System.in);

        Colaborador colab = new Colaborador();
        colab.setNombre("Gustavo");

        lista1.agregar_tarea();
        lista1.mostrar_lista();
        colab.realizar_tarea(lista1.getLista());
        lista1.mostrar_lista();

        System.out.println("Lista ordenada por prioridad: ");
        //(lista1.l_ordenada()).l_mostrar();
    }
}
