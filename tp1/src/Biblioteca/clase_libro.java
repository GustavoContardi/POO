package Biblioteca;

public class clase_libro {

    private String titulo;
    private String autor;
    private int paginas;
    private int cantidad;
    private int prestados;

    public clase_libro() {
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    public int getPaginas() {
        return paginas;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setPrestados(int prestados){
        this.prestados = prestados;
    }
    public int getPrestados() {
        return prestados;
    }
}
