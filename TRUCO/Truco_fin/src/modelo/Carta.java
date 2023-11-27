package modelo;

import java.util.ArrayList;

public class Carta {

    private int numero_carta;
    private String palo;
    private int poder;

    public Carta(int numero_carta, String palo, int poder) {
        this.numero_carta = numero_carta;
        this.palo = palo;
        this.poder = poder;
    }



    public int getNumero() {
        return numero_carta;
    }

    public String getPalo() {
        return palo;
    }
    public int getPoder() {
        return poder;
    }

    public Carta cartaGanadora(Carta c1, Carta c2){
        Carta result = null;
        if(c1.getPoder() > c2.getPoder()) return c1;
        else if(c2.getPoder() > c1.getPoder()) return c2;
        else return null;
    }

    public String toString(){
        return this.getNumero() + " de " + this.getPalo();
    }
}
