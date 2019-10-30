/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceBilling;
import entities.Bill;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class AjoutDeliveryUserController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfproduct;
    @FXML
    private TextField tffraislivraison;
    @FXML
    private TextField tftotal;
    @FXML
    private TextField tfmodedelivraison;
    @FXML
    private Label labelNotificationDelivery;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backUser(ActionEvent event) {     //retour vers la page gestion produit
        /*try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionLivraison.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("Gestion Livraison");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        
    }*/
    }

    @FXML
    private void applyUser(ActionEvent event) {
        Bill b = new Bill();
        /*b.setFirstName(tfnom.getText());
        b.setLastName(tfprenom.getText());
        b.setNumber(tfnumber);
        b.setQuantite(tfproduct);
        b.setShipingCost(tffraislivraison);
        b.setTotalprica(tftotal);
        b.setModeLivraison(tfmodedelivraison);*/
     ServiceBilling sb = new ServiceBilling();
        try {
            sb.ajouterBill(b);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutDeliveryUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FactureFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }

    }
}
