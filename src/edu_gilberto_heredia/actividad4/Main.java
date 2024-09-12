package edu_gilberto_heredia.actividad4;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        String cliente;

        Queue<String> colaUniFila = new LinkedList<>();
        Queue <String> colaApertura = new LinkedList <>();
        Queue <String> colaVentanilla = new LinkedList <>();
        Queue <String> colaEjecutivo = new LinkedList <>();

        int opcion = 0;

        System.out.println("""
                    -----------------------------MENÚ DE UNIFILA BANCARIA----------------------------
                    ---------------------------------------------------------------------------------
                    ***Tu trabajo es formar a la gente y decidir cuándo se podrá atender a alguien***""");

        do {
            try {
                System.out.println("""
                        ----------------------------------------------------
                        1. Registrar a alguien en la unifila (fila general).
                        2. Elegir cola.
                        3. Atender a una persona de apertura de cuentas.
                        4. Atender en ventanilla.
                        5. Atender en ejecutivos.
                        6. Salir del menú.""");

                // Validación para asegurarse de que la entrada sea un número
                if (!entrada.hasNextInt())
                {
                    System.out.println("Por favor, ingrese un número válido.");
                    entrada.next();  // Descartar la entrada no válida
                    continue;  // Volver al inicio del ciclo
                }

                opcion = entrada.nextInt();

                // Validación de rango de opción
                if (opcion < 1 || opcion > 6)
                {
                    System.out.println("Por favor, elija una opción entre 1 y 6.");
                    continue;  // Volver al inicio del ciclo
                }


                switch (opcion)
                {
                    case 1 -> {
                        try
                        {
                            entrada.nextLine(); //Limpio el buffer
                            System.out.println("¿Cuál es su nombre?");
                            cliente = entrada.nextLine().trim();

                            if(cliente.isEmpty())
                            {
                                System.out.println("Error. El nombre no puede estar vacío.\n");
                            } else
                            {
                                colaUniFila.add(cliente);
                                System.out.println("Muy bien, en un momento le atendemos, " + cliente + ".\n");
                            }
                        } catch (InputMismatchException e)
                        {
                            System.out.println("Error de entrada: " + e.getMessage());
                            entrada.next();
                        }
                    }
                    case 2 -> {
                        if (colaUniFila.isEmpty())
                        {
                            System.out.println("La fila general está vacía. No hay nadie para atender.\n");
                        } else
                        {
                            System.out.println("Buen día, " + colaUniFila.element() + ". Adelante.");
                            char opcionServicio;
                            do {
                                System.out.println("""
                                        ¿Qué desea hacer?
                                        a. Formarse para abrir cuenta.
                                        b. Formarse en ventanilla.
                                        c. Formarse para atención de ejecutivo.""");

                                opcionServicio = entrada.next().charAt(0);
                                if(opcionServicio != 'a' && opcionServicio != 'b' && opcionServicio != 'c') {
                                    System.out.println("Opción inválida. Por favor ingrese a, b o c.");
                                }
                            } while (opcionServicio != 'a' && opcionServicio != 'b' && opcionServicio != 'c');

                            switch (opcionServicio) {
                                case 'a' -> {
                                    colaApertura.add(colaUniFila.remove());
                                    System.out.println("\nMuy bien, ahora está formado en la cola para abrir una cuenta, en un momento se le atenderá.\n");
                                }
                                case 'b' -> {
                                    colaVentanilla.add(colaUniFila.remove());
                                    System.out.println("Muy bien, ahora está formado en la cola para ventanilla, en un momento se le atenderá.\n");
                                }
                                case 'c' -> {
                                    colaEjecutivo.add(colaUniFila.remove());
                                    System.out.println("Muy bien, ahora está formado en la cola para ejecutivos, en un momento se le atenderá.\n");
                                }
                            }
                        }
                    }
                    case 3 ->
                    {
                        if (colaApertura.isEmpty())
                        {
                            System.out.println("La cola de apertura de cuentas está vacía.\n");
                        } else
                        {
                            System.out.println("Adelante " + colaApertura.peek() + "...\n");
                            colaApertura.remove();
                        }
                    }
                    case 4 ->
                    {
                        if (colaVentanilla.isEmpty())
                        {
                            System.out.println("La cola de ventanilla está vacía.\n");
                        } else
                        {
                            System.out.println("Adelante " + colaVentanilla.peek() + "...");
                            colaVentanilla.remove();
                        }
                    }
                    case 5 ->
                    {
                        if(colaEjecutivo.isEmpty())
                        {
                            System.out.println("La cola de ventanilla está vacía.\n");
                        } else
                        {
                            System.out.println("Adelante " + colaEjecutivo.peek() + "...");
                            colaEjecutivo.remove();
                        }
                    }
                    case 6 -> System.out.println("Gracias por usar el sistema de Unifila Bancaria.");
                    default -> System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese un número.");
                entrada.nextLine();  // Limpiar buffer
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (opcion != 6);

    }
}
