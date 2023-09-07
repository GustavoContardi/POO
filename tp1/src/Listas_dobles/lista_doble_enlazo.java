package Listas_dobles;

public class lista_doble_enlazo {
    private Nodo_doble primero = null;


    // IMPORTANTE: ld_(lo que siga) es: ListaDoble .... bla bla || para no confundir con el tad de lista simple
    public boolean ld_es_vacia(){
        return (primero == null);
    }

    public void ld_agregar(Object dato){
        Nodo_doble nuevoNodo = new Nodo_doble();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
        }
        else{
            Nodo_doble nodoAux = primero;
            while(nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(nodoAux);
        }
    }

    public String ld_mostrar(){
        Nodo_doble nodoAux = primero;

        if(primero == null){
            return  "Lista VACIA!!!";
        }
        else{
            String acumulador = "";
            acumulador += "Lista: ( ";
            while(nodoAux != null){
                acumulador += nodoAux.getDato() + " ";
                nodoAux = nodoAux.getProximo();
            }
            acumulador += ")";

            return acumulador;
        }

    }

    public int ld_longitud(){
        int i = 0;
        Nodo_doble nodoAux = primero;
        if(primero == null){return i;}
        while(nodoAux != null){
            i++;
            nodoAux = nodoAux.getProximo();
        }
        return i;
    }

    public boolean ld_borrar(Object dato){
        if(primero == null){
            return false;
        }
        Nodo_doble nodoAnt = new Nodo_doble();
        boolean result = false;
        Nodo_doble siguiente;
        Nodo_doble nodoAux;
        nodoAux = primero;
        Nodo_doble nodoPos = primero;

        if(dato == primero.getDato()){
            primero = nodoAux.getProximo();
            nodoAux.setProximo(null);
            result = true;
        }

        else{
            while(nodoAux.getProximo() != null){
                siguiente = nodoAux.getProximo();
                if(siguiente.getDato() == dato){
                    result = true;
                    nodoAnt = nodoAux;
                    nodoPos = nodoAux.getProximo();

                }
                nodoAux = nodoAux.getProximo();
            }
            nodoAnt.setProximo(nodoPos.getProximo());
            (nodoPos.getProximo()).setAnterior(nodoAnt);
            nodoPos.setProximo(null);
            nodoPos.setAnterior(null);
        }
        return result;
    }

    public void ld_insertar(int pos, Object dato){
        Nodo_doble nodoAnt = new Nodo_doble();
        Nodo_doble nodoPos = new Nodo_doble();
        Nodo_doble nodoAux;
        nodoAux = primero;

        Nodo_doble nuevoNodo = new Nodo_doble();
        nuevoNodo.setDato(dato);

        if (primero == null || pos > ld_longitud()){
            ld_agregar(dato);
        }

        else if(pos == 1){
            nuevoNodo.setProximo(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        }
        else{
            for(int i=0; i<pos-1; i++){
                nodoAnt = nodoAux;
                nodoPos = nodoAux.getProximo();
                nodoAux = nodoAux.getProximo();
            }
            nuevoNodo.setAnterior(nodoAnt);
            nuevoNodo.setProximo(nodoPos);
            nodoAnt.setProximo(nuevoNodo);
            nodoPos.setAnterior(nuevoNodo);
        }
    }

    public Object ld_recuperar(Object dato){
        return dato;  // a esperar a ver que hay que hacer con esto;
    }
}
