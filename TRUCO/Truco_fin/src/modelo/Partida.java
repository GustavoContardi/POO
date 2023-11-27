package modelo;

import observer.ObjetoObservable;
import observer.Observer;

import java.util.ArrayList;

public class Partida implements ObjetoObservable {
    private boolean seCantoEnvido, seCantoTruco, seCantoReTruco, seCantoValeCuatro;
    private Jugador j1, j2, turno, turnoCanto;
    private String cantoTruco, cantoReTruco;
    private Mazo mazo;
    private Anotador anotador;
    private int puntajeJ1; // estos puntajes son para el envido
    private int puntajeJ2; // estos puntajes son para el envido
    private int puntajeTruco; // puntaje para el truco, que se actualiza cuando termina la mano porque ahi es donde se sabe para quienes son los pts
    private boolean finMano, finPartida;
    private int nroMano, nroRonda, nroManoGanadaJ1, nroManoGanadaJ2;

    private ArrayList<Carta> cartasRonda1 = new ArrayList<>();
    private ArrayList<Carta> cartasRonda2 = new ArrayList<>();
    private ArrayList<Carta> cartasRonda3 = new ArrayList<>();
    private ArrayList<Observer> observadores = new ArrayList<>();
    private Envido envido;

// ----------------------------------------------------- \\

    public Partida(Jugador j1, Jugador j2) {
        this.j1 = j1;
        this.j2 = j2;

        cantoTruco="";
        cantoReTruco="";
        mazo = new Mazo();          //
        finMano=false;
        finPartida=false;
        seCantoEnvido=false;
        seCantoTruco=false;         // inicializo los valores de la partida y mano
        seCantoReTruco=false;
        seCantoValeCuatro=false;
        puntajeJ1=0;
        puntajeJ2=0;                //
        puntajeTruco=1;
        anotador = new Anotador(j2, j1);
        nroRonda=1;
        nroMano=0;
        nroManoGanadaJ1=0;
        nroManoGanadaJ2=0;

        // seteo el turno inicial
        turno = j1;
        turnoCanto = j1;
        mazo.repartirCartas(j1, j2);

        cartasRonda1.add(null);
        cartasRonda1.add(null);
        cartasRonda2.add(null);
        cartasRonda2.add(null);
        cartasRonda3.add(null);
        cartasRonda3.add(null);

        envido = new Envido();


    }
    public Jugador compararCartas(Carta cj1, Carta cj2){ // cj1 = cartaJugador1
        if(cj1.getPoder() > cj2.getPoder()) {
            return j1;
        }
        else if (cj1.getPoder() < cj2.getPoder()) {
            if(nroManoGanadaJ2 > 1) setFinMano(true);
            return j2;
        }
        else return null;
    }

    public void repartirCartas(){
        mazo.repartirCartas(j1, j2);
    }

    public void sumarPuntos(Jugador j, int cantidad){
        if(j.equals(j1)){
            anotador.sumarJ1(cantidad);
        }
        else if(j.equals(j2)){
            anotador.sumarJ2(cantidad);
        }
        notificarPuntos(anotador);
    }

    public void nuevaMano(){
        if(finMano){
            j1.devolverCartas();
            j2.devolverCartas();

            // actualizo los envidos

            // actualizo los trucos
            if(nroManoGanadaJ1 > nroManoGanadaJ2){
                sumarPuntos(j1, puntajeTruco);
            }
            else if(nroManoGanadaJ1 < nroManoGanadaJ2){
                sumarPuntos(j2, puntajeTruco);
            }

            nroMano++;
            puntajeTruco=1;
            puntajeJ2=0;
            puntajeJ1=0;
            //finMano=false;
            seCantoEnvido=false;
            seCantoTruco=false;         // reinicio los valores para la mano nueva
            seCantoReTruco=false;
            seCantoValeCuatro=false;
            cantoReTruco="";
            cantoTruco="";
            nroRonda=1;
            nroManoGanadaJ1=0;
            nroManoGanadaJ2=0;
            if(nroMano%2 == 0) {
                turno = j1;
                turnoCanto = j1;
            }
            else {
                turnoCanto = j2;
                turno = j2;
            }
            cartasRonda1.clear();
            cartasRonda3.clear();
            cartasRonda2.clear();

            cartasRonda1.add(null);
            cartasRonda1.add(null);
            cartasRonda2.add(null);
            cartasRonda2.add(null);
            cartasRonda3.add(null);
            cartasRonda3.add(null);

            repartirCartas();

            notificarFinMano();
            finMano=false;
        }

        // ACTUALIZAR CON OBSERVER
    }

    public String iniciarPuntaje(){
        return "PUNTAJES:   " + j1.getNombre() + ": " + 0 + "  ||  " + j2.getNombre() + ": " + 0 ;
    }

    public Carta tirarCartaJ(Jugador j, int opcion){
        Carta c = null;

        if(j.equals(j1)){
            c = j1.tirarCarta(opcion);
            if(nroRonda == 1) cartasRonda1.add(0, c);
            else if(nroRonda == 2) cartasRonda2.add(0, c);
            else if(nroRonda == 3) cartasRonda3.add(0, c);
        }
        else if(j.equals(j2)){
            c = j2.tirarCarta(opcion);
            if(nroRonda == 1) cartasRonda1.add(1, c);
            else if(nroRonda == 2) cartasRonda2.add(1, c);
            else if(nroRonda == 3) cartasRonda3.add(1, c);
        }

        notificarCartaTirada(c);
        return c;

    }

    public void finDeLaPartida(){
        if((anotador.getPuntajeJ1() >= 30) || (anotador.getPuntajeJ2() >= 30)){
            // notificar por observer que se termino la mano y no dejar nada mas para hacer...
        }
    }

    public void siguienteTurno(){
        if(turno.equals(j1)){
            turno = j2;
        }
        else if(turno.equals(j2)) turno = j1;
    }

    public Jugador turnoActual(){
        return turno;
    }
    public Jugador turnoCantoActual(){
        return turnoCanto;
    }
    public void sigTurnoCanto(){
        if(turno.equals(j1)){
            turnoCanto = j2;
        }
        else if(turno.equals(j2)) turnoCanto = j1;
    }
    public void agregarJugador(Jugador j){
        j1.agregarJugador(j); // no pasa nada que sea j1 el que llama pq es static el metodo agregar
    }

    public ArrayList<Object> calcularEnvido(int puntos){
        ArrayList<Object> result = new ArrayList<>();
        if(envido.puntajeEnvido(j1) > envido.puntajeEnvido(j2)){
            puntajeJ1 = puntos;
            result.add(j1);
            result.add(envido.puntajeEnvido(j1));
            anotador.sumarJ1(puntos);
        }
        else if (envido.puntajeEnvido(j1) < envido.puntajeEnvido(j2)){
            puntajeJ2 = puntos;
            result.add(j2);
            result.add(envido.puntajeEnvido(j2));
            anotador.sumarJ2(puntos);
        }
        else if(envido.puntajeEnvido(j1) == envido.puntajeEnvido(j2)){
            if(nroMano%2 == 0){
                result.add(j1);
                result.add(envido.puntajeEnvido(j1));
                puntajeJ1 = puntos;
                anotador.sumarJ1(puntos);
            }
            else{
                result.add(j2);
                result.add(envido.puntajeEnvido(j2));
                puntajeJ2 = puntos;
                anotador.sumarJ2(puntos);
            }
        }
        notificarPuntos(anotador);
        return result;
    }
    public void calcularEnvido(Jugador j, int puntos){  // sobre cargo el metodo para cuando un jugador dice que no.
                                                        // Le paso el jugador que dice que no, entonces le sumo al otro lo que acumulo.
        if(!j.equals(j1)) {
            anotador.sumarJ1(puntos);
        }
        else if(!j.equals(j2)) anotador.sumarJ2(puntos);
        notificarPuntos(anotador);
        }

    public void cantarTanto(Jugador j, int tanto){ // el jugador que lo canta
        String mensaje = "";
        if(j.equals(j1)){
                 if(tanto == 1) mensaje = "ENVIDO!";
            else if(tanto == 2) mensaje = "ENVIDO dijiste?";
            else if(tanto == 3) mensaje = "REAL ENVIDO!";
            else if(tanto == 4) mensaje = "Tiro la casa por la ventana... FALTA ENVIDO!";

            notificarCantoTanto(j1, mensaje);
        }
        else if(j.equals(j2)){
                 if(tanto == 1) mensaje = "ENVIDO!";
            else if(tanto == 2) mensaje = "ENVIDO dijiste?";
            else if(tanto == 3) mensaje = "REAL ENVIDO!";
            else if(tanto == 4) mensaje = "Tiro la casa por la ventana... FALTA ENVIDO!";

            notificarCantoTanto(j2, mensaje);
        }
    }

    public void cantarTruco(Jugador j, int msj){ //el jugador que lo canta
        String mensaje = "";
        if(j.equals(j1)){
            if(msj == 1) {
                mensaje = "Estamos jugando al TRUCO no?";
                setSeCantoTruco(true);
                setCantoTruco(j1.getNombre());
            }
            else if (msj == 2){
                mensaje = "RE TRUCO!";
                setSeCantoReTruco(true);
                setCantoReTruco(j1.getNombre());
            }
            else if(msj==3){
                mensaje = "Con cartas en mano, el as bajo mi manga, VALE CUATRO, en el truco mando";
                setSeCantoValeCuatro(true);
            }
            notificarCantoTruco(j1, mensaje);
        }
        else if(j.equals(j2)){
            if(msj == 1) {
                mensaje = "Estamos jugando al TRUCO no?";
                setSeCantoTruco(true);
                setCantoTruco(j2.getNombre());
            }
            else if (msj == 2){
                mensaje = "RE TRUCO!";
                setSeCantoReTruco(true);
                setCantoReTruco(j2.getNombre());
            }
            else if(msj == 3){
                mensaje = "Con cartas en mano, el as bajo mi manga, VALE CUATRO, en el truco mando";
                setSeCantoValeCuatro(true);
            }
            notificarCantoTruco(j2, mensaje);
        }

    }

    public void enviarMensaje(Jugador j, String msj){
        if(j.equals(j1)) notificarMensaje(j, msj);
        else if(j.equals(j2)) notificarMensaje(j, msj);
    }

    // ----- Getters y Setters ----- \\
    public boolean isSeCantoEnvido() {
        return seCantoEnvido;
    }

    public void setSeCantoEnvido(boolean seCantoEnvido) {
        this.seCantoEnvido = seCantoEnvido;
    }

    public boolean isSeCantoTruco() {
        return seCantoTruco;
    }

    public void setSeCantoTruco(boolean seCantoTruco) {
        puntajeTruco=2;
        this.seCantoTruco = seCantoTruco;
    }

    public boolean isSeCantoReTruco() {
        return seCantoReTruco;
    }

    public void setSeCantoReTruco(boolean seCantoReTruco) {
        puntajeTruco=3;
        this.seCantoReTruco = seCantoReTruco;
    }

    public boolean isSeCantoValeCuatro() {
        return seCantoValeCuatro;
    }

    public void setSeCantoValeCuatro(boolean seCantoValeCuatro) {
        puntajeTruco=4;
        this.seCantoValeCuatro = seCantoValeCuatro;
    }

    public String getCantoTruco() {
        return cantoTruco;
    }

    public void setCantoTruco(String cantoTruco) { // que jugador lo canto
        this.cantoTruco = cantoTruco;
    }

    public String getCantoReTruco() {
        return cantoReTruco;
    }

    public void setCantoReTruco(String cantoReTruco) {
        this.cantoReTruco = cantoReTruco;
    }

    public int getPuntajeJ1() {
        return puntajeJ1;
    }

    public void setPuntajeJ1(int puntajeJ1) {
        this.puntajeJ1 = puntajeJ1;
    }

    public int getPuntajeJ2() {
        return puntajeJ2;
    }

    public void setPuntajeJ2(int puntajeJ2) {
        this.puntajeJ2 = puntajeJ2;
    }

    public int getPuntajeTruco() {
        return puntajeTruco;
    }

    public void setPuntajeTruco(int puntajeTruco) {
        this.puntajeTruco = puntajeTruco;
    }

    public boolean getFinMano() {
        return finMano;
    }

    public void setFinMano(boolean finMano) {
        this.finMano = finMano;
    }

    public boolean getFinPartida() {
        return finPartida;
    }

    public void setFinPartida(boolean finPartida) {
        this.finPartida = finPartida;
    }
    public void siguienteRonda(){
        if(nroRonda < 3){
            nroRonda++;
        }
    }

    public ArrayList<Carta> getCartasRonda1() {
        return cartasRonda1;
    }
    public ArrayList<Carta> getCartasRonda2() {
        return cartasRonda2;
    }
    public ArrayList<Carta> getCartasRonda3() {
        return cartasRonda3;
    }


    // ---- OBJETO OBSERVABLE ---- \\
    @Override
    public void agregarObservador(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void quitarObservador(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificarObservadores() {
        for(Observer ob : observadores){
            ob.actualizar(); // este actualizar lo uso para notificar el fin de mano a los dos jugadores
        }
    }

    @Override
    public void notificarCartaTirada(Carta c) {
        for(Observer ob : observadores){
            ob.actualizarCartaTirada(c); //
        }
    }

    @Override
    public void notificarFinMano() {
        for(Observer ob : observadores){
            ob.actualizarFinMano();
        }
    }

    @Override
    public void notificarCantoTanto(Jugador j, String msj) {
        for(Observer ob : observadores){
            ob.notificarTanto(j, msj);
        }
    }

    @Override
    public void notificarCantoTruco(Jugador j, String msj) {
        for(Observer ob : observadores){
            ob.notificarTruco(j, msj);
        }
    }

    @Override
    public void notificarMensaje(Jugador j, String mensaje) {
        for(Observer ob : observadores){
            ob.enviarMensaje(j, mensaje);
        }
    }


    @Override
    public void notificarPuntos(Anotador anotador) {
        for(Observer ob : observadores){
            ob.actualizarPuntos(anotador);
        }
    }
}
