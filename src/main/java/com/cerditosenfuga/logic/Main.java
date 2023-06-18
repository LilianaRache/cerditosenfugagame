package com.cerditosenfuga.logic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Grupo9
 */
public class Main extends Application {

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
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        /*
        creo la validacion para que despues de un tiempo de ejecutado la vistaloading 
        cambie a vista inicio
         */
        Timeline timeline = new Timeline();

        KeyFrame keyframe = new KeyFrame(Duration.seconds(5), event -> {
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
}
