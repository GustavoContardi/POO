package Pilas;

public class pNodo {
    private pNodo tope = null;
    private Object dato;
    private pNodo siguiente = null;

    public void setDato(Object dato){
        this.dato = dato;
    }
    public Object getDato(){
        return dato;
    }

    public void setTope(pNodo newTope){
        this.tope = newTope;
    }
    public pNodo getTope(){
        return tope;
    }

    public void setSiguiente(pNodo nodo){
        this.siguiente = nodo;
    }

    public pNodo getSiguiente(){
        return siguiente;
    }

}
