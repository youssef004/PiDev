/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class QuantityController implements Initializable {

    @FXML
    private TextField name_plant_quantity;
    @FXML
    private Spinner<Integer> quantity_plant_dec;
    @FXML
    private ImageView icon_affiche_recherche_plant1;
    @FXML
    private Button SupprimerQuantityPlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initSpinner();
            //System.out.println(p);
          
                   name_plant_quantity.setText(RechercherPlantController.nom);
                    
        
            quantity_plant_dec.getValueFactory().setValue(RechercherPlantController.qt);
    }    
 private void initSpinner() {
        quantity_plant_dec.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200));
    }
    @FXML
    private void SupprimerQuantityPlant(ActionEvent event) {




    }
    
}
