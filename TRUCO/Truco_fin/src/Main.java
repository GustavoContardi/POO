import controlador.Controlador;
import modelo.Envido;
import modelo.Jugador;
import modelo.Partida;
import vista.ConsolaGrafica;
import vista.inicioConsola;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        Jugador j1 = new Jugador("Liti");
        Jugador j2 = new Jugador("Messi");
        Partida partida = new Partida(j1, j2);

        ConsolaGrafica consolaJ1 = new ConsolaGrafica();
        ConsolaGrafica consolaJ2 = new ConsolaGrafica();

        Controlador controladorJ1 = new Controlador(j1, consolaJ1, partida);
        Controlador controladorJ2 = new Controlador(j2, consolaJ2, partida);

        partida.agregarObservador(controladorJ1);
        partida.agregarObservador(controladorJ2);

        consolaJ1.setControlador(controladorJ1);
        consolaJ2.setControlador(controladorJ2);

        consolaJ1.mostrarMenuPrincipal();
        consolaJ2.mostrarMenuPrincipal();
        */
        inicioConsola inicio = new inicioConsola();
        inicio.iniciar();
    }
}