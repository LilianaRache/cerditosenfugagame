/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Jugador;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label textoGanarOPerder1;
    @FXML
    private Label textoGanarOPerder2;
    @FXML
    private Button btnVolverajugar;
    @FXML
    private Button btnsalir;

    /**
     * Inicializamos la clase del controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarTextoFinal();
    }    
    @FXML
    /**
     * handleButtonSalirClick Crea la funcionalidad del boton Exit
     */
    private void handleButtonSalirClick(ActionEvent event) {
        System.exit(0);
    }
     @FXML
    /**
     * handleButtonReiniciarClick Crea la funcionalidad del boton "Volver a jugar"
     */
    private void handleButtonReiniciarClick(ActionEvent event) throws IOException {
        VistaInicioController.jugadorActual.setNombre("");
        VistaInicioController.jugadorActual.setVida(3);
        VistaInicioController.jugadorActual.setRetosAlcanzados(0);
        
        Main.juegoMain.setEnfoqueSeleccionado("");
        Main.juegoMain.setRetosResueltos(new ArrayList<Integer>());
        Main.juegoMain.setJugador(VistaInicioController.jugadorActual);
        
        /*Main.launch();*/
        Parent tercerRoot = FXMLLoader.load(getClass().getResource("/views/VistaInicio.fxml"));

        Stage stage = (Stage) btnVolverajugar.getScene().getWindow();
        Scene scene = new Scene(tercerRoot);
        stage.setScene(scene); 
    }
    /**
     * Metodo generar el texto a mostrar segun si el jugador gana o pierde.
     */
    @FXML
    private void mostrarTextoFinal() {
        if(Main.juegoMain.getJugador().getVida() > 0){
            textoGanarOPerder1.setText("¡FELICIDADES!");
            textoGanarOPerder2.setText("¡HAS GANADO!");
        }else{
            textoGanarOPerder1.setText("LO SIENTO");
            textoGanarOPerder2.setText("¡HAS PERDIDO!");
        }
            
    }
}
