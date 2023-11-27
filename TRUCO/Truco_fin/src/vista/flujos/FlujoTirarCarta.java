package vista.flujos;

import controlador.Controlador;
import modelo.Carta;
import vista.ConsolaGrafica;

public class FlujoTirarCarta extends Flujo{
    public FlujoTirarCarta(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        switch (string){
            case("1") -> procesarCarta(string);
            case("2") -> procesarCarta(string);
            case("3") -> procesarCarta(string);
        }
        return new FlujoMostrarCartas(vista, controlador);
    }

    private Flujo procesarCarta(String string){
        Integer numero;
        if(!controlador.turnoActual().equals(controlador.getJ())) {
            vista.println("No es tu turno");
        }
        else {
            try {
                numero = Integer.parseInt(string);
                if (numero < 1 || numero > controlador.obtenerCartas().size()) {
                    vista.println("Ingrese un valor > 1 o < " + controlador.obtenerCartas().size());
                    return this;
                } else {
                    //vista.limpiarPantalla();
                    controlador.tirarCarta(numero);
                    controlador.cambiarTurno();
                }
            } catch (NumberFormatException e) {
                vista.println("Ingrese un número válido.");
            }
        }
        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {
        //vista.limpiarPantalla();
        vista.println("\nSeleccione una carta para tirar: ");
    }
}
