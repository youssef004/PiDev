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
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

//import jdk.nashorn.internal.runtime.Property;
import service.ServicePlant;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AfficherPlantsController implements Initializable {

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
    private TableColumn<Plant, String> tf_description;
    @FXML
    private TableView<Plant> tf_tree_table;
    @FXML
    private Button btn_refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tf_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        tf_name.setCellFactory(TextFieldTableCell.forTableColumn());
//        tf_type.setCellFactory(TextFieldTableCell.forTableColumn());
//        tf_quantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        tf_category.setCellFactory(TextFieldTableCell.forTableColumn());
//        tf_price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        tf_description.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        // loadData();
    }

    private void loadData() {
        ObservableList<Plant> data = null;
         
        try {
           data = FXCollections.observableArrayList(new ServicePlant().listerPlant());
        } catch (SQLException e) {
            e.printStackTrace();
        }
       

   }
    @FXML
    private void refresh_plant(ActionEvent event) throws SQLException {
        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = (ArrayList<Plant>) svp.listerPlant();
        ObservableList<Plant> data = FXCollections.observableArrayList(pl);
        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
         tf_tree_table.setItems(data);
    }

    @FXML
    private void modifier_affiche_plant(ActionEvent event) {
    }

    @FXML
    private void delete_plant(ActionEvent event) {
    Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
    ServicePlant s = new ServicePlant();
    int IdPlant = p.getIdPlant();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerPlant(p);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData();
    }

    @FXML
    private void retour_affiche(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Ajouter.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    

}
