package edu_gilberto_heredia.actividad2.data;

public class Nodos {
    public int dato; // Aquí se guarda el número
    public Nodos siguiente; // Aquí se guarda el enlace al siguiente nodo

    // Constructor para crear un nodo que se agregará al final
    public Nodos(int d) {
        this.dato = d; // Guarda el número en el nodo
        this.siguiente = null; // No hay siguiente nodo todavía
    }

    //Constructor para crear un nodo que se agregará al inicio
    public Nodos(int d, Nodos n) {
        dato = d; // Guarda el número en el nodo
        siguiente = n; // Enlace al siguiente nodo
    }
}
