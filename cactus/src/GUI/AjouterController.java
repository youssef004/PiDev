/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Plant;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServicePlant;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AjouterController implements Initializable {

    private TextField tf_Name;
    private TextField tf_Type;
    @FXML
    private TextField tf_category;
    @FXML
    private TextField tf_price;
    @FXML
    private Spinner<Integer> tf_quantity;
    @FXML
    private TextArea tf_description;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_type;
    @FXML
    private AnchorPane tf_display;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initSpinner();
    }   
    
    

    @FXML
    private void Add(ActionEvent event) {
           System.out.println("user");
        
       Plant p = new Plant();
       p.setNamePlant(tf_name.getText());
       p.setTypePlant(tf_type.getText());
     
       tf_quantity.setEditable(true);
       p.setQuantityPlant(tf_quantity.getValue());
      
       p.setCategoryPlant(tf_category.getText());
       p.setPricePlant(Integer.valueOf(tf_price.getText()));
       p.setDescriptionPlant(tf_description.getText());
       p.setIdPlant(NULL);
 
       ServicePlant PS=null;
       PS = new ServicePlant();
       PS.ajouterPlant(p);


       if (tf_Name.getText().length()==0 || tf_Type.getText().length()==0 || tf_description.getText().length()==0){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("veuillez remplir!!");
           alert.setHeaderText("WARNING !");
           alert.setContentText("some field are empty !!");
           alert.showAndWait();
       } else {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("veuillez remplir!!");
           alert.setHeaderText("Alert !");
           alert.setContentText("Ad has been added!");
           alert.showAndWait();
       }
       
    }
    private void initSpinner() {
        tf_quantity.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200));
    }

    @FXML
    private void tf_display(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficherPlants.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        
    }

    @FXML
    private void clear_ajouter_plant(ActionEvent event) {
        tf_Name.clear();
        tf_Type.clear();
        tf_category.clear();
        tf_price.clear();
       // tf_quantity.clear();
        tf_description.clear();
        
    }
    
}
