/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import Service.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class ModiferSupprimerAnnonceController implements Initializable {

    @FXML
    private TextField Titre;
    @FXML
    private TextArea Description;
    //private DatePicker Date;
    @FXML
    private TextField Id;
    @FXML
    private Label verif;
    @FXML
    private DatePicker tfDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        ServiceAnnonce AN=new ServiceAnnonce();
        AN.supprimerAnnonce(Integer.valueOf(Id.getText()));

        
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException, IOException {
        if(Id.getText().equals("")){
            verif.setText("Right the ID");
            verif.setStyle("-fx-text-fill: #ff1744"); 
        }else if(Description.getText().equals("")){
            verif.setText("Right the Description");
            verif.setStyle("-fx-text-fill: #ff1744");
        }else if(Titre.getText().equals("")){
            verif.setText("Right the Title");
            verif.setStyle("-fx-text-fill: #ff1744");  
        }else{
            Annonce A =new Annonce();
        A.setDateAnnonce(Date.valueOf(tfDate.getValue()));
        A.setPicture("Youssef");
        A.setDescriptionAnnonce(Description.getText());
        A.setTitreAnnoce(Titre.getText());
        ServiceAnnonce AN=new ServiceAnnonce();
        AN.modifierAnnonce(A,Integer.valueOf(Id.getText()));
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
       // FXMLLoader prefsLoader = new FXMLLoader(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        
        
        
        }
        
        
    }

    @FXML
    private void getInformation(ActionEvent event) throws SQLException {
        ServiceAnnonce sa = new ServiceAnnonce() ;
        
        
       
    
        Annonce u=new Annonce();
        u=(sa.getAnnonceById(Integer.valueOf(Id.getText())));
        Titre.setText(u.getTitreAnnoce());
        Description.setText(u.getDescriptionAnnonce());
        
        
            
        
            //verif.setText("Verif password");
            verif.setStyle("-fx-text-fill: #ff1744");           
        
            
        
        
    }

    @FXML
    private void ExitUpdate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
