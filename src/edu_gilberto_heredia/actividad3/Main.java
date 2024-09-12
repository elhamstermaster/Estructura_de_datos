package edu_gilberto_heredia.actividad3;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Stack <String> miCalendario = new Stack<>();
        int opcion = 0;
        String mesActual; //Dato de un nodo en cuestión
        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        do {
            try {
                System.out.println("""
                        ------------MENÚ DE CALENDARIO-----------
                        -----------------------------------------
                        1.--> Empujar meses del año (mes)
                        2.--> Sacar un mes de la cima (pop)
                        3.--> Ver cuál es el elemento en la cima
                        4.--> Eliminar un elemento (remove)
                        5.--> Mostrar si hay meses en la pila
                        6.--> Ver si la pila está vacía
                        7.--> Mostrar el tamaño de la pila
                        8.--> Salir del programa.""");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1 ->
                    {
                        try
                        {
                            int i = 0; // Contador de meses válidos ingresados
                            while (i < 12) {
                                System.out.println("\nIngresa el mes " + (12 - i) + " del año:");
                                mesActual = entrada.next();

                                // Verifica si el mes está en el arreglo meses
                                boolean mesValido = false;
                                for (String mes : meses) {
                                    if (mes.equalsIgnoreCase(mesActual)) {
                                        mesValido = true;
                                        break;
                                    }
                                }
                                if (mesValido) {
                                    // Solo decrementa el tamaño si el mes es válido
                                    miCalendario.push(mesActual);
                                    i++; // Incrementa solo si el mes es válido
                                } else {
                                    System.out.println("Ingresa un mes válido, por favor.");
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error de entrada: " + e.getMessage());
                            entrada.next();
                        }
                    }
                    case 2 ->
                    {
                        try
                        {
                            mesActual = miCalendario.pop();
                            System.out.println("Mes sacado de la cima: " + mesActual + "\n");
                        }
                        catch (NumberFormatException n)
                        {
                            System.out.println("Error" + n.getMessage());
                        }
                    }
                    case 3 -> System.out.println("Mes en la cima de la pila: " + miCalendario.peek() + "\n");
                    case 4 ->
                    {
                        System.out.println("Ingresa el mes por remover: ");
                        mesActual = entrada.next();
                        miCalendario.remove(mesActual);
                        System.out.println();

                    }
                    case 5 ->
                    {
                        try
                        {
                            if(!miCalendario.isEmpty())
                            {
                                System.out.println("SÍ HAY elementos en la pila: " + miCalendario.size() + " elementos.\n");
                            } else {
                                System.out.println("NO HAY elementos en la pila.\n");
                            }

                        }
                        catch (NumberFormatException n)
                        {
                            System.out.println("Error" + n.getMessage());
                        }
                    }
                    case 6 ->
                    {
                        try
                        {
                            if(miCalendario.isEmpty())
                            {
                                System.out.println("NO HAY elementos en la pila.\n");
                            } else {
                                System.out.println("SÍ HAY elementos en la pila.\n");
                            }

                        }
                        catch (NumberFormatException n)
                        {
                            System.out.println("Error" + n.getMessage());
                        }

                    }
                    case 7 ->
                    {
                        try
                        {
                            System.out.println("Tamaño del calendario: " + miCalendario.size() + " elementos.\n");
                        }
                        catch (NumberFormatException n)
                        {
                            System.out.println("Error" + n.getMessage());
                        }

                    }
                    default -> System.out.println("Ok.\n");
                }
            } catch (Exception e) {
                System.out.println("Opción incorrecta.");
            }
        } while (opcion != 8);

    }
}
