/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceDelivery;
import entities.Delivery;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.controlsfx.control.textfield.TextFields;
import utils.ConnextionBD;
import java.sql.Connection;

 


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
        String[] possibleWords = {"checked", "transmited", "in progress", "arrived"};
        TextFields.bindAutoCompletion(tfstatelivraison, possibleWords);

    }

    @FXML
    private void ajouterLivraison(ActionEvent event) throws SQLException {
        Delivery v = new Delivery();
        v.setIdDelivery(Integer.valueOf(tfidlivraison.getText()));
        v.setDateDelivery(Date.valueOf(tfdatelivraison.getValue()));
        v.setDescriptionDelivery(tfdescriptionlivraison.getText());
        v.setStateDelivery(tfstatelivraison.getText());
        ServiceDelivery sv = new ServiceDelivery();
        sv.ajouterDelivery(v);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delivery registered successfully.");
        alert.setHeaderText(null);
        alert.setContentText("delivery  " + v.getIdDelivery() + " is created.");
        alert.showAndWait();
        if (tfdescriptionlivraison.getText().length() == 0 || tfstatelivraison.getText().length() == 0) {
            alert.setTitle("please fill in this field!");
            alert.setHeaderText("WARNING !");
            alert.setContentText("Empty field!");
            alert.showAndWait();
        } 
        else {
            alert.setTitle("Delivery added successfully.");
            alert.setHeaderText("Alert");
            alert.setContentText("Delivery added");
            alert.showAndWait();
        }
    }

    @FXML
    private void deleteLivraison(ActionEvent event) {
        Delivery p = new Delivery();
        p.setIdDelivery(Integer.valueOf(tfidlivraison.getText()));
        int IdDelivery = p.getIdDelivery();
        ServiceDelivery sv = new ServiceDelivery();
        /*try {
            sv.supprimerDelivery(p.getIdDelivery ());
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);*/

        /**
         * **********************************************************************
         */
        if (IdDelivery == p.getIdDelivery()) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("Deleting Delivery");
            alert.setContentText("Please Confirm Deletion");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    p.setIdDelivery(Integer.valueOf(tfidlivraison.getText()));
                    try {
                        sv.supprimerDelivery(p.getIdDelivery());
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("delivery is successfully deleted.");
                        alert1.setHeaderText(null);
                        alert1.setContentText("delivery number  " + p.getIdDelivery() + " has been deleted.");
                        alert1.showAndWait();
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        if (p.getIdDelivery() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Acune Sélection");
            alert.setHeaderText("no delivery");
            alert.setContentText("Please Select a Delivery!");
            alert.showAndWait();
        }
    }

    @FXML
    private void displayLivraison(ActionEvent event) {
           
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListeLivraison.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("Delivery List");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }

    }

    @FXML
    private void backgestionlivraison(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionLivraison.fxml"));
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
