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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import utils.ConnextionBD;

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
    
    public void setIdm(String nom){
        tfidmodif.setText(nom);
    }
    public void setDescm(String nom){
        tfdescriptionmodif.setText(nom);
    }
    public void setStatem(String nom){
        tfstatemodif.setText(nom);
    }
   
   

    /**
     * Initializes the controller class.
     */
    public ModifierLivraisonController(){
        
    }
   public Delivery v;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] possibleWords = {"checked", "transmited", "in progress", "arrived"};
        TextFields.bindAutoCompletion(tfstatemodif, possibleWords);
        /*Platform.runLater(() -> {
       Delivery d = new Delivery();
            System.out.println(d);
           tfdescriptionmodif.setText(d.getDescriptionDelivery());
            tfstatemodif.setText(d.getStateDelivery());
            tfidmodif.setText(String.valueOf(d.getIdDelivery()));
            
    
                });*/
    ////
    Platform.runLater(() -> {
       Delivery d = new Delivery();
            System.out.println(d);
           tfdescriptionmodif.setText(d.getDescriptionDelivery());
            tfstatemodif.setText(d.getStateDelivery());
            tfidmodif.setText(String.valueOf(d.getIdDelivery()));
            
    
                });
    
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
    public void setDelivery(Delivery v1){
        this.v=v1;
        
    }
    }
    

