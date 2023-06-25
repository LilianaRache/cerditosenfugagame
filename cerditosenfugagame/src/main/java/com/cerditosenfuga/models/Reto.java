/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerditosenfuga.models;

import java.util.ArrayList;

/**
 * Clase Reto
 *
 * @author Jorge Grey
 */

/**
 * Definimos la clase "Reto"
 */
public class Reto {

    /**
     * Creamos los atributos
     */
    private Integer id;
    private String enfoque;
    private String enunciado;
    private ArrayList<String> respuestas;
    private String correcta;

    /**
     * Creamos el constructor
     */
    public Reto() {
    }

    /**
     * Creamos el constructor con atributos
     */
    public Reto(Integer id, String enfoque, String enunciado, ArrayList<String> respuestas, String correcta) {
        this.id = id;
        this.enfoque = enfoque;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }

    /**
     * Encapsulamiento de atributos
     */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
      
    public String getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(String enfoque) {
        this.enfoque = enfoque;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }
    
    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
    
    
     @Override
    public String toString() {
        return "Reto{" + "id=" + id + ", enfoque=" + enfoque + ", enunciado=" + enunciado + ", respuestas=" + respuestas + ", correcta=" + correcta + '}';
    }
   
}
