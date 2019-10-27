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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.AccessibleRole;
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
import javafx.scene.control.cell.TextFieldTableCell;
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
    private int Id = NULL;
    /**
     * Initializes the controller class.
     */
    private ObservableList<Cart>data = FXCollections.observableArrayList();
    List<Cart> st = new ArrayList<>();
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
       tf_name.setCellFactory(TextFieldTableCell.forTableColumn());
       initColumns();
       loadData();
    }    
    private void initColumns() {
        //CId.setCellValueFactory(new PropertyValueFactory<>("IdAnnoce"));
        tf_Idplant.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tfType.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
        tf_categorie.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_Description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
    }
    private void loadData() {
        ObservableList<Plants> data = null;
        try {
            data = FXCollections.observableArrayList(new ServicePlants().listerPlant());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tftablePlants.setItems(data);
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
    private void gotosupp(KeyEvent event) throws IOException, SQLException {
     
          ServicePlants sa = new ServicePlants();

        Plants p = tftablePlants.getSelectionModel().getSelectedItem();
        
        int Id1 = p.getIdPlant();
        this.Id=Id1;
        System.out.println(Id1);
        
        
   
    }

    @FXML
    private void supp_pdt_cart(ActionEvent event) throws IOException, SQLException {
    
    
        ServicePlants sa = new ServicePlants();

        Plants p = tftablePlants.getSelectionModel().getSelectedItem();
        
       
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer " + p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                 sa.suprrimerProduit(this.Id);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData();
   
    }


    @FXML
    private void gotoFacture(KeyEvent event) {
    } 

  

    @FXML
    private void TotalnbrArticle(MouseEvent event) throws SQLException {
          
         ServicePlants sa = new ServicePlants(); 
        String totale=sa.AfficheTotalProduit();
        tfnbreproduit.setText(totale);
        System.out.println(totale);
    }

    @FXML
    private void supp_pdt_cart1(MouseEvent event) throws SQLException {
       
        ServicePlants sa = new ServicePlants();
        Plants p = tftablePlants.getSelectionModel().getSelectedItem();
        int Id = p.getIdPlant();
        System.out.println(Id);
        sa.suprrimerProduit(Id);
   
    }

    @FXML
    private void supp_prod_chariot(KeyEvent event) {
        
    }

    @FXML
    private void gotoModif_chariot(KeyEvent event) {
    }

    @FXML
    private void modifier_panier(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/Produitmodif.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();  
    }

    @FXML
    private void TotalPrix(MouseEvent event) throws SQLException {
       
      ServicePlants sa = new ServicePlants(); 
      String prix=sa.TotalPrixProduit();
      tftotalprix.setText(prix);
      System.out.println(prix);
   
    }
      
        }

   
