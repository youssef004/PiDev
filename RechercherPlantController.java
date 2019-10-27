/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import service.ServicePlant;

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
    @FXML
    private TextField tf_category_recherche;
    @FXML
    private Button AfficherPlant;
    @FXML
    private Button RetourGestionPlant;
    @FXML
    private Button SupprimerPlant;

    /**
     * Initializes the controller class.
     */
    private int x1 = NULL;
    @FXML
    private Button AfficherStock;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tf_tree_table.setEditable(true);
        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = null;
        try {
            pl = (ArrayList<Plant>) svp.listerPlant();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPlantsController.class.getName()).log(Level.SEVERE, null, ex);
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

    }

    @FXML
    private void AfficherPlant(ActionEvent event) throws IOException, SQLException {
        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        if (p == null) {
            System.out.println("choisir plant");
        } else {
      
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../GUI/AfficherPlantRechercher.fxml"
                    ));
            Scene scene = new Scene(loader.load());
            AfficherPlantRechercherController ct = loader.getController();
            ct.setPlant(p);
            
            Stage stageAff = new Stage();
            stageAff.setScene(
                    scene
            );

            stageAff.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

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

    @FXML
    private void searchPlant(KeyEvent event) throws SQLException {
        String s = tf_name_recherche.getText();
        ObservableList<Plant> data = null;
        data = FXCollections.observableArrayList(new ServicePlant().filtrePlant(s));

        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("PicturePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));

        tf_tree_table.setItems(data);

    }

    @FXML
    private void SupprimerPlant(ActionEvent event) throws SQLException {

        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        ServicePlant s = new ServicePlant();
        int IdPlant = p.getIdPlant();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer" + p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerPlant(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData();
        refresh_plant();
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
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("Picture"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
        tf_tree_table.setItems(data);
    }

    @FXML
    private void AfficherStock(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("EtatStock.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
    }

}
