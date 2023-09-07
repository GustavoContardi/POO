import Listas_java.Lista_enlazada;
import Listas_java.cNodo;

import java.util.Scanner;

public class main_listas {
    public static void main(String[] args){
        System.out.println("Hello and welcome! \n\n");

        cNodo nodo1 = new cNodo();
        nodo1.setDato("Hola");

        System.out.print(nodo1.getDato());

        cNodo nodo2 = new cNodo();
        nodo1.setProximo(nodo2);
        nodo2.setDato(" mundo\n\n");
        System.out.print(nodo2.getDato());
        int numero;

        // -------------------------------------------------------------------- //

        Lista_enlazada lista = new Lista_enlazada();

        if(lista.l_es_vacia()){
            System.out.println("Lista vacia!!");
        }
        else{
            System.out.println("No esta vacia");
        }

        for (int i=1; i<=10;i++){
            lista.agregar(i);
        }

        System.out.println(lista.l_mostrar());
        Lista_enlazada l_pares = new Lista_enlazada();
        l_pares = lista.buscar_pares();
        System.out.println("\n return lista con pares: \n");
        System.out.println(lista.buscar_pares().l_mostrar());



        Scanner nombre = new Scanner(System.in);
        System.out.print("\nIngrese el numero que quiere eliminar: ");
        numero = nombre.nextInt();


        if(lista.l_borrar_dato(numero)){
            System.out.println("Se elimino correctamente.");
        }
        else{
            System.out.println("No se pudo eliminar, no se encontro o la lista es vacia.");
        }

        System.out.println(lista.l_mostrar());

        System.out.println("La cantidad de elementos es: " + lista.l_longitud());

        cNodo insertar = new cNodo();
        insertar.setDato(10);

        lista.l_insertar(3, "hola");
        System.out.println("La lista quedó asi: " + lista.l_mostrar());


        System.out.println("\nAhora voy a buscar un numero en la lista");
        Scanner nro = new Scanner(System.in);
        if(lista.l_buscar("hola")){
            System.out.println("Esta en la lista");
        }
        else {
            System.out.println("pincho");
        }
    }

}
