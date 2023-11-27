package controlador;

import modelo.Anotador;
import modelo.Carta;
import modelo.Jugador;
import modelo.Partida;
import observer.Observer;
import vista.ConsolaGrafica;
import vista.flujos.FlujoEleccion;
import vista.flujos.FlujoMostrarCartas;

import java.util.ArrayList;

public class Controlador implements Observer {

    private Partida modelo;
    private ConsolaGrafica vista;
    private Jugador j; // debe conocer al jugador para saber a quien controla, igualmente lo conoce por el modelo

    public Controlador(Jugador j, ConsolaGrafica vista, Partida modelo) {
        this.vista = vista;
        this.j = j;
        this.modelo = modelo;
        //modelo.agregarObservador(this);
    }


    public ArrayList<Carta> obtenerCartas(){
        return j.ObtenerCartasRepartidas();
    }
    public void tirarCarta(int opcion){
        modelo.tirarCartaJ(j, opcion);
    }

    public void iniciarPartida(){
        modelo.nuevaMano();
        vista.seActualizaronPuntos(modelo.iniciarPuntaje());
    }

    public void calcularEnvido(int puntos) {
        if (puntos > 1) {
            ArrayList<Object> envido = modelo.calcularEnvido(puntos);
            Jugador jug = (Jugador) envido.get(0);
            int ptsGanados = (Integer) envido.get(1);
            enviarMensaje("GANO " + jug.getNombre() + " con " + ptsGanados + " tantos.\n");
        }
    }
    public void envidoNoQuerido(int puntos){
        modelo.calcularEnvido(j, puntos);
    }

    public void repartirCartas(){
        modelo.repartirCartas();
    }

    public void iniciarAlta(String nombre){
        modelo.agregarJugador(new Jugador(nombre));
    }

    public int estadoTrucos(){
        if(!modelo.isSeCantoTruco()) return 1;                                              // 1 = truco
        else if(modelo.isSeCantoTruco() && !modelo.isSeCantoReTruco()) return 2;            // 2 = retruco
        else if(modelo.isSeCantoValeCuatro() && modelo.isSeCantoValeCuatro()) return 3;     // 3 = vale cuatro
        else return 4;                                                                      // 4 no puede cantar nada
    }
    public void cantoNoQuerido(){
        modelo.enviarMensaje(j, "NO QUIERO");
    }

    public boolean estadoEnvido(){
        return modelo.isSeCantoEnvido();
    }
    public void cambiarTurno(){
        modelo.siguienteTurno();
    }
    public Jugador turnoActual(){
        return modelo.turnoActual();
    }
    public String cantoTruco(){
        return j.getNombre();
    }
    public String cantoReTruco(){
        return j.getNombre();
    }


    public void esFinDeMano(){
        modelo.setFinMano(true);
    }
    public void nuevaMano(){
        modelo.nuevaMano();
    }

    // ---- SETS Y GETS ---- \\

    public void cantaronEnvido(){
        modelo.setSeCantoEnvido(true);
    }
    public void cantaronTruco(){
        modelo.setSeCantoTruco(true);
    }
    public void cantaronReTruco(){
        modelo.setSeCantoReTruco(true);
    }
    public void cantaronValeCuatro(){
        modelo.setSeCantoValeCuatro(true);
    }

    public void cantarTanto(int opcion){
        modelo.cantarTanto(j, opcion);
    }
    public void cantarTruco(int opcion){
        modelo.cantarTruco(j, opcion);
    }

    public void enviarMensaje(String msj){
        modelo.enviarMensaje(j, msj);
    }


    // ---------------------------------------------- \\

    public void setVista(ConsolaGrafica vista) {
        this.vista = vista;
    }

    public Jugador getJ() {
        return j;
    }

    public String getNameJug(){
        return j.getNombre();
    }

    public void seCantoEnvido(){
        modelo.setSeCantoEnvido(true);
    }
    public void seCantoTruco(Jugador j){
        modelo.setCantoTruco(j.getNombre());
    }
    public void seCantoReTruco(Jugador j){
        modelo.setCantoReTruco(j.getNombre());
    }

    // ---- OBSERVER ---- \\

    @Override
    public void actualizar() {

    }

    @Override
    public void actualizarFinMano() {
        vista.println("\n------------------\nFIN DE LA MANO\n------------------\n");
        vista.setFlujoActual(new FlujoMostrarCartas(vista, this));
    }

    @Override
    public void actualizarCartaTirada(Carta c) {
        vista.println(j.getNombre() + " tiro: " + c.toString());
    }


    @Override
    public void enviarMensaje(Jugador j, String mensaje) {
        vista.println(j.getNombre() + ": " + mensaje);
    }

    @Override
    public void notificarTruco(Jugador j, String msj) {
        if(!this.j.equals(j)){
            vista.println(j.getNombre() + ": " + msj);
            if(msj.equals("Estamos jugando al TRUCO no?")) vista.setFlujoActual(new FlujoEleccion(vista, this, 6));
            else if(msj.equals("RE TRUCO!")) vista.setFlujoActual(new FlujoEleccion(vista, this, 7));
            else if(msj.equals("Con cartas en mano, el as bajo mi manga, VALE CUATRO, en el truco mando")) vista.setFlujoActual(new FlujoEleccion(vista, this, 8));
        }
    }

    @Override
    public void notificarTanto(Jugador j, String msj) {
        if(!this.j.equals(j)) {
            vista.println(j.getNombre() + ": " + msj);
            if(msj.equals("ENVIDO!")) vista.setFlujoActual(new FlujoEleccion(vista, this, 1));
            else if(msj.equals("ENVIDO dijiste?")) vista.setFlujoActual(new FlujoEleccion(vista, this, 2));
            else if(msj.equals("REAL ENVIDO!")) vista.setFlujoActual(new FlujoEleccion(vista, this, 3));
            else if(msj.equals("Tiro la casa por la ventana... FALTA ENVIDO!")) {
                vista.setFlujoActual(new FlujoEleccion(vista, this, 4));
            }
        }
    }

    @Override
    public void actualizarPuntos(Anotador anotador) {
        vista.seActualizaronPuntos(anotador.toString());
    }


}
