package Juegos_palabras;

import java.util.ArrayList;
import java.util.Scanner;

public class Diccionario {
    private ArrayList<String> palabras;

    public Diccionario(){
        palabras = new ArrayList<>();
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void agregar_palabras(){
        Scanner scanner = new Scanner(System.in);
        String palabra;
        do{
            System.out.print("Ingrese la palabra(F para finalizar): ");
            palabra = scanner.nextLine();
            if(!validar_palabra(palabra) && !palabra.equals("F")){
                palabras.add(palabra);
            }
            else System.out.println("La palabra ya esta en el diccionario");
        }while (!palabra.equals("F"));
    }

    public boolean validar_palabra(String palabra){
        boolean result = false;
        ArrayList<String> dic = palabras;
        // verifica si esta la palabra en el diccionario
        for(int i = 0; i < dic.size(); i++){
            if(dic.get(i).equals(palabra)){
                result = true;
            }
        }
        return result;
    }

    public void mostrar_diccionario(){
        if(palabras.isEmpty()) System.out.println("Diccionario VACIO !!");
        else{
            System.out.println("\t-- PALABRAS --");
            for (int i=0; i<palabras.size(); i++){
                System.out.println("- " + palabras.get(i));
            }
        }
    }
}
