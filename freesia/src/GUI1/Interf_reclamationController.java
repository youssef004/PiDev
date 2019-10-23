/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.MyConnection;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class Interf_reclamationController implements Initializable {

    @FXML
    private TableColumn<reclamation, String> tfIdReclamation;
    @FXML
    private TableColumn<reclamation, String> tfSubjectReclamation;
    @FXML
    private TableColumn<reclamation, String> tfDescriptionReclamation;
    @FXML
    private TableColumn<reclamation, Date> tfDateReclamation;
    @FXML
    private TableColumn<reclamation, String> tfStateReclamation;
 
 
    /**
     * Initializes the controller class.
     */
   
    @FXML
    private TableView<reclamation> tftableview;
   
    
      
        

    @FXML
    private void retour1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Prem_inter_Admin.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    }

  /* @FXML
    private void afficherReclamation(ActionEvent event) throws ParseException, SQLException {
        MyConnection  mc = new MyConnection();
            st=mc.listerReclamation(); // TODO
        
            data.addAll(st);
            tfIdReclamation.setCellValueFactory(new PropertyValueFactory<>("IdReclamation"));
            tfSubjectReclamation.setCellValueFactory(new PropertyValueFactory<>("SubjectReclamation"));
            tfDescriptionReclamation.setCellValueFactory(new PropertyValueFactory<>("DescriptionReclamation"));
            tfDateReclamation.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
            tfStateReclamation.setCellValueFactory(new PropertyValueFactory<>("StateReclamation"));
            //tftreeview.setItems(data);
      
    }*/
    private final ObservableList<reclamation> data = FXCollections.observableArrayList();
    List<reclamation> st = new ArrayList<>();
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            
            MyConnection mc= new MyConnection();
            
            
            try{
                
                st=mc.listerReclamation();
                
                data.addAll(st);
                tfIdReclamation.setCellValueFactory(new PropertyValueFactory<>("IdReclamation"));
                tfSubjectReclamation.setCellValueFactory(new PropertyValueFactory<>("SubjectReclamation"));
                tfDescriptionReclamation.setCellValueFactory(new PropertyValueFactory<>("DescriptionReclamation"));
               tfDateReclamation.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
                tfStateReclamation.setCellValueFactory(new PropertyValueFactory<>("StateReclamation"));
                
                
               tftableview.setItems(data);
                
            }catch(SQLException ex) {
                Logger.getLogger(Interf_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /*@Override
            public void initialize(URL location, ResourceBundle resources) {
            }*/
        }catch(ParseException ex) {
            Logger.getLogger(Interf_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    

    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
    }*/
    }
}

  

