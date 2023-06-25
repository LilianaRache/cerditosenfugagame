/* 
controlador creado por DIEGO BASANTE

 */
package com.cerditosenfuga.controller;

import com.cerditosenfuga.logic.Main;
import com.cerditosenfuga.models.Jugador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public static Jugador jugadorActual;
    
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
            Nombre = outputName.getText();
            if (Nombre.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("validacion");
                alert.setHeaderText(null);
                alert.setContentText("por favor introdusca su nombre");
                alert.showAndWait();

            } else {
                Parent tercerRoot = FXMLLoader.load(getClass().getResource("/views/VistaMenu.fxml"));
                jugadorActual = new Jugador(Nombre, 3, 0);
                Main.juegoMain.setJugador(jugadorActual);
                System.out.println("Este es el jugador Actual - Vista Inicio: "+ jugadorActual.getNombre());
                Stage stage = (Stage) btnPlay.getScene().getWindow();
                Scene scene = new Scene(tercerRoot);
                stage.setScene(scene);

            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error:  " + e.getMessage());
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

    }

}
