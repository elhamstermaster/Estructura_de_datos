package edu_gilberto_heredia.colas_priorizadas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char siNo;

        Queue <Integer> cola = new LinkedList <Integer>();
        cola.add(10);
        cola.add(20);
        cola.add(30);
        cola.add(40);
        cola.add(50);
        cola.add(60);

        System.out.println("Elemento que está en el inicio de la cola: " + cola.peek());
        int tamanio = cola.size();

        System.out.println("¿Desea vaciar los elementos de la cola? s/n");
        siNo = entrada.next().charAt(0);

        if(siNo == 's') {
            System.out.println("Vaciando los elementos de la cola: ");
            cola.clear();
            System.out.println(cola);
        } else if (siNo == 'n')
        {
            System.out.println("Ok. Elementos de la cola: " + cola);
        }


        /* while(!cola.isEmpty())
        {
            System.out.println("Los elementos de la cola: " + cola);

        }

         */

    }
}

