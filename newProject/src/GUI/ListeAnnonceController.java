/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import Service.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class ListeAnnonceController implements Initializable {
    @FXML
    private TableView<Annonce> liste;
    @FXML
    private TableColumn<Annonce, Date> CDate;
    @FXML
    private TableColumn<Annonce, String> CTitre;
    @FXML
    private TableColumn<Annonce, String> CDescription;
    @FXML
    private TableColumn<Annonce, String> CPicture;
    @FXML
    private Button gotoAjouter;
    @FXML
    private Label TestLabel;
    @FXML
    private AnchorPane Delete;
    @FXML
    private Label verif;
    @FXML
    private TextField Cdiscription11;
    @FXML
    private TextField Ctitre11;
    @FXML
    private TextField CPicture11;
    @FXML
    private DatePicker CDate11;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    private int x =NULL ;
    @FXML
    private Label verif1;
    @FXML
    private Label verif11;
    @FXML
    private Label verif111;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
                
                //liste.setEditable(true);
                //CId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                CDescription.setCellFactory(TextFieldTableCell.forTableColumn());
                CDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
                CTitre.setCellFactory(TextFieldTableCell.forTableColumn());
                CPicture.setCellFactory(TextFieldTableCell.forTableColumn());
               initColumns();
               loadData();
    }    

    @FXML
    private void showAnnonce(MouseEvent event) {
        

    }
 
        private void initColumns(){
        //CId.setCellValueFactory(new PropertyValueFactory<>("IdAnnoce"));
        CDescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionAnnonce"));
        CDate.setCellValueFactory(new PropertyValueFactory<>("DateAnnonce"));
        CTitre.setCellValueFactory(new PropertyValueFactory<>("TitreAnnoce"));
        CPicture.setCellValueFactory(new PropertyValueFactory<>("Picture"));


    }
    private void loadData() {
        ObservableList<Annonce> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceAnnonce().listerAnnoce());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        liste.setItems(data);
    }

    @FXML
    private void gotoAjouter(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/AnnonceMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void ModifierAnnonce(MouseEvent event) {
        /*TestLabel.setText("country is empty");
        TestLabel.setStyle("-fx-text-fill: #ff1744");*/
    }

    @FXML
    private void Modifier1Annonce(MouseEvent event) {
        /*TestLabel.setText("modifier 1");
        TestLabel.setStyle("-fx-text-fill: #ff1744");*/
    }

    @FXML
    private void Modifier2Annonce(KeyEvent event) throws IOException, SQLException {
       // String s;
       // s = CDescription.setText();
       // TestLabel.setText(s);
       /* Parent root = FXMLLoader.load(getClass().getResource("../GUI/ModiferSupprimerAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();*/
        ServiceAnnonce sa = new ServiceAnnonce() ;
        
        
       
        Annonce p = liste.getSelectionModel().getSelectedItem();
        int Id = p.getIdAnnoce();
        p=sa.getAnnonceById(Id);
        Ctitre11.setText(p.getTitreAnnoce());
        Cdiscription11.setText(p.getDescriptionAnnonce());
        CPicture11.setText(p.getPicture());
        this.x=Id;
       
    }

    @FXML
    private void refrechListe(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void returnMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void Deletefromtree(ActionEvent event) {
        Annonce p = liste.getSelectionModel().getSelectedItem();
    ServiceAnnonce s = new ServiceAnnonce();
    int Id = p.getIdAnnoce();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+p.getTitreAnnoce());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerAnnonce(Id);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData();
    }

    @FXML
    private void updatefromtree(ActionEvent event) throws SQLException {
        /*//liste.setEditable(true);
         Annonce p = liste.getSelectionModel().getSelectedItem();
         ServiceAnnonce s = new ServiceAnnonce();
        int Id = p.getIdAnnoce();
        //Annonce prod = liste.getSelectionModel().getSelectedItem();
        Date DateAnnonce = p.getDateAnnonce();
        String TitreAnnoce = p.getTitreAnnoce();
        String picture =p.getPicture();
        //CPicture.getText();
       // verif.setText(CPicture.getText());
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier    "+p.getTitreAnnoce());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.modifierAnnonce(p,p.getIdAnnoce());
                
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
          loadData();*/
       /* ServiceAnnonce sa = new ServiceAnnonce() ;
        
        
       
        Annonce p = liste.getSelectionModel().getSelectedItem();
        int Id = p.getIdAnnoce();
        p=sa.getAnnonceById(Id);
        Ctitre11.setText(p.getTitreAnnoce());
        Cdiscription11.setText(p.getDescriptionAnnonce());
        CPicture11.setText(p.getPicture());
        this.x=Id;*/
        
    }

    @FXML
    private void Updatefinal(ActionEvent event) throws SQLException {
        Annonce A =new Annonce();
        A.setDateAnnonce(java.sql.Date.valueOf(CDate11.getValue()));
        A.setPicture(CPicture11.getText());
        A.setDescriptionAnnonce(Cdiscription11.getText());
        A.setTitreAnnoce(Ctitre11.getText());
        ServiceAnnonce AN=new ServiceAnnonce();
        AN.modifierAnnonce(A,this.x);
        this.x=NULL;
    }
}
     
