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

import java.sql.SQLException;

import static java.sql.Types.NULL;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import java.util.ResourceBundle;

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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.mail.Session;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.*;





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
        
        //tf_Idplant.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
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
    private void commanderproduit(ActionEvent event) throws IOException, MessagingException, SQLException {
          
   
                final String fromEmail = "hadhriraya@gmail.com"; //requires valid gmail id
		final String password = "123rayahadhri1995****"; // correct password for gmail id
		final String toEmail = "raya.hadhri@esprit.tn"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
               ServicePlants sa = new ServicePlants(); 
                String totale=sa.AfficheTotalProduit(1);
                tfnbreproduit.setText(totale);
                //System.out.println(totale);
		
	ServiceChariot.sendEmail(session, toEmail,"Votre commande est valider","Le nombre totale des produits commendés est ="+totale);
	 Parent root = FXMLLoader.load(getClass().getResource("/Facture.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();}
    

    @FXML
    private void gotosupp(KeyEvent event) throws IOException, SQLException {
      ServicePlants sa = new ServicePlants();

        Plants p = tftablePlants.getSelectionModel().getSelectedItem();//recuperation des donnees de la base
        int Id=p.getIdPlant();
       
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer " + p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                 sa.suprrimerProduit(Id);

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
        String totale=sa.AfficheTotalProduit(1);
        tfnbreproduit.setText(totale);
        System.out.println(totale);
    }

    @FXML
    private void supp_pdt_cart1(MouseEvent event) throws SQLException {
       ServicePlants sa = new ServicePlants();

        Plants p = tftablePlants.getSelectionModel().getSelectedItem();
        int Id=p.getIdPlant();
       
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer " + p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
             sa.suprrimerProduit(Id);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData(); 
     
    }


    @FXML
    private void gotoModif_chariot(KeyEvent event) {
    }

    @FXML
    private void modifier_panier(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/Produitmodif.fxml"));
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

   
