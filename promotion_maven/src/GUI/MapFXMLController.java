/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
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
public class MapFXMLController implements Initializable {

    @FXML
    private TextField fromtextfield;
    @FXML
    private TextField totextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void totfidaction(ActionEvent event) {
        
    }

    @FXML
    private void backinmap(ActionEvent event) {
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
