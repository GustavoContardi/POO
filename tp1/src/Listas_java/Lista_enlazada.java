package Listas_java;

public class Lista_enlazada {
    private cNodo primero = null;

    public void agregar(Object dato){
        cNodo nuevoNodo = new cNodo();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
        }
        else{
            cNodo nodoAux = primero;
            while (nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
        }
    }
    public String l_mostrar(){
        cNodo nodoAux = primero;
        if (primero == null){
            return "\nlista vacian't";
        }
        else {
            String acumulador = "";
            acumulador += "Lista: ( ";
            while (nodoAux != null) {
                acumulador += nodoAux.getDato() + " ";
                nodoAux = nodoAux.getProximo();
            }
            acumulador += ")";
            return acumulador;
        }
    }

    public Lista_enlazada buscar_pares(){
        Lista_enlazada l_aux = new Lista_enlazada();
        if (primero != null) {
            cNodo nodoAux = primero;
            while (nodoAux != null) {
                int auxiliar = (int) nodoAux.getDato();
                if ((auxiliar % 2) == 0) {
                    l_aux.agregar(auxiliar);
                }
                nodoAux = nodoAux.getProximo();
            }
        }
        return l_aux;
    }

    public boolean l_borrar_dato(Object dato){
        cNodo nodoAnt = new cNodo();
        cNodo en_pos = new cNodo();
        cNodo siguiente;
        boolean result = false;

        if(primero == null) {                           // verifico lista no vacia
            return false;
        }
        cNodo nodoAux = primero;
        if (dato == primero.getDato()){
            primero = nodoAux.getProximo();
            nodoAux.setProximo(null);
            result = true;
        }
        else {
            while(nodoAux.getProximo() != null){
                siguiente = nodoAux.getProximo();
                if(siguiente.getDato() == dato){
                    result = true;
                    nodoAnt = nodoAux;
                    en_pos = nodoAux.getProximo();
                }
                nodoAux = nodoAux.getProximo();
            }
            nodoAnt.setProximo(en_pos.getProximo());
            en_pos.setProximo(null);
        }
        return result;
    }

    public int l_longitud(){
        int i = 0;
        cNodo nodoAux = primero;
        if(primero == null){return i;}
        while(nodoAux != null){
            i++;
            nodoAux = nodoAux.getProximo();
        }
        return i;
    }

    public void l_insertar(int pos, Object elemento){
        cNodo nodoAux = primero;
        cNodo nodoAnt = new cNodo();
        cNodo en_pos = new cNodo();
        cNodo nodo_elemento = new cNodo();
        nodo_elemento.setDato(elemento);

        if(pos == 1){
            nodo_elemento.setProximo(primero);
            primero = nodo_elemento;
        }
        else{
            for (int i=0;i<pos-1;i++) {
                nodoAnt = nodoAux;
                en_pos = nodoAux.getProximo();
                nodoAux = nodoAux.getProximo();
            }
            nodo_elemento.setProximo(en_pos);
            nodoAnt.setProximo(nodo_elemento);
        }
    }

    public boolean l_buscar(Object dato){
        boolean result = false;

        if(primero == null){
            return false;
        }
        cNodo nodoAux = primero;

        while(nodoAux != null){
            if(nodoAux.getDato() == dato){
                result = true;
            }
            nodoAux = nodoAux.getProximo();
        }

        return result;
    }

    public Object l_recuperar(){
        // retorna el primer elemento de la lista
        return primero;
    }

    public boolean l_es_vacia(){
        return (primero == null);
    }
}
