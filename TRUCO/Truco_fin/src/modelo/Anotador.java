package modelo;


import java.util.ArrayList;

public class Anotador {
    private int puntajeJ1 = -1;
    private int puntajeJ2 = -1;
    private Jugador j1;
    private Jugador j2;

    public Anotador(Jugador j2, Jugador j1) {
        if(puntajeJ2 == -1 && puntajeJ1 == -1) {
            puntajeJ2 = 0;
            puntajeJ1 = 0;
        }
        this.j1 = j1;
        this.j2 = j2;
    }

    public void sumarJ1(int cant){
        puntajeJ1 += cant;
    }

    public void sumarJ2(int cant){
        puntajeJ2 += cant;
    }

    public int getPuntajeJ1() {
        return puntajeJ1;
    }

    public int getPuntajeJ2() {
        return puntajeJ2;
    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public String toString(){
        return "PUNTAJES:   " + j1.getNombre()+": " + puntajeJ1 + "   ||   " + j2.getNombre()+": " + puntajeJ2;
    }

}
