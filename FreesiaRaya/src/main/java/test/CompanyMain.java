/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import GUI.*;
import freesia.MyConnexion;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.Tes;

/**
 *
 * @author user
 */
public class CompanyMain extends Application{
    private Connection con = MyConnexion.getInstance().getConnection();
     @Override
    public void start(Stage stage) throws Exception {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/Compte_company.fxml"));
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

   

  
    

