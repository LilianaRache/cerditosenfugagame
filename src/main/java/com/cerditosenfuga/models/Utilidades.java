/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerditosenfuga.models;

/**
 * Clase Utilidades
 * @author Jorge Grey
 */


/**
 * Definimos la clase "Utilidades"
 */
public class Utilidades {
    /**
    * Creamos los atributos
    */   
    
    private String cronometro;

    /**
    * Creamos el constructor.
    */
    public Utilidades (String crono){
        this.cronometro = crono;
    }
    /**
    * Creamos las funciones para retornar y modificar atributos.
    */
    public String getCronometro(){
        return cronometro;
    }
    public void setCronometro(String cronometro){
        this.cronometro = cronometro;
    }
    /**
    * Creamos los metodos necesarios.
    */
    public void generarCronometro(String cronometro){
        System.out.println("Cronometro generado con exito");
    }
}
