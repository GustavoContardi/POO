package vista.flujos;

import controlador.Controlador;
import vista.ConsolaGrafica;

public class FlujoMenuPrincipal extends Flujo{
    public FlujoMenuPrincipal(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        switch (string){
            case "1" -> {
                vista.limpiarPantalla();
                controlador.iniciarPartida();
                return new FlujoMostrarCartas(vista, controlador);
            }
            case "2" -> vista.println("Cargar jugador");
            case "5" -> vista.opSalir();
            default -> vista.println("Opción inválida!");
        }
        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {
        vista.println("MENU PRINCIPAL\n");
        vista.println("1. Jugar ");
        vista.println("2. Alta jugador nuevo");
        vista.println("5. Salir");
        vista.println("Seleccione una opción: ");
    }
}
