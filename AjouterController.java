/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import java.net.URL;
<<<<<<< HEAD
import java.nio.file.Files;
import java.sql.Connection;
import static java.sql.Types.NULL;
=======
import java.sql.SQLException;
>>>>>>> f4766cba4c60149a51e7389d848e3e8e4e410f97
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.activation.DataSource;
import service.ServicePlant;
=======
>>>>>>> f4766cba4c60149a51e7389d848e3e8e4e410f97

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField TfNom;
    @FXML
    private TextField TfAge;
    @FXML
    private TextField TfNom1;
    @FXML
    private TextField TfAge1;
    @FXML
    private TextField TfAge2;
    @FXML
    private TextField TfAge21;
    @FXML
    private TextField TfAge22;
    @FXML
    private TextField TfAge23;
    @FXML
<<<<<<< HEAD
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
    private Text verif_price;
    @FXML
    private Text verif_name1;
    @FXML
    private Text verif_type;
    @FXML
    private Text verif_category;
    @FXML
    private Text verif_quantity;
    @FXML
    private Text verif_picture;
=======
    private TextField TfNom11;
>>>>>>> f4766cba4c60149a51e7389d848e3e8e4e410f97

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
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
=======
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        Annonce p=new Annonce();
        p.setDescriptionAnnonce(TfNom.getText());
        p.setIdAnnoce(Integer.valueOf(TfAge.getText()));
        
        
>>>>>>> f4766cba4c60149a51e7389d848e3e8e4e410f97
    }

}
