package vista.flujos;

import controlador.Controlador;
import vista.ConsolaGrafica;

public class FlujoMostrarCartas extends Flujo{

    public FlujoMostrarCartas(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        if(!controlador.turnoActual().equals(controlador.getJ())) vista.println("no es tu turno");
        else {
            switch (string) {

                case "1" -> {
                    if(controlador.estadoEnvido()) vista.println("No puedes cantar 'Envido' ahora.");
                    else{
                        return new FlujoEnvido(vista, controlador);
                    }
                }
                case "2" ->{
                    if(controlador.getJ().getNombre().equals(controlador.quienCantoTruco()) || controlador.getJ().getNombre().equals(controlador.quienCantoReTruco())){
                        vista.println("El canto lo tiene tu oponente.");
                    }
                    else controlador.cantarTruco(1);
                }
                case "3" -> {
                    return new FlujoTirarCarta(vista, controlador);
                }
                case "4" -> {
                    controlador.meVoyAlMazo(controlador.getJ());
                    controlador.esFinDeMano();
                }
            }
        }
        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {
        if (controlador.estadoEnvido()) vista.println(" \n-----------------\n");
        vista.println("Cartas de: " + controlador.getNameJug() + "\n");
        vista.mostrarCartas();
        vista.mostrarOpciones();
    }
}
