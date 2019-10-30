/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField TfNom;
    @FXML
    private TextField TfAge;
    @FXML
    private TextField TfNom1;
    @FXML
    private TextField TfAge1;
    @FXML
    private TextField TfAge2;
    @FXML
    private TextField TfAge21;
    @FXML
    private TextField TfAge22;
    @FXML
    private TextField TfAge23;
    @FXML
    private TextField TfNom11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        Annonce p=new Annonce();
        p.setDescriptionAnnonce(TfNom.getText());
        p.setIdAnnoce(Integer.valueOf(TfAge.getText()));
        
        
    }
    
}
