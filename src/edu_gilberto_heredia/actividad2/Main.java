package edu_gilberto_heredia.actividad2;

import edu_gilberto_heredia.actividad2.process.Lista;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        int opcion = 0, elem;
        do {
            try {
                //validar
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                           1.--> Agregar un elemento al inicio de la lista
                           2.--> Agregar un elemento al final de la lista
                           3.--> Mostrar los datos de la lista
                           4.--> Eliminar un elemento del inicio de la lista
                           5.--> Eliminar un elemento del final de la lista
                           6.--> Eliminar un elemento en específico de la lista
                           7.--> Salir""", "MENÚ DE OPCIONES: ", 3));

                switch (opcion) {
                    case 1 -> {
                        try {
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el Elemento:",
                                    "Insertando al inicio", 3));
                            //Llamamos al método
                            lista1.agregarAlInicio(elem); //agrega nodo
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog (null, "Error" + n.getMessage());
                        } }
                    case 2 -> {
                        try {
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el Elemento:",
                                    "Insertando al final", 3));
                            //Llamamos al método
                            lista1.agregarAlFinal(elem); //agrega nodo
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog (null, "Error" + n.getMessage());
                        } }
                    case 3 -> lista1.mostrarLista();
                    case 4 -> {
                        elem = lista1.eliminarElInicial();
                        JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elem,
                                "Eliminando nodo del inicio", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 5 -> {
                        elem = lista1.eliminarAlFinal();
                        JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elem,
                                "Eliminando nodo del final", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 6 -> {
                        elem = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el " + "elemento a eliminar", "Eliminando nodo seleccionado", JOptionPane.INFORMATION_MESSAGE));
                        lista1.eliminar(elem);
                    }
                    default -> JOptionPane.showMessageDialog(null, "Ok");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción incorrecta");
            }
        } while (opcion != 7);
    }
}

