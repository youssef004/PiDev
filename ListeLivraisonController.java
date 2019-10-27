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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class ListeLivraisonController implements Initializable {

    @FXML
    private TableColumn<Delivery, Integer> cid;
    @FXML
    private TableColumn<Delivery, String> cdate;
    @FXML
    private TableColumn<Delivery, String> cdiscription;
    @FXML
    private TableColumn<Delivery, String> cstate;
    private ObservableList<Delivery> deliveriesData = FXCollections.observableArrayList();
    List<Delivery> deliveries;
    @FXML
    private TableView<Delivery> listelivraison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Delivery> deliveries = new ArrayList<Delivery>();
        ServiceDelivery serviceDelivery = new ServiceDelivery();
        
        try {
            //System.out.println(serviceDelivery.readAll().size());
            //deliveries = serviceDelivery.readAll();
            //nombrepromotion.setText(String.valueOf(promotions.size()));

            /////*******//////
            deliveries=serviceDelivery.readAllDelivery();
            deliveriesData.addAll(deliveries);
        } catch (SQLException ex) {
            Logger.getLogger(ListeLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
            cid.setCellValueFactory(new PropertyValueFactory<>("IdDelivery"));
            cdate.setCellValueFactory(new PropertyValueFactory<>("DateDelivery"));
            cdiscription.setCellValueFactory(new PropertyValueFactory<>("DescriptionDelivery"));
            cstate.setCellValueFactory(new PropertyValueFactory<>("StateDelivery"));
            listelivraison.setItems(deliveriesData);
            
    }
            
        

    @FXML
    private void afficheLivraison(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifierLivraison.fxml"));
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

    @FXML
    private void retourner(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterLivraison.fxml"));
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
