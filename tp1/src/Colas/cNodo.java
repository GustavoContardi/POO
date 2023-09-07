package Colas;

public class cNodo {
    private Object dato;
    private cNodo frente = null;
    private cNodo siguiente = null;


    private cNodo ultimo = null;
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public Object getDato(){
        return dato;
    }
    public void setFrente(cNodo frente) {
        this.frente = frente;
    }
    public cNodo getFrente() {
        return frente;
    }
    public void setFinal(cNodo ultimo) {
        this.ultimo = ultimo;
    }
    public cNodo getFinal() {
        return ultimo;
    }

    public void setSiguiente(cNodo siguiente) {
        this.siguiente = siguiente;
    }
    public cNodo getSiguiente() {
        return siguiente;
    }
}
