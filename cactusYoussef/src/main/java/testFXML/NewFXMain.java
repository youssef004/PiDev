/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testFXML;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.ConnexionBD;

/**
 *
 * @author Youssef
 */
public class NewFXMain extends Application {
      private  Connection myconn0= ConnexionBD.getInstanceConnexionBD().getConnection();

    @Override
    public void start(Stage primaryStage) throws Exception {
        
          Parent root;
            root = FXMLLoader.load(getClass().getResource("/GestionPlant.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}       

    
   
  

   
        