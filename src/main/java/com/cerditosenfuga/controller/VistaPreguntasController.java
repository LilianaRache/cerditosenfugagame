/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Juego;
import com.cerditosenfuga.models.Reto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Liliana
 */
public class VistaPreguntasController implements Initializable {

    Reto reto;
    int contador = 0;

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
        obtenerPreguntaRespuestas(enfoque);
    }

    /**
     * Metodo para retornar pregunta aleatoria
     */
    @FXML
    private void obtenerPreguntaRespuestas(String enfoque) {
        ArrayList<Reto> retosEnfoque = Main.juegoMain.seleccionarEnfoque(enfoque);
        ArrayList<Integer> retosAlcanzados = new ArrayList<>();
        reto = Main.juegoMain.obtenerReto(retosEnfoque, retosAlcanzados);
        System.out.println("Pregunta aleatoria: " + reto.getEnunciado());
        preguntaMostrar.setWrapText(true);
        preguntaMostrar.setText(reto.getEnunciado());
        mapearRespuestas(reto);
    }

    /**
     * Metodo para mostrar las posibles respuestas
     */
    @FXML
    private void mapearRespuestas(Reto reto) {
        btnRespuesta1.setText(reto.getRespuestas().get(0));
        btnRespuesta2.setText(reto.getRespuestas().get(1));
        btnRespuesta3.setText(reto.getRespuestas().get(2));
        btnRespuesta4.setText(reto.getRespuestas().get(3));
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
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    contador++;
                    incrementarProgreso(respuesta);
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta2")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    contador++;
                    incrementarProgreso(respuesta);
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta3")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    contador++;
                    incrementarProgreso(respuesta);
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta4")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    contador++;
                    incrementarProgreso(respuesta);
                    recargarEscena();
                }
                // incrementarProgreso();
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error en la seleccion de respuestas: " + e.getMessage());
        }
    }

    /**
     * Metodo para incrementar el progreso
     */
    public void incrementarProgreso(boolean respuesta) {
        try {
            Main.progreso += 0.1;
            if (respuesta) {
                if (Main.progreso >= 1) {
                    Main.progreso = 1; //ASI SEA MAS PEQUEÑO NO ESTA ENTRANDO
                }
                barraProgreso.setProgress(Main.progreso);
                porcentajeProgreso.setText(Math.round(Main.progreso * 100) + "%");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error cuando incrementa el progreso" + e.getMessage());
        }
    }

    /**
     * Metodo para crear alerta
     */
    @FXML
    public void alertaRespuesta(boolean respuesta) {
        if (respuesta) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("respuesta");
            alert.setHeaderText(null);
            alert.setContentText("Respuesta Correcta!!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("respuesta");
            alert.setHeaderText(null);
            alert.setContentText("Respuesta Incorrecta!!");
            alert.showAndWait();
        }

    }

    public void recargarEscena() throws IOException {
        if (contador <= 3) {
            Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } else {
            //No recarga, debe validar si son correctr las respuestas avanza... si no mostrar la vista del menu
        }

    }

}
