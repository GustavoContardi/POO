import Contraseña.Contrasenia;

public class main_contraseña {
    public static void main(String[] arg){

         Contrasenia contra = new Contrasenia();

         contra.nueva_contraseña(2);

        System.out.println(contra.verContraseña());

    }
}
