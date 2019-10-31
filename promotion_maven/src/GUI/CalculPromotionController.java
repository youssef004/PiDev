/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServicePromotion;
import entities.Promotion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class CalculPromotionController implements Initializable {
    
    @FXML
    private TextField tfidc;
    //@FXML
    //private TextField tfprixc;
    @FXML
    private TextField tfpromotionc;
    @FXML
    //private TextField tfprixfinal;
    //@FXML
    private TableView<Promotion> tftablec;
    @FXML
    private TableColumn<Promotion, Integer> testid;
    //private TableColumn<Promotion, String> nametest;
    //private TableColumn<Promotion, Integer> pricetest;
    @FXML
    private TableColumn<Promotion, Integer> promotiontest;
    private ObservableList<Promotion> promotionsData = FXCollections.observableArrayList();
    List<Promotion> promotions;
    @FXML
    private TextField tfprixc;
    @FXML
    private Label tfprixfinal;
    //@FXML
    //private TextField setprice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Promotion> promotions = new ArrayList<Promotion>();
        ServicePromotion servicePromotion = new ServicePromotion();
        try {
            System.out.println(servicePromotion.readAll().size());
            promotions = servicePromotion.readAll();

            /////*******//////
            testid.setCellValueFactory(new PropertyValueFactory<>("IdPromotion"));
            //nametest.setCellValueFactory(new PropertyValueFactory<>("namePlant"));
            //pricetest.setCellValueFactory(new PropertyValueFactory<>("price"));
            promotiontest.setCellValueFactory(new PropertyValueFactory<>("percentagePromotion"));
            //finalpricetest.setCellValueFactory(new PropertyValueFactory<>(""));
            
            /////*******//////
            promotionsData.addAll(promotions);
            tftablec.setItems(promotionsData);
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void calculerprixpromotion(ActionEvent event) throws SQLException {
        Promotion p = new Promotion();
       float x;
        //int Id = Integer.valueOf(tfidc.getText());
       // p.setIdPromotion(Integer.valueOf(tfidc.getText()));
        //p.setPercentagePromotion(Integer.valueOf(promotiontest.getText()));
        //p.setPricePlant(Integer.valueOf(setprice.getText()));
        
        ServicePromotion sp = new ServicePromotion();
        x=sp.calculateP();
        float prix=Float.valueOf(tfprixc.getText());
       int promotion=Integer.valueOf(tfpromotionc.getText());
       //Float px=Float.parseFloat(prix);
        tfprixfinal.setText(""+((prix*promotion)/100));
        //tfprixfinal.setText("YOUR PRICE IS"+ x);
        
        
        
    }

    @FXML
    private void cancellisteprixpromotion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPromotionFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("CalculPromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }
    }

    private void afficherlisteprixpromotion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CalculPromotion.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            //stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }
    }

    @FXML
    private void getpricefinalcalcul(MouseEvent event) throws SQLException {
        ServicePromotion sp = new ServicePromotion();
      // float price=sp.calculateP();
        //float sp.calculateP() = Integer.valueOf(tfprixc.setText());
       // System.out.println(price);
       //tfprixc.setText(""+sp.calculateP());
      
    }

    @FXML
    private void afff(KeyEvent event) throws SQLException {
       Promotion p = tftablec.getSelectionModel().getSelectedItem();
        ServicePromotion sp = new ServicePromotion();
        tfprixc.setText(""+sp.calculateP());
        tfidc.setText(""+p.getIdPromotion());
        tfpromotionc.setText(""+p.getPercentagePromotion());
    }

}
