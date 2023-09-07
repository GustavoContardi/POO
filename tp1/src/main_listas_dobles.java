import Listas_dobles.Nodo_doble;
import Listas_dobles.lista_doble_enlazo;

public class main_listas_dobles {
    public static void main(String[] args){

        System.out.println("Hello and welcome! \n\n");
        Nodo_doble nodo1 = new Nodo_doble();
        nodo1.setDato("Hola");

        lista_doble_enlazo lista_doble = new lista_doble_enlazo();

        lista_doble.ld_insertar(123, 123);
        System.out.println(lista_doble.ld_mostrar() + "\n" + lista_doble.ld_longitud());

        System.out.println("Vamos a ingresar un for del 1 al 10 para probar");
        for(int i=1; i<=10; i++){
            lista_doble.ld_agregar(i);
        }
        System.out.println(lista_doble.ld_mostrar());
        System.out.println("Longitud dela lista: " + lista_doble.ld_longitud());
        System.out.println("Vamos a borrar un nro para ver si funciona");
        if(lista_doble.ld_borrar(9)){
            System.out.print("Se pudo eliminar el dato, la lista quedo asi: " + lista_doble.ld_mostrar() + "\n");
        }
        System.out.println("Te restauro el eliminado porque lo inserte");
        lista_doble.ld_insertar(9,9);
        System.out.println(lista_doble.ld_mostrar());
    }
}
