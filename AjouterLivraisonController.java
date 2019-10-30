/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceDelivery;
import entities.Delivery;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private TextField tfidlivraison;
    @FXML
    private DatePicker tfdatelivraison;
    @FXML
    private TextField tfdescriptionlivraison;
    @FXML
    private TextField tfstatelivraison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterLivraison(ActionEvent event) {
        Delivery v = new Delivery();
        v.setIdDelivery(Integer.valueOf(tfidlivraison.getText()));
        v.setDateDelivery(Date.valueOf(tfdatelivraison.getValue()));
        v.setDescriptionDelivery(tfdescriptionlivraison.getText());
        v.setStateDelivery(tfstatelivraison.getText());
     ServiceDelivery sv = new ServiceDelivery();
        try {
            sv.ajouterDelivery(v);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteLivraison(ActionEvent event) {
         Delivery p = new Delivery ();
        p.setIdDelivery (Integer.valueOf(tfidlivraison.getText()));
        ServiceDelivery  sv = new ServiceDelivery ();
        try {
            sv.supprimerDelivery(p.getIdDelivery ());
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void displayLivraison(ActionEvent event) {
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
