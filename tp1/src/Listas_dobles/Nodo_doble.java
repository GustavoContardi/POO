package Listas_dobles;

public class Nodo_doble {
    private Object dato;
    private Nodo_doble proximo = null;
    private Nodo_doble anterior = null;

    public void setDato(Object dato) {
        this.dato = dato;
    }
    public Object getDato(){
        return dato;
    }
    public void setProximo(Nodo_doble proximo) {
        this.proximo = proximo;
    }
    public Nodo_doble getProximo() {
        return proximo;
    }

    public void setAnterior(Nodo_doble anterior){
        this.anterior = anterior;
    }

    public Nodo_doble getAnterior(){
        return anterior;
    }
}
