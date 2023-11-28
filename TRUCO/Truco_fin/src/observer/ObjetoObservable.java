package observer;

import modelo.Anotador;
import modelo.Carta;
import modelo.Jugador;

public interface ObjetoObservable {
    void agregarObservador(Observer observer);
    void quitarObservador(Observer observer);
    void notificarObservadores();
    void notificarCartaTirada(Jugador j, Carta c);
    void notificarFinMano();
    void notificarCantoTanto(Jugador j, String msj);
    void notificarCantoTruco(Jugador j, String msj);
    void notificarMensaje(Jugador j, String mensaje);
    void notificarPuntos(Anotador anotador);
    void notificarFinPartida();
}
