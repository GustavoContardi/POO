package observer;

import modelo.Anotador;
import modelo.Carta;
import modelo.Jugador;

public interface Observer {
    void actualizar();
    void actualizarFinMano();
    void actualizarCartaTirada(Carta c);

    void enviarMensaje(Jugador j, String mensaje);
    void notificarTruco(Jugador j, String msj);
    void notificarTanto(Jugador j, String msj);
    void actualizarPuntos(Anotador anotador);
}
