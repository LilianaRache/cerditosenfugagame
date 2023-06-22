/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

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
            Parent terceRoot = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnPreguntaMatematicas.getScene().getWindow();
            Scene scene = new Scene (terceRoot);
            stage.setScene(scene);
            
        } catch (IOException e) {
            e.printStackTrace();
               }
    }

    @FXML
    private void obtenerPreguntasGeografia(ActionEvent event) {
    }

    @FXML
    private void obtenerAdivinanzas(ActionEvent event) {
    }

}
