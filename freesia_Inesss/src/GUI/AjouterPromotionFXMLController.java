/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServicePromotion;
import entities.Promotion;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class AjouterPromotionFXMLController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfpercentage;
    @FXML
    private ComboBox<String> tfstate;
    ObservableList<String> listStatePromotion = FXCollections.observableArrayList("en cours", "finis");
    @FXML
    private TextField tfperiod;
    @FXML
    private DatePicker tfstartdate;
    @FXML
    private DatePicker tfenddate;
    @FXML
    private Label tfsetstate;
    List<Promotion> promotions;
    private Object servicePromotion;
    @FXML
    private ImageView image2;
    @FXML
    private Button tfpromotiontest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfstate.setItems(listStatePromotion);
        promotions = new ArrayList<Promotion>();
        //Promotion promotion = new Promotion();
        //ServicePromotion servicePromotion = new ServicePromotion();
    }

    @FXML
    private void ajouterPromotion(ActionEvent event) throws SQLException {
        Promotion p = new Promotion();
        //p.setIdPromotion(Integer.valueOf(tfid.getText()));
        p.setPercentagePromotion(Integer.valueOf(tfpercentage.getText()));
        p.setDescriptionPromotion(tfdescription.getText());
        p.setStartDate(Date.valueOf(tfstartdate.getValue()));
        p.setEndDate(Date.valueOf(tfenddate.getValue()));
         p.setPeriod(tfperiod.getText());
        /**
         * ***********ComboBox************
         */

        p.setStatePromotion(tfstate.getValue());
        tfsetstate.setText(tfstate.getValue());
        /**
         * ***********ComboBox************
         */
       

        ServicePromotion sp = new ServicePromotion();
        try {
            sp.ajouterPromotion1(p);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPromotionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherListePromotion(ActionEvent event) {
        /**
         * ***********window1->window2**********
         */
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListePromotion.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            //stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");

        }
        /**
         * ***********window1->window2**********
         */

    }

    @FXML
    private void modifierPromotion(ActionEvent event) throws SQLException {
        /*try {
            Promotion p = new Promotion();
            p.setIdPromotion(Integer.valueOf(tfid.getText()));
            p.setPercentagePromotion(Integer.valueOf(tfpercentage.getText()));
            p.setDescriptionPromotion(tfdescription.getText());
            p.setPeriod(tfperiod.getText());
            p.setStatePromotion(tfstate.getValue());
            p.setStartDate(Date.valueOf(tfstartdate.getValue()));
            p.setEndDate(Date.valueOf(tfenddate.getValue()));
            
            ServicePromotion sp = new ServicePromotion();
            sp.modifierPromotion1(p.getIdPromotion(), p.getDescriptionPromotion(), p.getPercentagePromotion(), p.getStartDate(),
                p.getEndDate(),p.getStatePromotion(),p.getPeriod());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPromotionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        Promotion A = new Promotion();
        int Id = Integer.valueOf(tfid.getText());
        //A.setIdPromotion(Integer.valueOf(tfid.getText()));
        A.setPercentagePromotion(Integer.valueOf(tfpercentage.getText()));
        A.setDescriptionPromotion(tfdescription.getText());
        //A.setPeriod(tfperiod.getText());
        /**
         * ***********ComboBox************
         */

        //A.setStatePromotion(tfstate.getValue());
        //tfsetstate.setText(tfstate.getValue());
        /**
         * ***********ComboBox************
         */

       // A.setStartDate(Date.valueOf(tfstartdate.getValue()));
        //A.setEndDate(Date.valueOf(tfenddate.getValue()));
        ServicePromotion sp = new ServicePromotion();
        System.out.println(Id);
        sp.modifierPromotion1(Integer.valueOf(tfid.getText()),tfdescription.getText(),Integer.valueOf(tfpercentage.getText()),tfperiod.getText());
    }

    @FXML
    private void showPromotion(KeyEvent event) throws SQLException {
        ServicePromotion sp = new ServicePromotion();

        Promotion p = new Promotion();
        int Id = Integer.valueOf(tfid.getText());
        p = sp.getPromotionById(Id);
        tfdescription.setText(p.getDescriptionPromotion());
        //tfpercentage.setText(Integer.valueOf(tfpercentage.getValue()));
       int Percentage=Integer.valueOf(tfid.getText());
        //tfstartdate.setText(p.getStartDate());
        tfsetstate.setText(p.getStatePromotion());
        tfperiod.setText(p.getPeriod());
        tfstate.setValue(p.getStatePromotion());
    }

    @FXML
    private void showlisteprixpromotion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CalculPromotion.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            //stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }
    }

    @FXML
    private void bajouterPromotion(ActionEvent event) {
    }

}
