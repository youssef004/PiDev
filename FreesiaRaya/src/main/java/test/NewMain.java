/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import GUI.*;
import freesia.MyConnexion;
import java.sql.Connection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class NewMain extends Application{
    private  Connection con = MyConnexion.getInstance().getConnection();
    
    

    @Override
    public void start(Stage stage) throws Exception {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/panieFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
      
    }
} 
    

  
    

