import Pilas.pila;

import java.time.LocalDate;

public class main_pilas {
    public static void main(String[] args){

        pila p = new pila();
        //p = p.p_apilar(5);

        if(p.p_es_vacia()){
            System.out.println("Pila vacia!");
        }

        System.out.println("Metemos de prepo el for 1 a 10");
        for(int i=1; i<=10; i++){
            p.p_apilar(i);
        }
        System.out.println(p.p_mostrar());
        System.out.println("La longitud de la pila es: " + p.p_longitud());
        System.out.println("Muestro que no perdi la pila: " + p.p_mostrar());

        LocalDate fecha_actual = LocalDate.now();
        System.out.println("la fecha actual es: " + fecha_actual);
    }
}
