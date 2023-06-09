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

// Definimos la clase "Reto"
public class Reto {
    
    // Creamos los atributos
    private int id;
    private String enfoque;
    private String enunciado;
    private ArrayList<String> respuestas;
    private String correcta;
    
    // Creamos el constructor
    public Reto (int id, String enfoque, String enunciado, ArrayList<String> respuestas, String correcta){
        this.id = id;
        this.enfoque = enfoque;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }
    
    // Creamos las funciones para retornar y modificar atributos
    
    // Para el atributo "Id"
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    // Para el atributo "Enfoque"
    public String getEnfoque(){
        return enfoque;
    }
    public void setEnfoque(String enfoque){
        this.enfoque = enfoque;
    }
    
    
    // Para el atributo "Enunciado"
    
    public String getEnunciado(){
        return enunciado;
    }
    
    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }
    
    // Para el atributo "Respuestas"
    
    public ArrayList<String> getRespuestas(){
        return respuestas;
    }
    
    public void getRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
    // Para el atributo "Correcta"
    public String getCorrecta(){
        return correcta;
    }
    
    public void setCorrecta(String correcta){
        this.correcta = correcta;
    }
    
    // Creamos las funciones
    
    public void validadRespuesta(String respuestaDada, String respuestaCorrecta){
        System.out.println("XXXXXXXXXXXXX");               
    }
}
