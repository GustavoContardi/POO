package vista.flujos;

import controlador.Controlador;
import vista.ConsolaGrafica;

public class FlujoEleccion extends Flujo{
    private int opcion;
    private static int ptsSiNoQuiere = -1;

    enum EstadosPosibles {
        ENVIDO,
        ENVIDODOBLE,
        REAL_ENVIDO,
        FALTA_ENVIDO,
        TRUCO,
        RETRUCO,
        VALE_CUATRO,
    }
    private EstadosPosibles estadosActual;

    public FlujoEleccion(ConsolaGrafica vista, Controlador controlador, int opcion) {
        super(vista, controlador);
        this.opcion = opcion;
        setEstadosActual(opcion);
        if(ptsSiNoQuiere == -1) ptsSiNoQuiere = 1;
    }

    @Override
    public Flujo procesarEntrada(String string) {
        switch (estadosActual) {
            case ENVIDO -> {
                switch (string) {
                    case "1": {
                        controlador.calcularEnvido(2);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2" : {
                        controlador.envidoNoQuerido(1);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "3" : {
                        ptsSiNoQuiere+=1;
                        controlador.cantarTanto(2);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "4": {
                        ptsSiNoQuiere+=1;
                        controlador.cantarTanto(3);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "5":{
                        ptsSiNoQuiere+=1;
                        controlador.cantarTanto(4);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    default: {
                        vista.println("opcion invalida");
                    }
                }
            }
            case ENVIDODOBLE -> {
                switch (string) {
                    case "1" :{
                        controlador.calcularEnvido(4);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2":{
                        controlador.envidoNoQuerido(ptsSiNoQuiere);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "4": {
                        ptsSiNoQuiere+=2;
                        controlador.cantarTanto(3);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "5":{
                        ptsSiNoQuiere+=2;
                        controlador.cantarTanto(4);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    default: {
                        vista.println("opcion invalida");
                    }
                }
            }
            case REAL_ENVIDO -> {
                switch (string) {
                    case "1":{
                        controlador.calcularEnvido(3);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2": {
                        controlador.envidoNoQuerido(ptsSiNoQuiere);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "4": {
                        ptsSiNoQuiere+=3;
                        controlador.cantarTanto(3);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "5":{
                        ptsSiNoQuiere+=3;
                        controlador.cantarTanto(4);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    default: {
                        vista.println("opcion invalida");
                    }
                }
            }
            case FALTA_ENVIDO -> {

                switch (string) {
                    case "1": {
                        controlador.calcularEnvido(30);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2":{
                        controlador.envidoNoQuerido(ptsSiNoQuiere);
                        ptsSiNoQuiere = 1;
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    default: {
                        vista.println("opcion invalida");
                    }
                }
            }
            case TRUCO -> {
                ptsSiNoQuiere = 1;
                switch (string){
                    case "1" ->{
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2" ->{
                        // no quiere truco
                        controlador.envidoNoQuerido(1); // actualizo con envido pero es los mismo
                        controlador.cantoNoQuerido();
                        controlador.esFinDeMano();
                        controlador.nuevaMano();
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "3" ->{
                        controlador.cantarTruco(2);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                }
            }
            case RETRUCO -> {
                switch (string){
                    case "1" ->{
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2" ->{
                        // no quiere re truco
                        controlador.envidoNoQuerido(2); // actualizo con envido pero es los mismo
                        controlador.cantoNoQuerido();
                        controlador.esFinDeMano();
                        controlador.nuevaMano();
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "4" ->{
                        controlador.cantarTruco(3);
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                }
            }
            case VALE_CUATRO -> {
                switch (string){
                    case "1" ->{
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                    case "2" -> {
                        controlador.envidoNoQuerido(3); // actualizo con envido pero es los mismo
                        controlador.cantoNoQuerido();
                        controlador.esFinDeMano();
                        controlador.nuevaMano();
                        return new FlujoMostrarCartas(vista, controlador);
                    }
                }
            }
        }

        return this;
    }

    @Override
    public void mostrarSiguienteTexto() {
        switch (estadosActual){
            case ENVIDO       ->  vista.println("1- Quiero | 2- No quiero | 3- Envido | 4- Real Envido | 5- Falta Envido");
            case ENVIDODOBLE  ->  vista.println("1- Quiero | 2- No quiero | 4- Real Envido | 5- Falta Envido");
            case REAL_ENVIDO  ->  vista.println("1- Quiero | 2- No quiero | 5- Falta Envido");
            case FALTA_ENVIDO ->  vista.println("1- Quiero | 2- No quiero");

            case TRUCO        ->  vista.println("1- Quiero | 2- No Quiero | 3- Re Truco");
            case RETRUCO      ->  vista.println("1- Quiero | 2- No Quiero | 4- Vale Cuatro");
            case VALE_CUATRO  ->  vista.println("1- Quiero | 2- No Quiero");
        }

    }

    public void setEstadosActual(int estado) {
        if(estado == 1) estadosActual = EstadosPosibles.ENVIDO;
        else if(estado == 2) estadosActual = EstadosPosibles.ENVIDODOBLE;
        else if(estado == 3) estadosActual = EstadosPosibles.REAL_ENVIDO;
        else if(estado == 4) estadosActual = EstadosPosibles.FALTA_ENVIDO;
        // ---------------- \\
        if(estado == 6) estadosActual=EstadosPosibles.TRUCO;
        else if(estado == 7) estadosActual=EstadosPosibles.RETRUCO;
        else if(estado == 8) estadosActual=EstadosPosibles.VALE_CUATRO;
    }
}
