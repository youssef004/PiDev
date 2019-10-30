/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import Service.ServiceAnnonce;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class AnnonceMenuController implements Initializable {

    @FXML
    private AnchorPane DateAnnonce;
    @FXML
    private TextField titreAnnonce;
    @FXML
    private TextArea Description;

    @FXML
    private DatePicker tfDate;
    @FXML
    private Label ifPicture;
    @FXML
    private Label verif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add_annonce(ActionEvent event) throws SQLException, IOException {

        if (titreAnnonce.getText().equals("")) {
            verif.setText("right a Titre");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (Description.getText().equals("")) {
            verif.setText("right a Description");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (ifPicture.getText().equals("")) {
            verif.setText("Brows a picture");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else {
            Annonce A = new Annonce();
            A.setDateAnnonce(Date.valueOf(tfDate.getValue()));
            A.setDescriptionAnnonce(Description.getText());
            A.setTitreAnnoce(titreAnnonce.getText());
            A.setPicture(ifPicture.getText());
            A.setIdAnnoce(NULL);
            ServiceAnnonce AN = new ServiceAnnonce();
            AN.ajouterAnnonce(A);
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }

        /*Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();*/
    }

    @FXML
    private void gotoaffiche(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void BrowsPicture(ActionEvent event) {
        Stage primary = new Stage();
        //primary.isAlwaysOnTop();
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Selectionner Une Image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = filechooser.showOpenDialog(primary);
        String path = "C:\\wamp64\\www";
        ifPicture.setText(file.getName());
        if (file != null) {
            try {
                Files.copy(file.toPath(), new File(path + "\\" + file.getName()).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void refrechListe(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AnnonceMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
