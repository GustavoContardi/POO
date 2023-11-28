package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mazo {
    private static ArrayList<Carta> mazoCartas = new ArrayList<>();

    public Mazo (){
        if(mazoCartas.isEmpty()){
            mazoCartas.add(new Carta(1, "Espada", 100));
            mazoCartas.add(new Carta(2, "Espada", 20));
            mazoCartas.add(new Carta(3, "Espada", 30));
            mazoCartas.add(new Carta(4, "Espada", 4));
            mazoCartas.add(new Carta(5, "Espada", 5));
            mazoCartas.add(new Carta(6, "Espada", 6));
            mazoCartas.add(new Carta(7, "Espada", 75));
            mazoCartas.add(new Carta(10, "Espada", 10));
            mazoCartas.add(new Carta(11, "Espada", 11));
            mazoCartas.add(new Carta(12, "Espada", 12));
            mazoCartas.add(new Carta(1, "Basto", 99));
            mazoCartas.add(new Carta(2, "Basto", 20));
            mazoCartas.add(new Carta(3, "Basto", 30));
            mazoCartas.add(new Carta(4, "Basto", 4));
            mazoCartas.add(new Carta(5, "Basto", 5));
            mazoCartas.add(new Carta(6, "Basto", 6));
            mazoCartas.add(new Carta(7, "Basto", 7));
            mazoCartas.add(new Carta(10, "Basto", 10));
            mazoCartas.add(new Carta(11, "Basto", 11));
            mazoCartas.add(new Carta(12, "Basto", 12));
            mazoCartas.add(new Carta(1, "Oro", 15));
            mazoCartas.add(new Carta(2, "Oro", 20));
            mazoCartas.add(new Carta(3, "Oro", 30));
            mazoCartas.add(new Carta(4, "Oro", 4));
            mazoCartas.add(new Carta(5, "Oro", 5));
            mazoCartas.add(new Carta(6, "Oro", 6));
            mazoCartas.add(new Carta(7, "Oro", 70));
            mazoCartas.add(new Carta(10, "Oro", 10));
            mazoCartas.add(new Carta(11, "Oro", 11));
            mazoCartas.add(new Carta(12, "Oro", 12));
            mazoCartas.add(new Carta(1, "Copa", 15));
            mazoCartas.add(new Carta(2, "Copa", 20));
            mazoCartas.add(new Carta(3, "Copa", 30));
            mazoCartas.add(new Carta(4, "Copa", 4));
            mazoCartas.add(new Carta(5, "Copa", 5));
            mazoCartas.add(new Carta(6, "Copa", 6));
            mazoCartas.add(new Carta(7, "Copa", 7));
            mazoCartas.add(new Carta(10, "Copa", 10));
            mazoCartas.add(new Carta(11, "Copa", 11));
            mazoCartas.add(new Carta(12, "Copa", 12));

        }
    }

    public void repartirCartas(Jugador j1, Jugador j2){
        ArrayList<Carta> cartas = mazoCartas;
        Collections.shuffle(cartas);
        Random random = new Random();
        Carta c1, c2;
        int cantCartas = 0, numero_random;
        ArrayList<Carta> recibidasJ1 = new ArrayList<>();
        ArrayList<Carta> recibidasJ2 = new ArrayList<>();

        while (cantCartas < 3){
            numero_random = random.nextInt(cartas.size());
            if(!recibidasJ1.isEmpty() && !recibidasJ1.contains(cartas.get(numero_random))){
                c1 = cartas.get(numero_random);
                recibidasJ1.add(c1);
            }
            else if(!recibidasJ1.isEmpty() && recibidasJ1.contains(cartas.get(numero_random))){
                do{
                    numero_random = random.nextInt(cartas.size());
                } while (recibidasJ1.contains(cartas.get(numero_random)));
                c1 = cartas.get(numero_random);
                recibidasJ1.add(c1);
            }
            else if (recibidasJ1.isEmpty()){
                c1 = cartas.get(numero_random);
                recibidasJ1.add(c1);
            }
            cantCartas++;
        }
        j1.recibirCartas(recibidasJ1);


        // --------- \\

        while (recibidasJ2.size() < 3){
            numero_random = random.nextInt(cartas.size());

            if(!recibidasJ2.isEmpty() && !recibidasJ1.contains(cartas.get(numero_random)) && !recibidasJ2.contains(cartas.get(numero_random))){
                c2 = cartas.get(numero_random);
                recibidasJ2.add(c2);
            }
            else if(!recibidasJ2.isEmpty() && (recibidasJ2.contains(cartas.get(numero_random))) || !recibidasJ1.contains(cartas.get(numero_random))){
                do{
                    numero_random = random.nextInt(cartas.size());
                } while (recibidasJ2.contains(cartas.get(numero_random)) && recibidasJ1.contains(cartas.get(numero_random)));
                c2 = cartas.get(numero_random);
                recibidasJ2.add(c2);
            }
            else if (recibidasJ2.isEmpty()){
                if(recibidasJ1.contains(cartas.get(numero_random))){
                    do{
                        numero_random = random.nextInt(cartas.size());
                    } while (recibidasJ1.contains(cartas.get(numero_random)));
                }
                c2 = cartas.get(numero_random);
                recibidasJ2.add(c2);
            }
        }
        j2.recibirCartas(recibidasJ2);

    }

    public ArrayList<Carta> mezclarCartas(ArrayList<Carta> cartas){
        Collections.shuffle(cartas);
        return cartas;
    }
    public void mostrarCartas(){
        Carta c1;
        for(int i=0; i<mazoCartas.size(); i++){
            c1 = mazoCartas.get(i);
            System.out.println(c1.getNumero() + " de " + c1.getPalo());
        }
    }

    public static ArrayList<Carta> getMazoCartas() {
        return mazoCartas;
    }

}
