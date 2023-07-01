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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author basan
 */
public class VistaCasaLadrilloController implements Initializable {

    @FXML
    private Label preguntaMostrar;
    @FXML
    private Button btnRespuesta1;
    @FXML
    private Button btnRespuesta2;
    @FXML
    private Button btnRespuesta3;
    @FXML
    private Button btnRespuesta4;
    @FXML
    private Label enfoquePreguntas;
    @FXML
    private ProgressBar barraProgreso;
    @FXML
    private Label porcentajeProgreso;
    @FXML
    private HBox contenedorVidas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void metodoClick(MouseEvent event) {
    }
    
}
