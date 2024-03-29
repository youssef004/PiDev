/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ServicePlant;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AfficherPlantRechercherController implements Initializable {

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
    private Button ModifierPhoto;
    @FXML
    private Button ModifierPlant;
    @FXML
    private Button PartagerPlant;
    @FXML
    private Button RetourRechercherPlant;
    public static AfficherPlantRechercherController thisController;

    public Plant p;
    @FXML
    private Text tf_Picture;
    @FXML
    private ImageView tf_image_view;
    private Facebook facebook;

    /**
     * Initializes the controller class.
     */
    public AfficherPlantRechercherController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            initSpinner();
            System.out.println(p);
            tf_name.setText(p.getNamePlant());
            tf_category.setText(p.getCategoryPlant());
            tf_price.setText(String.valueOf(p.getPricePlant()));
            tf_quantity.getValueFactory().setValue(p.getQuantityPlant());
            tf_description.setText(p.getDescriptionPlant());
            tf_type.setText(p.getTypePlant());
            FileInputStream input;
            try {
                input = new FileInputStream("C:\\\\wamp64\\\\www\\\\" + p.getPicturePlant() + "");
                Image image = new Image(input);
                tf_image_view.setImage(image);
            } catch (FileNotFoundException ex) {
                System.out.println("error");
            }

        });

    }

    @FXML
    private void ModifierPhoto(ActionEvent event) {
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
    private void ModifierPlant(ActionEvent event) throws SQLException, FileNotFoundException {
        Plant pmod = new Plant();
        pmod.setNamePlant(tf_name.getText());
        pmod.setTypePlant(tf_type.getText());

        //tf_quantity.setEditable(true);
        pmod.setQuantityPlant(tf_quantity.getValue());

        pmod.setCategoryPlant(tf_category.getText());
        pmod.setPricePlant(Double.valueOf(tf_price.getText()));
        pmod.setPicturePlant(tf_Picture.getText());
        pmod.setDescriptionPlant(tf_description.getText());
        pmod.setIdPlant(p.getIdPlant());

        ServicePlant PS = null;
        PS = new ServicePlant();
        PS.modifierPlant(pmod);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Le produit " + p.getNamePlant() + " a été créé.");
        alert.showAndWait();

        String title = p.getPicturePlant();
        System.out.println(title);
        FileInputStream input = new FileInputStream("C:\\wamp64\\www\\" + title + "");
        //  Image image = new Image("C:\\wamp64\\www\\" +title+"") {};
        // ImageView view = new ImageView(input);
        Image image = new Image(input);
        ImageView view = new ImageView();
        tf_image_view.setImage(image);
        /* Stage imageShow = new Stage();

        Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().setAll(view);
        root.getChildren().setAll(box);

        imageShow.setTitle("Product Image");
        imageShow.setHeight(500.0);
        imageShow.setWidth(350.0);
        imageShow.centerOnScreen();
        imageShow.setScene(scene);
        imageShow.showAndWait();*/

    }

    @FXML
    private void PartagerPlant(ActionEvent event) throws FacebookException, IOException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Share on Facebook");
        alert.setHeaderText("do you want to share on facebook!");
        alert.setContentText(null);

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");

        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
            facebook = new FacebookFactory().getInstance();

            facebook.setOAuthAppId("", "");//ysta3mlouh fazat connexion fb 
            String accessTokenString = "EAAIAKZCwslSIBAMARIMX3wMdNZCZB8pORcydz5GZAJbmgCGrMtWSJVZAmPfdt5ZASZAZCRJzkYElaaoCP37ggcXoKlQGedZC2W348H050IZCJMeCI6oIyIJUpKwyivytsE99CCPWQbTHJhGa6JFo3tYdZCOgd89Vn19kgtGfrvJ5DpbDAZDZD";
            AccessToken accessToken = new AccessToken(accessTokenString);
            //set access token
            facebook.setOAuthAccessToken(accessToken);
            //ResponseList<Account> accounts = facebook.getAccounts();
            // Account pageAccount = accounts.get(0);
            try {
                facebook.postStatusMessage("La plante " + p.getNamePlant() + " est avec quantite " + p.getQuantityPlant()
                        + " et de categorie " + p.getCategoryPlant() + " est disponible");
            } catch (FacebookException fe) {
                Alert alert2 = new Alert(AlertType.ERROR);
                alert.setTitle("Already share!");
                alert.setHeaderText(null);
                alert.setContentText("The plant  " + p.getNamePlant() + " has already been shared!.");

                alert.showAndWait();

            }
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"

        }

        //////////
        /*
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Share on Facebook");
        alert.setHeaderText(null);
        alert.setContentText("do you want to share on facebook!");

        alert.showAndWait();
        facebook = new FacebookFactory().getInstance();

        facebook.setOAuthAppId("", "");//ysta3mlouh fazat connexion fb 
        String accessTokenString = "EAAIAKZCwslSIBAMARIMX3wMdNZCZB8pORcydz5GZAJbmgCGrMtWSJVZAmPfdt5ZASZAZCRJzkYElaaoCP37ggcXoKlQGedZC2W348H050IZCJMeCI6oIyIJUpKwyivytsE99CCPWQbTHJhGa6JFo3tYdZCOgd89Vn19kgtGfrvJ5DpbDAZDZD";
        AccessToken accessToken = new AccessToken(accessTokenString);
        //set access token
        facebook.setOAuthAccessToken(accessToken);
        //ResponseList<Account> accounts = facebook.getAccounts();
        // Account pageAccount = accounts.get(0);
        try {
            facebook.postStatusMessage("La plante " + p.getNamePlant() + " est avec quantite " + p.getQuantityPlant()
                    + " et de categorie " + p.getCategoryPlant() + " est disponible");
        } catch (FacebookException fe) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Already share!");
            alert.setHeaderText(null);
            alert.setContentText("The plant  " + p.getNamePlant() + " has already been shared!.");
            alert.showAndWait();
        }*/
 /*
        Parent root = FXMLLoader.load(getClass().getResource("ConfirmerPartage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        // ((Node) (event.getSource())).getScene().getWindow().hide();*/
    }

    @FXML
    private void RetourRechercherPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("rechercherPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void ajouterDonner(MouseEvent event) {

    }

    public void setPlant(Plant pl) {
        this.p = pl;
    }

    private void initSpinner() {
        tf_quantity.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200));
    }

}
