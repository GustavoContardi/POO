package modelo;

import java.util.ArrayList;

public  class Envido {

    private int puntosEnvido;
    private static ArrayList<Integer> jerarquia = new ArrayList<>();

    public Envido() {
        puntosEnvido = 0;
        if(jerarquia.isEmpty()){
            jerarquia.add(7);
            jerarquia.add(6);
            jerarquia.add(5);
            jerarquia.add(4);
            jerarquia.add(3);
            jerarquia.add(2);
            jerarquia.add(1);
            jerarquia.add(12);
            jerarquia.add(11);
            jerarquia.add(10);
        }
    }

    public int puntajeEnvido(Jugador j1) {
        ArrayList<Carta> cartasIgualPalo = cartasMismoPalo(j1.getCartasRepartidas());
        if (cartasIgualPalo == null) {
            Carta cartaMax = masAlta(j1.getCartasRepartidas());
            puntosEnvido = cartaMax.getNumero();
        } else if (cartasIgualPalo.size() >= 2) {
            if (cartasIgualPalo.get(0).getNumero() > 9 && cartasIgualPalo.get(1).getNumero() > 9) {
                puntosEnvido = 20;
            } else if (cartasIgualPalo.get(0).getNumero() > 9 || cartasIgualPalo.get(1).getNumero() > 9) {
                Carta cartaMax = masAlta(cartasIgualPalo);
                puntosEnvido = 20 + cartaMax.getNumero();
            } else {
                puntosEnvido = 20 + cartasIgualPalo.get(0).getNumero() + cartasIgualPalo.get(1).getNumero();
            }
        } else {
            Carta cartaMax = masAlta(j1.getCartasRepartidas());
            puntosEnvido = cartaMax.getNumero();
        }

        return puntosEnvido;
    }


    private ArrayList<Carta> cartasMismoPalo(ArrayList<Carta> cartas){
        ArrayList<Carta> cartasIgualPalo = new ArrayList<>();

        if((cartas.get(0).getPalo() == cartas.get(1).getPalo()) && cartas.get(0).getPalo() == cartas.get(2).getPalo()){
            cartasIgualPalo = cartasAltas(cartas);
        } else if(cartas.get(0).getPalo().equalsIgnoreCase(cartas.get(1).getPalo())){
            cartasIgualPalo.add(cartas.get(0));
            cartasIgualPalo.add(cartas.get(1));
        } else if(cartas.get(0).getPalo().equalsIgnoreCase(cartas.get(2).getPalo())){
            cartasIgualPalo.add(cartas.get(0));
            cartasIgualPalo.add(cartas.get(2));
        } else if(cartas.get(2).getPalo().equalsIgnoreCase(cartas.get(1).getPalo())){
            cartasIgualPalo.add(cartas.get(2));
            cartasIgualPalo.add(cartas.get(1));
        }

        return cartasIgualPalo;
    }

    private ArrayList<Carta> cartasAltas (ArrayList<Carta> cartas){
        ArrayList<Carta> cartasMayores = new ArrayList<>();


        Carta cartasAltas = masAlta(cartas);
        cartasMayores.add(cartasAltas);
        cartasAltas = masAlta(cartas);
        cartasMayores.add(cartasAltas);

        return cartasMayores;

    }

    private Carta masAlta(ArrayList<Carta> cartas){
        Carta cartaAlta = null;
        int max = 99;

        for(int i=0; i< cartas.size(); i++){
            if(jerarquia.indexOf(cartas.get(i).getNumero()) < max){
                max = jerarquia.indexOf(cartas.get(i).getNumero());
                cartaAlta = cartas.get(i);
            }
        }

        return cartaAlta;
    }

}
