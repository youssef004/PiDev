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
import freesia2.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.management.Query;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PanieFXMLController implements Initializable {

    @FXML
    private TextField tfnbreproduit;
    @FXML
    private TextField tftotalprix;
    @FXML
    private Label verif;
    @FXML
    private TableView<Plants> tftablePlants;
    @FXML
    private TableColumn<Plants, Integer> tf_Idplant;
    @FXML
    private TableColumn<Plants, String> tf_name;
    @FXML
    private TableColumn<Plants, String> tfType;
    @FXML
    private TableColumn<Plants, Integer> tf_quantity;
    @FXML
    private TableColumn<Plants, String> tf_categorie;
    @FXML
    private TableColumn<Plants, String> tf_Description;
    @FXML
    private TableColumn<Plants, Float> tf_price;
    
    /**
     * Initializes the controller class.
     */
    private ObservableList<Plants>data = FXCollections.observableArrayList();
    List<Plants> st = new ArrayList<>();
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServicePlants p = new ServicePlants();
        
        try{
            
            st=p.listerPlant();
            
            data.addAll(st);
            tf_Idplant.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
            tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
            tfType.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
            tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
            tf_categorie.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
            tf_Description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
            tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
            tftablePlants.setItems(data);
             }catch(SQLException ex) {
            Logger.getLogger(PanieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {
            p.findTotalPrix();
        } catch (Exception ex) {
            Logger.getLogger(PanieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

  
    @FXML
    private void commanderproduit(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Facture.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
      
    }

    @FXML
    private void gotosupp(KeyEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Produit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void supp_pdt_cart(ActionEvent event) {
      
    /*Plants p = tftablePlants.getSelectionModel().getSelectedItem();
    ServicePlants s = new ServicePlants();
    int IdPlant = p.getIdPlant();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerPlant(s.getId);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData();
    }*/
    }

    @FXML
    private void ajouterCart(ActionEvent event) {
    }

    @FXML
    private void gotoFacture(KeyEvent event) {
    } 

    @FXML
    private void TotalPrixP(ActionEvent event) {
        
    }

    @FXML
    private void TotalnbrArticle(MouseEvent event) {
        ServicePlants sp = new ServicePlants();
       // sp.findTotalPrix
      //  verif.setText("raya");
       
    }

    @FXML
    private void TotalPrixP(MouseEvent event) {
      /*  ServiceAnnonce sa = new ServiceAnnonce() ;
        Annonce p = liste.getSelectionModel().getSelectedItem();
        int Id = p.getIdAnnoce();
        p=sa.getAnnonceById(Id);
        Ctitre11.setText(p.getTitreAnnoce());
        Cdiscription11.setText(p.getDescriptionAnnonce());
        CPicture11.setText(p.getPicture());
    }
   */
}}