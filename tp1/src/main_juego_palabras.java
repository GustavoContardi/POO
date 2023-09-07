import Juegos_palabras.Diccionario;
import Juegos_palabras.Jugador;

public class main_juego_palabras {
    public static void main(String[] arg){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.setNombre("Gustavo");
        jugador2.setNombre("Pepe");

        jugador1.ver_diccionario();
        System.out.println();
        jugador1.agregar_palabras_dic();
        jugador1.ver_diccionario();
        jugador1.formar_palabras();
        System.out.printf("El jugador '%s', hizo: %d puntos.\n", jugador1.getNombre(), jugador1.getPuntaje());

        System.out.println("\n---------------------------\n");

        jugador2.ver_diccionario();
        System.out.println();
        jugador2.agregar_palabras_dic();
        jugador2.ver_diccionario();
        jugador2.formar_palabras();
        System.out.printf("El jugador '%s', hizo: %d puntos.\n", jugador2.getNombre(), jugador2.getPuntaje());

        System.out.println("\n\t-- JUEGO FINALIZADO --\n");
        if(jugador2.getPuntaje() > jugador1.getPuntaje()){
            System.out.println("¡¡¡EL GANADOR ES: " + jugador2.getNombre()+ "!!!");
        }
        else if (jugador2.getPuntaje() < jugador1.getPuntaje()){
            System.out.println("¡¡¡EL GANADOR ES: " + jugador2.getNombre() + "!!!");
        }
        else System.out.println("¡¡¡EMPATE TECNICO!!!");
    }
}
