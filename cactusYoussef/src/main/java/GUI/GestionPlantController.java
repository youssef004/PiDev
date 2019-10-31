/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class GestionPlantController implements Initializable {

    @FXML
    private Button AjouterPlant;
    @FXML
    private Button RechercherPlant;
    @FXML
    private Button RetourGestionProduit;
    @FXML
    private ImageView background_gestion_plant;
    @FXML
    private Button AfficherStockPlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjouterPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AjouterPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void RechercherPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RechercherPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void RetourGestionProduit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GestionProduit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void AfficherStockPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/EtatStock.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
