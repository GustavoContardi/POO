package Contraseña;

import java.util.Random;


public class Contrasenia {
    private String contrasenia = "";

    private int longitud = 8;

    public void setLongitud(int longitud){
        this.longitud = longitud;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String generar_contraseña(int longitud){
        if (longitud >= 8) setLongitud(longitud);
        else longitud = 8;

        String acumulador = "";
        char c;
        Random rand = new Random();
        int numero;
        for(int i=0; i<longitud; i++){
            do {
                numero = rand.nextInt(74)+48;
            }while(!((numero >= 48 && numero <= 57) || (numero >= 65 && numero <= 90) || (numero >= 97 && numero <= 122)));
                c = (char)numero;
                acumulador += c;
        }
        setContrasenia(acumulador);
        return acumulador;
    }

    public Boolean validarContraseña(){
        int cont_mayus = 0, cont_minus = 0, cont_nro = 0;
        String contra = getContrasenia();

        for(int i=0; i<longitud; i++){
            char c = contra.charAt(i);
            if(c >= 48 && c <= 57 ){
                cont_nro++;
            }
            else if(c >= 65 && c <= 90 ){
                cont_mayus++;
            } else if (c >= 97 && c <= 122) {
                cont_minus++;
            }
        }
        if((cont_minus < 1) && (cont_mayus < 2) && (cont_nro < 2)){
            System.out.println(getContrasenia()+": - Debil");
            return false;
        }
        else{
            System.out.println(getContrasenia()+" - Fuerte");
            return true;
        }
    }

    public String nueva_contraseña(int longitud){
        String contra = "";
        do{
            contra = generar_contraseña(longitud);
        }while(!validarContraseña());

        return contra;
    }

    public String verContraseña(){
        return getContrasenia();
    }
}
