package edu_gilberto_heredia.actividad2.process;

import edu_gilberto_heredia.actividad2.data.Nodos;

public class Lista { //debe tener cabecera y cola de la lista
    protected Nodos inicio, fin; //punteros para saber donde está el inicio y fin

    public Lista()
    { //Constructor, solo inicia punteros
        inicio = null;
        fin = null;
    }

    //Método para saber si la lista está vacía
    public boolean EstaVacia (){
        if (inicio==null){
            return true;
        } else {
            return false;
        }
    }

    //metodo para agregar un nodo al inicio de la lista
    public void agregarAlInicio (int elemento) {
        //crear nodo
        inicio = new Nodos(elemento,inicio);

        if (fin==null){ //si aun no habia nodos
            fin = inicio; //apunta al inicio
        }
    }

    //metodo para insertar al final de la lista
    public void agregarAlFinal (int elemento) {
        if (!EstaVacia()) {
            fin.siguiente = new Nodos(elemento);
            fin = fin.siguiente;
        } else {
            inicio = fin = new Nodos(elemento);
        }
    }

    //metodo para mostrar datos
    public void mostrarLista(){
        Nodos recorre = inicio;
        System.out.println();
        while (recorre!=null){ //muestra los elementos de cada nodo
            System.out.print("["+recorre.dato+"]"+"-->");
            recorre = recorre.siguiente;
        }
    }

    public int eliminarElInicial() {
        int elemento = inicio.dato;
        if(inicio == fin) { //Si solo hay un nodo o ninguno
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente; //Puntero hacia inicio.siguiente,
        }
        return elemento; //Que se nos regrese el elemento que eliminamos.
    }


    public int eliminarAlFinal() {
        int elemento = fin.dato;
        if(inicio == fin) {
            inicio = fin = null;
        } else {
            Nodos temp = inicio;
            while (temp.siguiente!=fin) {
                temp = temp.siguiente;
            }
            fin = temp; //Nodo final apunta a temporal
            fin.siguiente = null; //Nodo final apunta a siguiente, puesto en nulo
        }
        return elemento;
    }

    //Eliminar un elemento de la lista
    public void eliminar(int elemento) {
        if(!EstaVacia()) {
            if(inicio == fin && elemento == inicio.dato) {
                inicio = fin = null;
            } else if (elemento == inicio.dato) {
                inicio = inicio.siguiente;
            } else {
                Nodos anterior, temp;
                anterior =  inicio;
                temp = inicio.siguiente;

                //Recorrer la lista
                while(temp!= null && temp.dato!=elemento){
                    anterior = anterior.siguiente;
                    temp = temp.siguiente;
                } if (temp!=null) {
                    anterior.siguiente = temp.siguiente;
                    if(temp == fin) {
                        fin = anterior;
                    }
                }
            }
        }
    }

}