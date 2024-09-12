package edu_gilberto_heredia.pilas;

import javax.swing.*;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pila2 {
    public static void main(String[] args)
    {
        Stack <Integer> miPila = new Stack<>();

        int tamanio = 0; //Tamaño elegido por el usuario
        int dataActual = 0; //Dato de un nodo en cuestión

        tamanio = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos elementos deseas agregar?"));

        for (int i = 0; i < tamanio; i++)
        {
            dataActual = Integer.parseInt(
                    JOptionPane.showInputDialog("Inserta el elemento " + (i+1)));
            miPila.push(dataActual);
        }

        //Mostrar la lista
        System.out.println("Los elementos de la pila son:");
        System.out.println(miPila);

        try
        {
            miPila.pop();
        } catch (Exception ex)
        {
            Logger.getLogger(Pila2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miPila);

    }
}
