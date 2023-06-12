/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cerditosenfuga.logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Main extends Application{

    public static void main(String[] args){
        System.out.println("¡Cerditos En Fuga..!");
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println( getClass().getResource("VistaInicio.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/views/VistaInicio.fxml"));
        primaryStage.setTitle("Cerdito En Fuga");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
