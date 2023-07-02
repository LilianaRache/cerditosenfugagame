package com.cerditosenfuga.logic;

import com.cerditosenfuga.models.Juego;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Grupo9
 */
public class Main extends Application {
    
    public static Juego juegoMain = new Juego();
    public static double progreso;
    public static int contador = 0;
    public static String enfoqueCasaMadera = "adivinanzas";
    public static ArrayList<Integer> preguntasConseguidasCasaLadrillo = new ArrayList<Integer>();
    public static int preguntaCasaLadrillo = 0;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception Metodo carga vistaInicio
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/VistaLoading.fxml"));
        primaryStage.setTitle("Cerdito En Fuga");
        Image icono = new Image("/imagens/Icono.jpg");
        primaryStage.getIcons().add(icono);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        /*
        creo la validacion para que despues de un tiempo de ejecutado la vistaloading 
        cambie a vista inicio
         */
        Timeline timeline = new Timeline();

        KeyFrame keyframe = new KeyFrame(Duration.seconds(2.8), event -> {
            try {
                Parent secondroot = FXMLLoader.load(getClass().getResource("/views/VistaInicio.fxml"));
                primaryStage.setScene(new Scene(secondroot));

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        timeline.getKeyFrames().add(keyframe);
        timeline.play();

    }
    
    
    /**
     * Metodo para incrementar el progreso
     */
 
     public static double incrementarProgreso() {
        try {
            progreso += 0.112;
        } catch (Exception e) {
            System.err.println("Ocurrió un error cuando incrementa el progreso" + e.getMessage());
        }
             return progreso;
    }
    
    
}
