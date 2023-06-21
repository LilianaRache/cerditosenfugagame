/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controlador de la vista menu.
 *
 * @author Jorge Grey
 */
public class VistaMenuController implements Initializable {

    private Juego juegoEnfoque = new Juego();

    @FXML
    private Button btnPreguntaMatematicas;
    @FXML
    private Button btnPreguntaGeografia;
    @FXML
    private Button btnAdivinanzas;

    /**
     * Inicializamos la clase del controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void obtenerPreguntasMatematicas(ActionEvent event) {
        try {
            Main.juegoMain.setEnfoqueSeleccionado("matematicas");
            System.out.println("Este es el enfoque con el que queda el Juego: " + Main.juegoMain.getEnfoqueSeleccionado());
            Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnPreguntaMatematicas.getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(VistaMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void obtenerPreguntasGeografia(ActionEvent event) {
        try {
            Main.juegoMain.setEnfoqueSeleccionado("geografia");
            System.out.println("Este es el enfoque con el que queda el Juego: " + Main.juegoMain.getEnfoqueSeleccionado());
            Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnPreguntaGeografia.getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(VistaMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void obtenerAdivinanzas(ActionEvent event) {
        try {
            Main.juegoMain.setEnfoqueSeleccionado("adivinanzas");
            System.out.println("Este es el enfoque con el que queda el Juego: " + Main.juegoMain.getEnfoqueSeleccionado());
            Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnAdivinanzas.getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(VistaMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
