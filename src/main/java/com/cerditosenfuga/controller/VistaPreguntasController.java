/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Liliana
 */
public class VistaPreguntasController implements Initializable {

    @FXML
    private Button btnRespuesta1;
    @FXML
    private Button btnRespuesta2;
    @FXML
    private Button btnRespuesta3;
    @FXML
    private Button btnRespuesta4;
    @FXML
    private ProgressBar barraProgreso;
    @FXML
    private Label porcentajeProgreso;

    double progreso;
    @FXML
    private Label llbPregunta;

    /**
     * Initializa la clase controllador vistas Preguntas.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barraProgreso.setStyle("-fx-accent: #6bf533;");
    }
    
    
    /**
     * Metodo para incrementar el progreso
     */
        
    public void incrementarProgreso() {
        progreso += 0.1;
        if (progreso >= 1) {
            progreso = 1;
        }
        barraProgreso.setProgress(progreso);
        porcentajeProgreso.setText(Math.round(progreso * 100) + "%");

    }
       
    /**
     * 
     * @param event 
     * Metodo para identificar cual boton hizo click
     */
    

    @FXML
    private void metodoClick(MouseEvent event) {
        Object source = event.getSource();
        System.out.println("Se presionó el botón: " + source.toString());
        if (source instanceof Button) {
             // Aquí puedes acceder a los atributos específicos del botón
            Button button = (Button) source;
            if (button.getId().equals( "btnRespuesta1")) {
                System.out.println("Texto del botón: " + button.getText());
            } else if (button.getId().equals( "btnRespuesta2")) {
                System.out.println("Texto del botón: " + button.getText());
            }
            String buttonId = button.getId();
            System.out.println("ID del botón: " + buttonId);
            incrementarProgreso();
        }
    }


}
