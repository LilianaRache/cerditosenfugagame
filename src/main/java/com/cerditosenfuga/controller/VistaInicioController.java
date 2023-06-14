/* 
controlador creado por DIEGO BASANTE

 */
package com.cerditosenfuga.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * LA SIGUIENTE CLASE CREA LA FUNCIONALIDAD DE LA INTERFAZ VistaInicio.fxml
 *
 */
public class VistaInicioController implements Initializable {

    private String Nombre;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnExit;
    @FXML
    private TextField outputName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    /**
     * handleButton1Click crea la funcionalidad del boton play
     */
    private void handleButton1Click(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VistaMenu.fxml"));
            Parent root = loader.load();
            VistaMenuController controllerVistaMenu = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.show();
            Stage myStage = (Stage) this.btnPlay.getScene().getWindow();

        } catch (IOException ex) {
            Logger.getLogger(VistaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    /**
     * handleButton2Click crea la funcionalidad del boton Exit
     */
    private void handleButton2Click(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    /**
     * handleButtonClick sirve para guardar el nombre que ingrese el usuario
     */
    private void handleButtonClick(ActionEvent event) {

        Nombre = outputName.getText();
        System.out.println(Nombre);
    }

}
