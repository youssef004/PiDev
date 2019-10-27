/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServicePromotion;
import entities.Promotion;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class ListePromotionController implements Initializable {

    @FXML
    private Label tflistpromotion;
    @FXML
    private TableView<Promotion> listePromotion;
    @FXML
    private TableColumn<Promotion, Integer> comumnid;
    @FXML
    private TableColumn<Promotion, Integer> columnpercentage;
    @FXML
    private TableColumn<Promotion, Date> columnstartdate;
    @FXML
    private TableColumn<Promotion, Date> columnenddate;
    @FXML
    private TableColumn<Promotion, String> columnstate;
    @FXML
    private TableColumn<Promotion, String> columnperiod;
    @FXML
    private TableColumn<Promotion, String> columndescription;
    private ObservableList<Promotion> promotionsData = FXCollections.observableArrayList();
    List<Promotion> promotions;
    @FXML
    private Label nombrepromotion;
    @FXML
    private TextField tfiddelete;
    @FXML
    private ComboBox<String> combosearchpromotion;
    ObservableList<String> listSearchPromotion = FXCollections.observableArrayList("ID", "Percentage","State","Period");
    @FXML
    private Button tfreturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Promotion> promotions = new ArrayList<Promotion>();
        ServicePromotion servicePromotion = new ServicePromotion();
        try {
            System.out.println(servicePromotion.readAll().size());
            promotions = servicePromotion.readAll();
            nombrepromotion.setText(String.valueOf(promotions.size()));

            /////*******//////
            comumnid.setCellValueFactory(new PropertyValueFactory<>("IdPromotion"));
            columnpercentage.setCellValueFactory(new PropertyValueFactory<>("percentagePromotion"));
            columnstartdate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
            columnenddate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
            columnstate.setCellValueFactory(new PropertyValueFactory<>("StatePromotion"));
            columnperiod.setCellValueFactory(new PropertyValueFactory<>("Period"));
            columndescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionPromotion"));

            /////*******//////
            promotionsData.addAll(promotions);
            listePromotion.setItems(promotionsData);
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        combosearchpromotion.setItems(listSearchPromotion);
        promotions = new ArrayList<Promotion>();

    }

    @FXML
    private void supprimerPromotion(ActionEvent event) {

        Promotion p = new Promotion();
        p.setIdPromotion(Integer.valueOf(tfiddelete.getText()));
        ServicePromotion sp = new ServicePromotion();
        try {
            sp.supprimerPromotion(p.getIdPromotion());
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rechercherPromotion(ActionEvent event) {
        
    }

    @FXML
    private void returnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPromotionFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
    }}

    @FXML
    private void reafficherlistepromotion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListePromotion.fxml"));
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
