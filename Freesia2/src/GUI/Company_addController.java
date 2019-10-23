/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Company;
import Service.ServiceCompany;
import freesia2.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Company_addController implements Initializable {

    @FXML
    private TextField tfnomcompany;
    @FXML
    private TextField tfemailcompany;
    @FXML
    private TextField tfpswcompany;
    @FXML
    private TextField tfnumerocompany;
    @FXML
    private TextField tfadressecompany;
    @FXML
    private TextField tfidcompany;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutcomptecompany(ActionEvent event) throws SQLException, IOException { 
        Company c = new Company();  
        c.setIdCompany(Integer.valueOf(tfidcompany.getText()));
        c.setNameCompany(tfnomcompany.getText());
        c.setEmailCompany(tfemailcompany.getText());
        c.setPasswordCompany(tfpswcompany.getText());
        c.setNumberCompany(Integer.valueOf(tfnumerocompany.getText()));
        c.setAddressCompany(tfadressecompany.getText());
        
        ServiceCompany sc = new ServiceCompany();
        try {
            sc.ajouterCompany(c);
        } catch (SQLException ex) {
            Logger.getLogger(Company_addController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/Compte_company_ajouter.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    
    }
    @FXML
    private void gotoAjouter(KeyEvent event) throws IOException {
    }

    @FXML
    private void suppcomptecompany(ActionEvent event) throws SQLException, IOException {
       Company c = new Company();
        c.setIdCompany(Integer.valueOf(tfidcompany.getText()));
        
        ServiceCompany sc;
        sc = new ServiceCompany();
        sc.supprimerCompany(c.getIdCompany());
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/Compte_company_supprimé.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    
    }

    @FXML
    private void modifcomptecompany(ActionEvent event) throws ParseException, IOException {
        
        Company c = new Company();
         c.setIdCompany(Integer.valueOf(tfidcompany.getText()));
         c.setNameCompany(tfnomcompany.getText());
         c.setEmailCompany(tfemailcompany.getText());
         c.setPasswordCompany(tfpswcompany.getText());
         c.setNumberCompany(Integer.valueOf(tfnumerocompany.getText()));
         c.setAddressCompany(tfadressecompany.getText());
        
        ServiceCompany sc;
        sc = new ServiceCompany();
        sc.modifierCompany(c.getIdCompany(),c.getNameCompany(),c.getEmailCompany(),c.getPasswordCompany(),c.getNumberCompany(),c.getAddressCompany());
    
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Compte_company_modifier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }}


    
