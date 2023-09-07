package Juegos_palabras;


import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private String Nombre;
    private int Puntaje;
    private Diccionario diccionario = new Diccionario();

    public int getPuntaje() {
        return Puntaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setPuntaje(int puntaje) {
        this.Puntaje = puntaje;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public void sumar_letras(ArrayList<String> palabras_formadas){
        int suma = 0;
        String[] claves = {"x", "z", "y", "w", "q", "k"};
        String letra;
        for(int i=0; i<palabras_formadas.size(); i++){
            suma += palabras_formadas.get(i).length();
            String aux =  palabras_formadas.get(i);
            for(int j=0; j<aux.length(); j++){
                letra = String.valueOf(aux.charAt(j));
                for(int p=0; p<claves.length; p++){
                    if(claves[p].equals(letra)){
                        suma++;
                    }
                }
            }
        }
        setPuntaje(suma);
    }

    public void formar_palabras(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> palabras_formadas = new ArrayList<>();
        String palabra="";
        diccionario.mostrar_diccionario();
        System.out.println();
        do{ // verifico que no sea F, que este en el diccionario y que no este ya elegida
            System.out.print("Ingrese una palabra(F para finalizar): ");
            palabra = scanner.nextLine();
            if (diccionario.validar_palabra(palabra) && !palabras_formadas.contains(palabra)){
                palabras_formadas.add(palabra);
            }
            else{
                System.out.println("La palabra no esta en el diccionario o ya la utilizaste");
            }
        } while (!palabra.equals("F"));

        sumar_letras(palabras_formadas); // sumo el puntaje
    }

    public void agregar_palabras_dic(){
        diccionario.agregar_palabras();
    }

    public void ver_diccionario(){
        diccionario.mostrar_diccionario();
    }

}
