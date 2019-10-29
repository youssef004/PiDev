/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.java.swing.plaf.windows.resources.windows;
import entities.Plant;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef
 */

public class ConfirmerPartageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Facebook facebook;
    public Plant p;

    @FXML
    private void ConfirmerPatage(ActionEvent event) throws IOException {
        
      
        facebook = new FacebookFactory().getInstance();// sna3na instance ta3 fb

        facebook.setOAuthAppId("", "");//ysta3mlouh fazat connexion fb 
        String accessTokenString = "EAAIAKZCwslSIBAMARIMX3wMdNZCZB8pORcydz5GZAJbmgCGrMtWSJVZAmPfdt5ZASZAZCRJzkYElaaoCP37ggcXoKlQGedZC2W348H050IZCJMeCI6oIyIJUpKwyivytsE99CCPWQbTHJhGa6JFo3tYdZCOgd89Vn19kgtGfrvJ5DpbDAZDZD";
        AccessToken accessToken = new AccessToken(accessTokenString);
        //set access token
        facebook.setOAuthAccessToken(accessToken);
        //ResponseList<Account> accounts = facebook.getAccounts();
        // Account pageAccount = accounts.get(0);
        try {
            facebook.postStatusMessage("La plante " + p.getNamePlant() + " est avec quantite " + p.getQuantityPlant()
                    + " et de categorie " + p.getCategoryPlant() + " est disponible");
        } catch (FacebookException fe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deja partager.");
            alert.setHeaderText(null);
            alert.setContentText("La plant  " + p.getNamePlant() + " a été deja partager.");
            alert.showAndWait();

        }
       
    }

    @FXML
    private void refuserPartage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RechercherPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
