/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Reto;
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
 * @author basan
 */
public class VistaCasaLadrilloController implements Initializable {
    Reto reto;
    
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
    private Label tituloCasa;
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
        barraProgreso.setStyle("-fx-accent: #6bf533;");
        barraProgreso.setProgress(Main.progreso);
        porcentajeProgreso.setText(Math.round(Main.progreso * 100) + "%");
        tituloCasa.setText("Casa de Ladrillo");
        obtenerPreguntaRespuestas("adivinanzas");
        System.out.println("Progreso al iniciar ventana: " + barraProgreso.getProgress());
        mostrarVidas();
        Main.preguntaCasaLadrillo++;
    }    
           /**
     * Metodo para retornar pregunta aleatoria
     * @param enfoque
     */
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
    private void mapearRespuestas(Reto reto) {
        btnRespuesta1.setText(reto.getRespuestas().get(0));
        btnRespuesta2.setText(reto.getRespuestas().get(1));
        btnRespuesta3.setText(reto.getRespuestas().get(2));
        btnRespuesta4.setText(reto.getRespuestas().get(3));
    }
    
    private void mostrarVidas() {
        
        contenedorVidas.getChildren().clear();

        for (int i = 0; i < Main.juegoMain.getJugador().getVida(); i++) {
            ImageView imageView = new ImageView(new Image("imagens/corazon.png"));
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);

            contenedorVidas.getChildren().add(imageView);
        }
    }
            /**
     * Metodo para crear alerta
     */
    private void alertaRespuesta(boolean respuesta) {
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
                    if (respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso <= 0.672) {
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso > 0.672){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso < 0.896){
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 3 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() > 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaCasaPaja.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() == 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }

                } else if (button.getId().equals("btnRespuesta2")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso <= 0.672) {
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso > 0.672){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso < 0.896){
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 3 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() > 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaCasaPaja.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() == 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }           
                } else if (button.getId().equals("btnRespuesta3")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso <= 0.672) {
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso > 0.672){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso < 0.896){
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 3 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() > 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaCasaPaja.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() == 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }
              } else if (button.getId().equals("btnRespuesta4")) {
                    boolean respuesta = Main.juegoMain.validadRespuesta(button.getText(), reto);
                    alertaRespuesta(respuesta);
                    Main.contador++;
                    if (respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso <= 0.672) {
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 1 && Main.progreso > 0.672){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso < 0.896){
                        Main.incrementarProgreso();
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 2 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaCasaLadrillo.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(respuesta && Main.preguntaCasaLadrillo == 3 && Main.progreso == 0.896){
                        Parent cuartoRoot = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) button.getScene().getWindow();
                        Scene scene = new Scene(cuartoRoot);
                        stage.setScene(scene);
                        stage.show();
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() > 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaCasaPaja.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }else if(!respuesta && Main.juegoMain.getJugador().getVida() == 1){
                        Main.preguntaCasaLadrillo = 0;
                        Main.juegoMain.actualizarVida(-1);
                        Parent loader = FXMLLoader.load(getClass().getResource("/views/VistaFinal.fxml"));
                        Stage stage = (Stage) btnRespuesta1.getScene().getWindow();
                        Scene scene = new Scene(loader);
                        stage.setScene(scene); 
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error en la seleccion de respuestas: " + e.getMessage());
        }
    }

    
}
