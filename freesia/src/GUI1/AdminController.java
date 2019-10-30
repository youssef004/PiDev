/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import GUI.ReclamationController;
import entities.Admin;
import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.GestionAdmin;
import service.MyConnection;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class AdminController implements Initializable {

    @FXML
    private TextField tfCinAdmin;
    @FXML
    private TextField tfFirstNameAdmin;
    @FXML
    private TextField tfLastNameAdmin;
    @FXML
    private TextField tfEmailAdmin;
    @FXML
    private TextField tfPwdAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscrireAdmin(ActionEvent event) {
            Admin a = new Admin();
            a.setCinAdmin(Integer.valueOf(tfCinAdmin.getText()));
            a.setFirstNameAdmin(tfFirstNameAdmin.getText());
            a.setLasttNameAdmin(tfLastNameAdmin.getText());
            a.setEmailAdmin(tfEmailAdmin.getText());
            a.setPwdAdmin(tfPwdAdmin.getText());
            GestionAdmin ga = null;
        try {
            ga = new GestionAdmin();
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
            ga.ajouterAdmin(a);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Prem_inter_Admin.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    
        
    }
   
}
