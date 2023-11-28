package vista.flujos;

import controlador.Controlador;
import vista.ConsolaGrafica;

public class FlujoFinPartida extends Flujo{

    public FlujoFinPartida(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {

    }
}
