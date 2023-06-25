/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerditosenfuga.models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Juego (Principal)
 *
 * @author Jorge Grey
 */
/**
 * Definimos la clase "Juego"
 */
public class Juego {

    /**
     * Creamos los atributos.
     */
    private Jugador jugador; // Jugador
    private ArrayList<Integer> retosResueltos; // Lista de retosResueltos ya jugados(preguntas
    private String enfoqueSeleccionado; // Enfoque seleccionado (Camino elegido por el jugador)

    /**
     * Creamos los constructores
     */
    public Juego() {
    }

    public Juego(Jugador jugador, ArrayList<Integer> retosResueltos, String enfoqueSeleccionado) {
        this.jugador = jugador;
        this.retosResueltos = retosResueltos;
        this.enfoqueSeleccionado = enfoqueSeleccionado;
    }

    /**
     * Encapsulamiento de atributos
     */
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Integer> getRetosResueltos() {
        return retosResueltos;
    }

    public void setRetosResueltos(ArrayList<Integer> retosResueltos) {
        this.retosResueltos = retosResueltos;
    }

    public String getEnfoqueSeleccionado() {
        return enfoqueSeleccionado;
    }

    public void setEnfoqueSeleccionado(String enfoqueSeleccionado) {
        this.enfoqueSeleccionado = enfoqueSeleccionado;
    }

    /**
     * Creamos los metodos necesarios
     */
    /**
     * Metodo para iniciar el juego.
     */
    public void iniciarJuego(Jugador jugador) {
        // Actualizamos el atributo "jugador" con el parametro ingresaddo.
        this.jugador = jugador;
        System.out.println("Se ha iniciado el juego y el nombre del jugador es: " + jugador.getNombre());

    }

    /**
     * Método para seleccionar el camino (enfoque) elejido.
     *
     */
    public ArrayList<Reto> seleccionarEnfoque(String enfoque) {
        // Actualizamos el atributo "enfoque seleccionado" con el parametro ingresado.
        this.enfoqueSeleccionado = enfoque;
        ArrayList<Reto> retos = new ArrayList<>();
        System.out.println("Has elegido el siguiente camino: " + enfoque);
        String rutaArchivo = "src/main/resources/challenges/enfoque" + enfoque.toLowerCase() + ".txt";

        // Se realiza la lectura del archivo según sea el enfoque seleccionado para cargar los retosResueltos y
        // Se mapea cada línea del archivo dentro de un objeto Reto para agregarlo a la lista de retosResueltos
        try {
            FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] registro = linea.split("\\|");

                ArrayList<String> respuestas = new ArrayList();
                respuestas.add(registro[2]);
                respuestas.add(registro[3]);
                respuestas.add(registro[4]);
                respuestas.add(registro[5]);

                Reto reto = new Reto(Integer.parseInt(registro[0]), enfoque.toLowerCase(), registro[1], respuestas, registro[6]);

                retos.add(reto);
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo del enfoque " + enfoque);
        }
        return retos;

    }

    /**
     * Método que selecciona una pregunta o reto segun el caso
     *
     */
    public Reto obtenerReto(ArrayList<Reto> listaRetos, ArrayList<Integer> retosAlcanzados) {

        System.out.println("Generando Pregunta Aleatoria");

        Reto retoGenerado = new Reto();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listaRetos.size());

        retoGenerado = listaRetos.get(indiceAleatorio);

        if (retosAlcanzados.contains(retoGenerado.getId())) {
            System.out.println("Reto Jugado Anteriormente. Reto = " + retoGenerado.toString());
            retoGenerado = obtenerReto(listaRetos, retosAlcanzados);
        }

        return retoGenerado;

    }

    /**
     * Método que valida si la respuesta es correcta o incorrecta
     *
     */
    public boolean validadRespuesta(String respuestaDada, Reto reto) {

        Integer posicionRespuesta = reto.getRespuestas().indexOf(respuestaDada);

        if (posicionRespuesta.toString().equals(reto.getCorrecta())) {
            System.out.println("Respuesta Correcta");
            return true;
        } else {
            System.out.println("Respuesta Incorrecta");
            return false;
        }
    }

    /**
     * Método para actualizar la vida del cerdito al perder un reto o reiniciar
     * el juego
     *
     * @param cambioDeVida
     */
    public void actualizarVida(int cambioDeVida) {
        int nuevaVida = jugador.getVida() + (cambioDeVida);
        jugador.setVida(nuevaVida);
    }

}
