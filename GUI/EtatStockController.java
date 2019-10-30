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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.ServicePlant;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class EtatStockController implements Initializable {

    @FXML
    private TableView<Plant> tf_table_stock_dispo;
    @FXML
    private TableColumn<Plant, String> tf_name_plant_dispo;
    @FXML
    private TableColumn<Plant, Integer> tf_quantity_plant_dispo;
    @FXML
    private TableView<Plant> tf_table_stock_indispo;
    @FXML
    private TableColumn<Plant, String> tf_name_plant_indispo;
    @FXML
    private TableColumn<Plant, Integer> tf_quantity_plant_indispo;
    @FXML
    private TableView<Plant> tf_table_stock_moy;
    @FXML
    private TableColumn<Plant, String> tf_name_plant_moy;
    @FXML
    private TableColumn<Plant, Integer> tf_quantity_plant_moy;
    ServicePlant PS = null;
    List<Plant> noQantity = new ArrayList<>();
    List<Plant> lowQantity = new ArrayList<>();
    List<Plant> enoughQantity = new ArrayList<>();
    @FXML
    private ImageView icon_retour_recherche_plant;
    @FXML
    private ImageView retour_gestion_plantview;
    @FXML
    private Button red;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PS = new ServicePlant();
        try {
            this.noQantity = PS.getNoQuantity();
            this.lowQantity = PS.getLowQuantity();
            this.enoughQantity = PS.getEnoughQuantity();
            ObservableList<Plant> noData = FXCollections.observableArrayList(this.noQantity);
            ObservableList<Plant> lowData = FXCollections.observableArrayList(this.lowQantity);
            ObservableList<Plant> enoughData = FXCollections.observableArrayList(this.enoughQantity);
            tf_name_plant_indispo.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
            tf_quantity_plant_indispo.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));

            tf_name_plant_dispo.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
            tf_quantity_plant_dispo.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));

            tf_name_plant_moy.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
            tf_quantity_plant_moy.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
            tf_table_stock_dispo.setItems(enoughData);
            tf_table_stock_indispo.setItems(noData);
            tf_table_stock_moy.setItems(lowData);
            System.out.println(lowData);
            System.out.println(enoughData);
            System.out.println(noData);
               } catch (SQLException ex) {
            System.out.println("error sql");
        }
    }

    @FXML
    private void retour_gestion_plant(ActionEvent event) throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("GestionPlant.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
