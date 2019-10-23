/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class OUSSFXMLMain extends Application {
    private Connection conn = ConnexionBD.getInstanceConnexionBD().getConnection();

    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("ModiferSupprimerAnnonce.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
