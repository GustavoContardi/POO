import Colas.cola;

public class main_colas {
    public static void main(String[] args){

        cola c = new cola();

        if (c.c_es_vacia()){
            System.out.println("Lista vacia!!");
        }

        for(int i=1; i<=10; i++){
            c.c_encolar(i);
        }

        System.out.println("Cargamos la cola del 1al10 de prepo: " + c.c_mostrar());

        System.out.println("La longitud de la cola es: " + c.c_longitud());

        System.out.println("Borramos el 5 de prepo");
        c.c_borrar(5);
        System.out.println("Asi quedo la cola: " + c.c_mostrar());
    }
}
