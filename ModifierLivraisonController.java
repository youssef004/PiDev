/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceDelivery;
import entities.Delivery;
import java.net.URL;
import java.sql.SQLException;
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

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    private TextField tfidmodif;
    @FXML
    private TextField tfdescriptionmodif;
    @FXML
    private TextField tfstatemodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifColumn(ActionEvent event) {
        Delivery v = new Delivery();
         v.setIdDelivery(Integer.valueOf(tfidmodif.getText()));
         v.setDescriptionDelivery(tfdescriptionmodif.getText());
         v.setStateDelivery(tfstatemodif.getText()); 
        
         ServiceDelivery sv;
         sv = new ServiceDelivery ();
        try {
                       sv.modifierDelivery(Integer.valueOf(tfidmodif.getText()), tfdescriptionmodif.getText(), 
                    tfstatemodif.getText());
           
        }catch(SQLException ex){
            Logger.getLogger(ModifierLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returndelivery(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListeLivraison.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");

        }
    }
    }
    

