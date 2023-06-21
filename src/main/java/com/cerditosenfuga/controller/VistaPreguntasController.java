/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Juego;
import com.cerditosenfuga.models.Reto;
import java.net.URL;
import java.util.ArrayList;
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

    double progreso;

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
    @FXML
    private Label preguntaMostrar;
    @FXML
    private Label enfoquePreguntas;

    /**
     * Initializa la clase controllador vistas Preguntas.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barraProgreso.setStyle("-fx-accent: #6bf533;");
        String enfoque = Main.juegoMain.getEnfoqueSeleccionado();
        enfoquePreguntas.setText("Preguntas de " + enfoque.substring(0, 1).toUpperCase() + enfoque.substring(1));
        obtenerPregunta(enfoque);
    }

    /**
     * Metodo para retornar pregunta aleatoria
     */
    @FXML
    private void obtenerPregunta(String enfoque) {
        ArrayList<Reto> retosEnfoque = Main.juegoMain.seleccionarEnfoque(enfoque);
        ArrayList<Integer> retosAlcanzados = new ArrayList<>();
        Reto reto = Main.juegoMain.obtenerReto(retosEnfoque, retosAlcanzados);
        preguntaMostrar.setText(reto.getEnunciado());
    }

    /**
     *
     * @param event Metodo para identificar cual boton hizo click
     */
    @FXML
    private void metodoClick(MouseEvent event) {
        try {
            Object source = event.getSource();
            if (source instanceof Button) {
                // Aquí puedes acceder a los atributos específicos del botón
                Button button = (Button) source;
                if (button.getId().equals("btnRespuesta1")) {
                    System.out.println("Texto del botón: " + button.getText());
                } else if (button.getId().equals("btnRespuesta2")) {
                    System.out.println("Texto del botón: " + button.getText());
                } else if (button.getId().equals("btnRespuesta3")) {
                    System.out.println("Texto del botón: " + button.getText());
                } else if (button.getId().equals("btnRespuesta4")) {
                    System.out.println("Texto del botón: " + button.getText());
                }
                incrementarProgreso();
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error en la seleccion de respuestas: " + e.getMessage());
        }
    }

    /**
     * Metodo para incrementar el progreso
     */
    public void incrementarProgreso() {

        try {
            progreso += 0.1;
            if (progreso >= 1) {
                progreso = 1;
            }
            barraProgreso.setProgress(progreso);
            porcentajeProgreso.setText(Math.round(progreso * 100) + "%");
        } catch (Exception e) {
            System.err.println("Ocurrió un error cuando incrementa el progreso" + e.getMessage());
        }
    }

}
