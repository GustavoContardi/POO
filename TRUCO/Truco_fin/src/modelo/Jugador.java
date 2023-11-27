package modelo;


import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int partidasGanadasTotal;
    private ArrayList<Carta> cartasRepartidas = new ArrayList<>();
    private static ArrayList<Jugador> jugadoresActuales = new ArrayList<>();
    private ArrayList<Carta> cartasRepartidasCopia = new ArrayList<>();


    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCartas(ArrayList<Carta> cartas){
        cartasRepartidas = cartas;
        cartasRepartidasCopia = cartas;
    }

    public void devolverCartas(){
        cartasRepartidas.clear();
    }

    public ArrayList<Carta> getCartasRepartidas() {
        return cartasRepartidasCopia;
    }
    public ArrayList<Carta> ObtenerCartasRepartidas() {
        return cartasRepartidas;
    }



    public String getNombre() {
        return nombre;
    }


    public boolean tieneFlor(){
        boolean result = false;
        if(cartasRepartidas != null){
            if(cartasRepartidas.get(0).getPalo().equals(cartasRepartidas.get(1).getPalo()) && cartasRepartidas.get(0).getPalo().equals(cartasRepartidas.get(2).getPalo())){
                result = true;
            }
        }
        return result;
    }


    public Carta tirarCarta(int numero){
        // siempre y cuando sea un numero entre 1 y 3
        Carta tirada = cartasRepartidas.get(numero-1);
        cartasRepartidas.remove(cartasRepartidas.get(numero-1));
        return tirada;
    }



    public void agregarJugador(Jugador j){
        jugadoresActuales.add(j);
    }

}
