package vista.flujos;

import controlador.Controlador;
import vista.ConsolaGrafica;

public class FlujoEnvido extends Flujo{

    public FlujoEnvido(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        if(!(controlador.turnoActual().equals(controlador.getJ()))) vista.println("no es tu turno");
        else {
            switch (string) {
                case "1" : {
                    controlador.cantarTanto(1);
                    controlador.seCantoEnvido();
                    return new FlujoMostrarCartas(vista, controlador);
                }
                case "2": {
                    controlador.cantarTanto(3);
                    controlador.seCantoEnvido();
                    return new FlujoMostrarCartas(vista, controlador);
                }
                case "3": {
                    controlador.cantarTanto(4);
                    controlador.seCantoEnvido();
                    return new FlujoMostrarCartas(vista, controlador);
                }
                case "4": {
                    return new FlujoMostrarCartas(vista, controlador);
                }
            }
        }
        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {
        vista.println("\n1- Envido | 2- Real Envido | 3- Falta Envido | 4- Volver");
    }
}
