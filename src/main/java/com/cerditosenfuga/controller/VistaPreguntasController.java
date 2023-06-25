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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Liliana
 */
public class VistaPreguntasController implements Initializable {

    Reto reto;
    Juego juego;

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
    @FXML
    private HBox contenedorVidas;

    
    /**
     * Initializa la clase controllador vistas Preguntas.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barraProgreso.setStyle("-fx-accent: #6bf533;");
        barraProgreso.setProgress(Main.progreso);
        porcentajeProgreso.setText(Math.round(Main.progreso * 100) + "%");
        String enfoque = Main.juegoMain.getEnfoqueSeleccionado();
        enfoquePreguntas.setText("Preguntas de " + enfoque.substring(0, 1).toUpperCase() + enfoque.substring(1));
        obtenerPreguntaRespuestas(enfoque);
        System.out.println("Progreso al iniciar ventana: " + barraProgreso.getProgress());
        mostrarVidas();
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
                    Main.contador++;
                    if (respuesta) {
                        Main.incrementarProgreso();
                    }else{
                        Main.juegoMain.actualizarVida(-1);
                    }
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta2")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta) {
                        Main.incrementarProgreso();
                    }else{
                        Main.juegoMain.actualizarVida(-1);
                    }
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta3")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta) {
                        Main.incrementarProgreso();
                    }else{
                        Main.juegoMain.actualizarVida(-1);
                    }
                    recargarEscena();
                } else if (button.getId().equals("btnRespuesta4")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta) {
                        Main.incrementarProgreso();
                    }else{
                        Main.juegoMain.actualizarVida(-1);
                    }
                    recargarEscena();
                }
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error en la seleccion de respuestas: " + e.getMessage());
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
    /**
     * Metodo para mostrar las vidas del jugador
     */
    @FXML
    private void mostrarVidas() {
        
        contenedorVidas.getChildren().clear();

        for (int i = 0; i < Main.juegoMain.getJugador().getVida(); i++) {
      // Creamos un objeto ImageView con la imagen de un corazón
            ImageView imageView = new ImageView(new Image("imagens/corazon.png"));
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);

      // Añadimos el objeto ImageView al contenedor
            contenedorVidas.getChildren().add(imageView);
        }
    }

    public void recargarEscena() throws IOException {
        if (/*Main.contador <= 3*/ Main.progreso < 1 && Main.juegoMain.getJugador().getVida() > 0 ) {
            Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaPreguntas.fxml"));
            Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } else {
            //No recarga, debe validar si son correctr las respuestas avanza... si no mostrar la vista del menu
            if (Main.progreso >= 1 && Main.juegoMain.getJugador().getVida() > 0) {
                Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaMenuDos.fxml"));
                Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                Scene scene = new Scene(loader);
                stage.setScene(scene);
               }
            if(Main.juegoMain.getJugador().getVida() <= 0){
                   Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                    Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                    Scene scene = new Scene(loader);
                    stage.setScene(scene);
               }
                //else {
//                Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaMenuController.fxml"));
//                Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
//                Scene scene = new Scene(loader);
//                stage.setScene(scene);
//
//            }
        }

    }
    
    
    

}
