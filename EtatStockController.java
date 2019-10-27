/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import service.ServicePlant;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class EtatStockController implements Initializable {

    @FXML
    private TableView<?> tf_table_stock_dispo;
    @FXML
    private TableColumn<?, ?> tf_name_plant_dispo;
    @FXML
    private TableColumn<?, ?> tf_quantity_plant_dispo;
    @FXML
    private TableView<?> tf_table_stock_indispo;
    @FXML
    private TableColumn<?, ?> tf_name_plant_indispo;
    @FXML
    private TableColumn<?, ?> tf_quantity_plant_indispo;
    @FXML
    private TableView<?> tf_table_stock_moy;
    @FXML
    private TableColumn<?, ?> tf_name_plant_moy;
    @FXML
    private TableColumn<?, ?> tf_quantity_plant_moy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   /*          
       String s1 = "";
        ObservableList<Plant> dataIndispo = null;
        dataIndispo = FXCollections.observableArrayList(new ServicePlant().filtrePlant1(s1));

    
        tf_name_plant_indispo.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
       
        tf_quantity_plant_indispo.setCellValueFactory(new PropertyValueFactory<>("QantityPlant"));
     
       tf_table_stock_indispo.setItems(dataIndispo);
       
*/
     }
 
}
