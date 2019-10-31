/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Bill;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class FactureFXMLController implements Initializable {

    @FXML
    private TableColumn<Bill, String> datebillc;
    @FXML
    private TableColumn<Bill, String> pricebillc;
    @FXML
    private TableColumn<Bill, String> statebillc;
    @FXML
    private Label labelcompanyname;
    @FXML
    private Label labelusername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // labelusername.setText(tfnom.getValue());
       
        
    }    

    @FXML
    private void printbill(ActionEvent event) {
        
    
    }

    @FXML
    private void userdelivery(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutDeliveryUser.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            //stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
    }
    }
    
}
