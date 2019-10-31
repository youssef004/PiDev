/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import static jdk.nashorn.internal.runtime.Debug.id;
import service.ServicePlant;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class RechercherPlantController implements Initializable {

    @FXML
    private TableView<Plant> tf_tree_table;

    @FXML
    private TableColumn<Plant, Integer> tf_id;
    @FXML
    private TableColumn<Plant, String> tf_name;
    @FXML
    private TableColumn<Plant, String> tf_type;
    @FXML
    private TableColumn<Plant, Integer> tf_quantity;
    @FXML
    private TableColumn<Plant, String> tf_category;
    @FXML
    private TableColumn<Plant, Double> tf_price;
    @FXML
    private TableColumn<Plant, String> tf_picture;
    @FXML
    private TableColumn<Plant, String> tf_description;
    @FXML
    private TextField tf_name_recherche;
    Connection c;
    /**
     * Initializes the controller class.
     */
    public Plant p;
    int x1 = NULL;
    @FXML
    private ImageView image_recherche_plant;
    @FXML
    private ImageView background_rechercher_imageview;
    @FXML
    private ImageView icon_affiche_recherche_plant;
    @FXML
    private ImageView icon_retour_recherche_plant;
    @FXML
    private ImageView icon_affiche_recherche_plant1;
    @FXML
    private ImageView icon_affiche_recherche_plant11;
    // static String nom;
    // static int qt;
    @FXML
    private Button green;
    @FXML
    private Button red;
    @FXML
    private Label label_nbr_prod;

    public RechercherPlantController() {

        c = (Connection) ConnexionBD.getInstanceConnexionBD().getConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tf_tree_table.setEditable(true);

        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = null;
        try {
            pl = (ArrayList<Plant>) svp.listerPlant();
        } catch (SQLException ex) {
            System.out.println("error ");
        }
        ObservableList<Plant> data = FXCollections.observableArrayList(pl);
        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("PicturePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
        tf_tree_table.setItems(data);
        //label_nbr_prod.textProperty().bind(Bindings.format("%d lignes", Locale.FRENCH, Bindings.size( tf_tree_table.getData())));
        // label_nbr_prod.textProperty().bind(Bindings.convert(Bindings.size(tf_tree_table));

        //getTableView().getItems().size()
        label_nbr_prod.setText(String.valueOf(pl.size()));
    }

    @FXML
    private void AfficherPlant(ActionEvent event) throws IOException, SQLException {
        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        if (p == null) {
            System.out.println("choose plant");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning ");
            alert.setHeaderText("choose plant");
            alert.setContentText("choose plant");

            alert.showAndWait();
        } else {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/AfficherPlantRechercher.fxml"));
            Scene scene = new Scene(loader.load());
            AfficherPlantRechercherController ct = loader.getController();
            ct.setPlant(p);

            Stage stageAff = new Stage();
            stageAff.setScene(scene);

            stageAff.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        }

    }

    @FXML
    private void RetourGestionPlant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GestionPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void searchPlant(KeyEvent event) throws SQLException {
        String s = tf_name_recherche.getText();
        ObservableList<Plant> data = null;
        data = FXCollections.observableArrayList(new ServicePlant().filtrePlant(s));

        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("PicturePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));

        tf_tree_table.setItems(data);
        //refresh_plant();
    }

    @FXML
    private void SupprimerPlant(ActionEvent event) throws SQLException, IOException {

        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        //////

        //////////
        if (p == null) {

            System.out.println("choisir plant");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("choose plant");
            alert.setHeaderText(null);
            alert.setContentText("please choose the plant to delete !");

            alert.showAndWait();
        } else {

            ServicePlant s = new ServicePlant();
            int IdPlant = p.getIdPlant();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Remove plant..");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete! " + p.getNamePlant());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    s.supprimerPlant(p);
                    Alert alert1 = new Alert(AlertType.INFORMATION);
                    alert1.setTitle("DELETE PLANT");
                    alert1.setHeaderText(null);
                    alert1.setContentText("the plant is remove");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            loadData();
            refresh_plant();

        }
    }

    private void loadData() {
        ObservableList<Plant> data = null;

        try {
            data = FXCollections.observableArrayList(new ServicePlant().listerPlant());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void refresh_plant() throws SQLException {
        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = (ArrayList<Plant>) svp.listerPlant();
        ObservableList<Plant> data = FXCollections.observableArrayList(pl);

        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("PicturePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));

        tf_tree_table.setItems(data);
    }

    @FXML
    private void AfficherStock(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/EtatStock.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void affiche_image_plant(MouseEvent event) throws SQLException {
        //ServicePlant sp =new ServicePlant();
        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        int id = p.getIdPlant();
        //p=sp.getPlantById(id);
        this.x1 = id;
        String req = "select PicturePlant from plants where IdPlant=" + id;
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(req);
        if (rs.next()) {
            String title = rs.getString("PicturePlant");
            System.out.println(title);

            Image image = new Image("file:C:/wamp64/www/" + title);
            image_recherche_plant.setImage(image);
            //FileInputStream input;
//            try {
//            
//          
//                input = new FileInputStream("C:\\wamp64\\www\\" + p.getPicturePlant() + "");
//                   Image image = new Image(input);
//            image_recherche_plant.setImage(image);
//            } catch (FileNotFoundException ex) {
//                System.out.println("error");
//            }

        }

    }
}

//String req = "select image from ad where ad_id=" + id;
//            try {
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery(req);
//                if (rs.next()) {
//                    String title = rs.getString("image");
//                    System.out.println(title);
//
//                    Image image = new Image("file:C:/wamp64/www/imageAd/" + title);
//                     image_ad.setImage(image);
