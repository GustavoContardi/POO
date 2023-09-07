package Pilas;

public class pila {
    private pNodo tope;

    public pila p_crear(){
        tope = null;
        System.out.println("Pila creada");
        return new pila();
    }

    public boolean p_es_vacia(){
        return (tope == null);
    }

    public pila p_apilar(Object dato){
        pila pRetorno = new pila();
        pNodo nuevoNodo = new pNodo();
        nuevoNodo.setDato(dato);

        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;

        return pRetorno;
    }

    public Object p_desapilar(){
        if(tope == null){
            return null;
        }
        pNodo pAux = tope;
        tope = tope.getSiguiente();
        return pAux.getDato();
    }

    public pNodo p_recuperar(){
        return tope;
    }

    public String p_mostrar(){
        Object Aux;
        String resultado = "";
        pila pRetorno = new pila();
        pNodo next = tope;
        resultado += "Pila: ( " ;
        while (next != null){
            Aux = p_desapilar();
            resultado += Aux + " ";
            pRetorno.p_apilar(Aux);
            next = next.getSiguiente();
        }
        resultado += " )";

        // devuelvo la pila
        next = pRetorno.p_recuperar();
        while(next != null){
            Aux = pRetorno.p_desapilar();
            p_apilar(Aux);
            next = next.getSiguiente();
        }

        return resultado;

    }

    public pila p_insertar(){
        pila pAux = null;
        return pAux;
    }

    public pila p_borrar(Object dato){
        pila pAux = null;
        return pAux;
    }

    public int p_longitud(){
        int longitud = 0;
        pila pilaAux = new pila();
        Object Aux;
        pNodo next = tope;
        while(next != null){
            longitud++;
            Aux = p_desapilar();
            next = next.getSiguiente();
            pilaAux.p_apilar(Aux);
        }
        next = pilaAux.p_recuperar();
        while(next != null){
            Aux = pilaAux.p_desapilar();
            p_apilar(Aux);
            next = next.getSiguiente();
        }

        return longitud;
    }
}
