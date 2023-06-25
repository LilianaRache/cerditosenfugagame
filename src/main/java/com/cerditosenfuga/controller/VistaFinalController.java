/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Jugador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controlador de la vista final.
 *
 * @author Jorge Grey
 */
public class VistaFinalController implements Initializable {

    @FXML
    private Button btnVolverajugar;
    @FXML
    private Button btnsalir;

    /**
     * Inicializamos la clase del controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButton2Click(ActionEvent event) throws IOException {
        Parent tercerRoot = FXMLLoader.load(getClass().getResource("/views/VistaInicio.fxml"));

        Stage stage = (Stage) btnVolverajugar.getScene().getWindow();
        Scene scene = new Scene(tercerRoot);
        stage.setScene(scene);
    }

    @FXML
    private void handleButton1Click(ActionEvent event) {
        System.exit(0);
    }

}
