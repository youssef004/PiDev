/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import GUI.ReclamationController;
import entities.reclamation;
import entities.user;
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
import service.MyConnection;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class StateController implements Initializable {

    @FXML
    private TextField tfIdU;
    @FXML
    private TextField tfStateuser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void stateuser(ActionEvent event) {
            user u = new user();
         u.setCin(Integer.valueOf(tfIdU.getText()));
         u.setState(tfStateuser.getText());
        
         MyConnection mc;
        try {
            mc = new MyConnection();
            mc.modifierState(u.getCin(),u.getState());
            
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Demande_aj.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
