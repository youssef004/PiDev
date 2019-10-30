/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Company;
import Service.ServiceCompany;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Compte_company_suppriméController implements Initializable {

    @FXML
    private AnchorPane tfComptecompanysupprimé;
    @FXML
    private TextField tfnomcompanymodifsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retour_supp_company(ActionEvent event) throws IOException {
             Parent root = FXMLLoader.load(getClass().getResource("/Compte_company.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void suppcomptecompany(ActionEvent event) throws IOException {
        
      /* Parent root = FXMLLoader.load(getClass().getResource("/Compte_company_supprimé1.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();*/
    }

    @FXML
    private void suppcomptecompany1(ActionEvent event) throws IOException, SQLException {
        Company c = new Company();
        c.setNameCompany(tfnomcompanymodifsup.getText());
        
        ServiceCompany sc;
        sc = new ServiceCompany();
        sc.supprimerCompany(c.getNameCompany());
             Parent root = FXMLLoader.load(getClass().getResource("/Compte_company_supprimé_1.fxml"));
              Scene scene = new Scene(root);
                Stage stage = new Stage();
               stage.setScene(scene);
                stage.show();
               ((Node) (event.getSource())).getScene().getWindow().hide();
        
        
    }

    
}
