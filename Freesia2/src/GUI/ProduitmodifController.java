/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Cart;
import Entity.Plants;
import Service.ServiceChariot;
import Service.ServicePlants;
import java.io.IOException;
import java.net.URL;
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
 * @author user
 */
public class ProduitmodifController implements Initializable {

    @FXML
    private TextField tfnompdtmodif;
    @FXML
    private TextField tfQuantityPdt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modif(ActionEvent event) throws IOException, ParseException {
       
        /* ServiceChariot sc = new ServiceChariot();  
        Cart c = tfnompdtmodif.getSelectionModel().getSelectedItem();
         //sc.setNamePlant(tfnompdtmodif.getText());
         //sc.setQuantityPlant(Integer.valueOf(tfQuantityPdt.getText()));
         //ServiceChariot sc;
         sc = new ServiceChariot();
         sc.modifierProduitCart(sc.getNamePlant(),sc.getQuantityPlant());*/
        
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/panieFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
         
        
    }

    @FXML
    private void retour_modif(ActionEvent event) throws IOException {
             Parent root = FXMLLoader.load(getClass().getResource("../GUI/panieFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    
    }
    
}
