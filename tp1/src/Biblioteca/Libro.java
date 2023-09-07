package Biblioteca;

public class Libro {

    private clase_libro nuevoLibro = new clase_libro();
    static private int prestamosTotal;

    public Libro(){
        prestamosTotal = 0;
    }

    public void registrarLibro(String nombre, String autor, int paginas, int cantidad, int prestados){
        nuevoLibro.setPaginas(paginas);
        nuevoLibro.setCantidad(cantidad);
        nuevoLibro.setTitulo(nombre);
        nuevoLibro.setPrestados(prestados);
        nuevoLibro.setAutor(autor);

        prestamosTotal += nuevoLibro.getPrestados();
        System.out.println("Libro registrado con éxito!\n");
    }

    public void prestarLibro(){
        // primero verifico si se puede prestar el libro
        if(nuevoLibro.getCantidad() <= 1){
            System.out.printf("No se puede prestar el libro: '%s', debido a que solo queda un ejemplar.\n", nuevoLibro.getTitulo());
        }
        else{
            System.out.println("El libro '" + nuevoLibro.getTitulo() + "' ha sido prestado.\n");
            int cant = nuevoLibro.getCantidad() - 1;
            nuevoLibro.setCantidad(cant);
            cant = nuevoLibro.getPrestados() + 1;
            nuevoLibro.setPrestados(cant);
            prestamosTotal++;
        }


    }

    public void mostrarLibro(){
        System.out.printf("El libro '%s' creado por el autor '%s', tiene %d páginas, quedan %d disponibles y se prestaron %d.\n",  nuevoLibro.getTitulo(),  nuevoLibro.getAutor(),  nuevoLibro.getPaginas(),  nuevoLibro.getCantidad(),  nuevoLibro.getPrestados());
    }

    public int totalPrestados(){
        return prestamosTotal;
    }

    public int cantidad_hojas(){
        return nuevoLibro.getPaginas();
    }
}
