package Listas_java;

public class cNodo {
    private Object dato;
    private cNodo proximo = null;

    public void setDato(Object dato) {
        this.dato = dato;
    }
    public Object getDato(){
        return dato;
    }
    public void setProximo(cNodo proximo) {
        this.proximo = proximo;
    }
    public cNodo getProximo() {
        return proximo;
    }
}
