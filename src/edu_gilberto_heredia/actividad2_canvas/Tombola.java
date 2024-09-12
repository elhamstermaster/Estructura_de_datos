package edu_gilberto_heredia.actividad2_canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tombola {
    List<String> participantes = new ArrayList<>();
    List<String> premios = new ArrayList<>();
    List<String> ganadores = new ArrayList<>();

    // Constructor
    public Tombola() {
        // Usando un bucle para agregar 20 nombres de ejemplo
        for (int i = 1; i <= 20; i++) {
            participantes.add("Participante " + i);
        }

        // Agregar premios
        premios.add("Licuadora");
        premios.add("Audífonos");
        premios.add("Pantalla");
        premios.add("Sartenes");
        premios.add("Tostador");
    }

    // Método para seleccionar un participante al azar
    private String seleccionarParticipanteAlAzar() {
        Random random = new Random();
        int indiceRandom = random.nextInt(participantes.size());
        return participantes.get(indiceRandom);
    }

    // Método para seleccionar un participante al azar
    private String seleccionarPremioAlAzar() {
        Random random = new Random();
        int indiceRandom = random.nextInt(premios.size());
        return premios.get(indiceRandom);
    }

    // Método para realizar el sorteo
    public void realizarSorteo() {
        System.out.println("Lista de participantes:");
        for(String participante : participantes) {
            System.out.println(participante);
        }
        // Asegurarse de que hay suficientes premios y participantes
        if (premios.size() > 0 && participantes.size() > 0) {
            for (int i = 0; i < 5; i++) {
                // Seleccionar un participante y un premio al azar
                String participante = seleccionarParticipanteAlAzar();
                String premio = seleccionarPremioAlAzar();

                //Eliminar el participante y premio de sus respectivas listas
                participantes.remove(participante);
                premios.remove(premio);

                //Añadir el ganador y premio a la tercera lista
                ganadores.add(participante + " gana " + premio.toLowerCase());

            }
        }
    }

    //Método para mostrar los resultados
    public void mostrarResultados() {
        //Mostrar los ganadores por primera vez
        System.out.println();
        for(String ganador : ganadores) {
            System.out.println(ganador);
        }

        //Mostrar los perdedores
        System.out.println("\nLista de participantes sin premio:");
        for(String participante : participantes) {
            System.out.println(participante);
        }

        //Mostrar los ganadores por segunda vez
        System.out.println("\nLista de premios repartidos:");
        for(String ganador : ganadores) {
            //Convertir el formato "Participante gana Premio" a "(Participante:Premio)"
            String[] partes = ganador.split(" gana ");
            String participante = partes[0];
            String premio = partes[1];
            System.out.println("(" + participante + ":" + premio + ")");
        }
    }

}
