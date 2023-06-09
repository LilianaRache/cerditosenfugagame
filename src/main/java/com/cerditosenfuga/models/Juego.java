/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerditosenfuga.models;
import java.util.ArrayList;
/**
 *
 * @author 
 */



/* Definimos la clase "Juego" */
public class Juego {

  // Creamos los atributos.
  private String jugador; // Nombre del jugador
  private ArrayList<String> retos; // Lista de retos (preguntas)
  private String enfoqueSeleccionado; // Enfoque seleccionado (Camino elegido por el jugador)

  // Creamos el constructor 
  public Juego(String jugador, ArrayList<String> retos, String enfoqueSeleccionado) {
    this.jugador = jugador;
    this.retos = retos;
    this.enfoqueSeleccionado = enfoqueSeleccionado;
  }

  // Creamos los métodos para acceder y modificar atributos.

  // Para el atributo "Jugador"
  public String getJugador() {
    return jugador;
  }

  public void setJugador(String jugador) {
    this.jugador = jugador;
  }
  
  // Para el atributo "Retos"
  public ArrayList<String> getRetos() {
    return retos;
  }

  public void setRetos(ArrayList<String> retos) {
    this.retos = retos;
  }

  // Para el atributo "Enfoque Seleccionado"
  public String getEnfoqueSeleccionado() {
    return enfoqueSeleccionado;
  }

  public void setEnfoqueSeleccionado(String enfoqueSeleccionado) {
    this.enfoqueSeleccionado = enfoqueSeleccionado;
  }

  // Creamos los metodos necesarios
  
  // Metodo para iniciar el juego.
   public void iniciarJuego(String nombre) {
    // Actualizamos el atributo "jugador" con el parametro ingresaddo.
    this.jugador = nombre;

    System.out.println("Se ha iniciado el juego y el nombre del jugador es: " + nombre);

  }

  // Método para seleccionar el camino (enfoque) elejido.
  public void seleccionarEnfoque(String enfoque) {
    // Actualizamos el atributo "enfoque seleccionado" con el parametro ingresado.
    this.enfoqueSeleccionado = enfoque;

    System.out.println("Has elegido el siguiente camino: " + enfoque);

  }

  // Método que selecciona una pregunta o reto segun el caso
  public void obtenerReto(ArrayList<String> listaRetos) {

    System.out.println("XXXXXXXXXXXXXX");

  }

  // Método para actualizar la vida del cerdito al perder un reto o reiniciar el juego
  public void actualizarVida(String cambioVida) {
      System.out.println("XXXXXXXXXXXXXX");
  }

}
