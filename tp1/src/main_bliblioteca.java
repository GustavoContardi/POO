import Biblioteca.Libro;
import Biblioteca.clase_libro;

public class main_bliblioteca {
    public static void main(String[] args){

        Libro Ronaldo = new Libro();
        Libro Messi = new Libro();

        Ronaldo.registrarLibro("El Loco y el Cuerdo", "Litinho", 1239, 3, 2);

        Ronaldo.mostrarLibro();
        System.out.println("Presto el libro 1 vez.\n");
        System.out.println("total prestado: " + Ronaldo.totalPrestados());
        Ronaldo.prestarLibro();
        Ronaldo.mostrarLibro();
        System.out.println("\ntotal prestado: " + Ronaldo.totalPrestados());

        System.out.println("\n-------------");
        Messi.registrarLibro("Lionel Messi", "Lionel Messi", 2500000, 1, 50);
        Messi.mostrarLibro();
        System.out.println("Presto el libro 1 vez.\n");
        System.out.println("total prestado: " + Messi.totalPrestados());
        Messi.prestarLibro();
        Messi.mostrarLibro();
        System.out.println("\ntotal prestado: " + Messi.totalPrestados());

        System.out.println("\n-------------");

        if(Messi.cantidad_hojas() < Ronaldo.cantidad_hojas()){
            System.out.print("Tiene mas cantidad de paginas ");
            Ronaldo.mostrarLibro();
        }
        else{
            System.out.print("Tiene mas cantidad de paginas ");
            Messi.mostrarLibro();
        }

    }
}
