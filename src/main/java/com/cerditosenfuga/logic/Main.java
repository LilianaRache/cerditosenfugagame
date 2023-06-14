package com.cerditosenfuga.logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Grupo9
 */
public class Main extends Application{

    public static void main(String[] args){
        System.out.println("¡Cerditos En Fuga..!");
        launch(args);
    }
    
    /**
     * 
     * @param primaryStage
     * @throws Exception 
     * Metodo carga vistaInicio
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/VistaInicio.fxml"));
        primaryStage.setTitle("Cerdito En Fuga");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
