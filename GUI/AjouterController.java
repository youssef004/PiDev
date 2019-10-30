/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import static java.sql.Types.NULL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.activation.DataSource;
import service.ServicePlant;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AjouterController implements Initializable {

    @FXML
    private AnchorPane tf_display;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_type;
    @FXML
    private TextField tf_category;
    @FXML
    private Spinner<Integer> tf_quantity;
    @FXML
    private TextField tf_price;
    @FXML
    private TextArea tf_description;
    @FXML
    private Button ConfirmerAjouterPlant;
    @FXML
    private Button clear_ajouter_plant;
    @FXML
    private Button tf_photo_ajou;
    @FXML
    private Text tf_Picture;
    @FXML
    private Button RetourGestionPlant;
    public Plant p;
    public Connection c;
    @FXML
    private Text verif_name1;
    @FXML
    private Label label_test;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initSpinner();
    }

    @FXML
    private void ConfirmerAjouterPlant(ActionEvent event) {

        System.out.println("user");
        /*if (tf_name.getText().length() == 0 || tf_type.getText().length() == 0 || tf_description.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("veuillez remplir!!");
            alert.setHeaderText("WARNING !");
            alert.setContentText("some field are empty !!");
            alert.showAndWait(); 
            
            else if (true) {

}
             (tf_name.getText().isEmpty()){
            verif_name.setText("veuillez saisir le nom");
        }
        else if (tf_type.getText().isEmpty()) {
            verif_type.setText("veuillez saisir le type");
        }
        else if (tf_quantity.getValue()==NULL) {
            
             verif_quantity.setText("veuillez saisir la quantité");
        }
        else if (tf_Picture.getText().isEmpty()) {
            verif_picture.setText("veuillez rejoindre une photo");
            
        } 
        
            
        }*/
             Plant p = new Plant();

        p.setNamePlant(tf_name.getText());
        p.setTypePlant(tf_type.getText());

        tf_quantity.setEditable(true);
        p.setQuantityPlant(tf_quantity.getValue());

        p.setCategoryPlant(tf_category.getText());
        p.setPricePlant(Integer.valueOf(tf_price.getText()));
        p.setPicturePlant(tf_Picture.getText());
        p.setDescriptionPlant(tf_description.getText());
        p.setIdPlant(NULL);

        ServicePlant PS = null;
        PS = new ServicePlant();
        PS.ajouterPlant(p);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Le produit " + p.getNamePlant() + " a été créé.");
        alert.showAndWait();
       if (tf_name.getText().length() == 0 || tf_type.getText().length() == 0 || tf_description.getText().length() == 0) {

            alert.setTitle("veuillez remplir!!");
            alert.setHeaderText("WARNING !");
            alert.setContentText("some field are empty !!");
            alert.showAndWait();
        } else {

            alert.setTitle("veuillez remplir!!");
            alert.setHeaderText("Alert !");
            alert.setContentText("Plant has been added!");
            alert.showAndWait();
        }

      
       
    }

    @FXML
    private void clear_ajouter_plant(ActionEvent event) {
        tf_name.clear();
        tf_type.clear();
        tf_category.clear();
        tf_price.clear();
        //  tf_quantity.clear;
        tf_description.clear();
        System.out.println("tests");
    }

    @FXML
    private void tf__attach_Picture(ActionEvent event) {
        Stage primary = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selectionner une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(primary);
        String path = "C:\\wamp64\\www";
        tf_Picture.setText(file.getName());
        if (file != null) {
            try {
                Files.copy(file.toPath(), new File(path + "\\" + file.getName()).toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void RetourGestionPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void initSpinner() {
        tf_quantity.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200));
    }

}
