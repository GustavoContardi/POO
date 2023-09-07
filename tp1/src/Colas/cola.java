package Colas;

public class cola {
    private cNodo frente = null;
    private cNodo ultimo = null;

    public boolean c_es_vacia() { return (frente == null); }

    public void c_encolar(Object dato){
        cNodo nodoAux = frente;
        cNodo nuevoNodo = new cNodo();
        nuevoNodo.setDato(dato);

        if(frente == null){
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        }

        else{
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public Object c_desencolar(){
        cNodo cRetorno = new cNodo();
        cNodo cAux = new cNodo();

        cRetorno = frente;
        cAux = frente;
        frente = cAux.getSiguiente();
        cAux.setSiguiente(null);

        return cRetorno.getDato();
    }

    public cNodo c_recuperar(){
        return frente;
    }

    public String c_mostrar(){
        String acumulador = "";

        acumulador += "Cola: ( ";
        cNodo next = new cNodo();
        Object aux;
        next = frente;
        cola cAux = new cola();

        while(next != null){
            aux = c_desencolar();
            cAux.c_encolar(aux);
            acumulador += aux + " ";
            next = frente;
        }
        // devuelvo la cola
        acumulador += ")";
        next = cAux.c_recuperar();
        while(next != null){
            aux = cAux.c_desencolar();
            c_encolar(aux);
            next = cAux.c_recuperar();
        }

        return acumulador;
    }

    public int c_longitud(){
        int longitud = 0;
        cNodo next = new cNodo();
        Object aux;
        next = frente;
        cola cAux = new cola();

        while(next != null){
            aux = c_desencolar();
            cAux.c_encolar(aux);
            longitud++;
            next = frente;
        }
        // devuelvo la cola
        next = cAux.c_recuperar();
        while(next != null){
            aux = cAux.c_desencolar();
            c_encolar(aux);
            next = cAux.c_recuperar();
        }
        return longitud;
    }

    public void c_borrar(Object dato){
        int longitud = 0;
        cNodo next = new cNodo();
        Object aux;
        next = frente;
        cola cAux = new cola();

        while(next != null){
            aux = c_desencolar();
            if(!aux.equals(dato)){
                cAux.c_encolar(aux);
            }
            next = frente;
        }
        // devuelvo la cola
        next = cAux.c_recuperar();
        while(next != null){
            aux = cAux.c_desencolar();
            c_encolar(aux);
            next = cAux.c_recuperar();
        }
    }

}
