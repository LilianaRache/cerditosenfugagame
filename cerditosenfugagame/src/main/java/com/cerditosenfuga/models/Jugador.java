/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerditosenfuga.models;

/**
 * Clase Jugador
 * @author Jorge Grey
 */

/**
* Definimos la clase "Jugador"
*/

public class Jugador {
    /**
    * Creamos loa atributos
    */
    private String nombre;
    private int vida;
    private int retosAlcanzados;
    
    /**
    * Creamos el constructor
    */
    public Jugador (String jugador, int vida, int retosAlcanzados){
        this.nombre = jugador;
        this.vida = vida;
        this.retosAlcanzados = retosAlcanzados; 
    }
    /**
    * Creamos las funciones para retornar y modificar atributos
    */
  
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
   
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    
   
    public int getRetosAlcanzados(){
        return retosAlcanzados;
    }
    public void setRetosAlcanzados(int retosAlcanzados){
        this.retosAlcanzados = retosAlcanzados;
    }
}
