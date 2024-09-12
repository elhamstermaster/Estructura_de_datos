package edu_gilberto_heredia.pilas;

import java.util.Stack;

public class MetodoPila {
    public static void main(String[] args) {
        Stack pila = new Stack<>();
        pila.push(5);
        pila.push(15);
        pila.push(7);
        pila.push(0);
        pila.push(100);

        System.out.println("La pila está vacía? " + pila.isEmpty());
        System.out.println("El tamaño de la pila es: " + pila.size());
        System.out.println("La cima de la pila es: " + pila.peek());
        System.out.println("Sacando un elemento de la pila... " + pila.pop());
        System.out.println("Sacando un elemento de la pila... " + pila.pop());
        System.out.println("El tamaño de la pila es: " + pila.size());
        System.out.println("Sacando un elemento de la pila: " + pila.pop());
        System.out.println("¿La pila está vacía? " + pila.isEmpty());

    }
}
