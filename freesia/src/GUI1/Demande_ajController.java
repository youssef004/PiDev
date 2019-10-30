/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import entities.reclamation;
import entities.user;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.MyConnection;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class Demande_ajController implements Initializable {

    @FXML
    private TableView<user> tftableview_user;
    @FXML
    private TableColumn<user, String> tfCinUser;
    @FXML
    private TableColumn<user, String> tfLastNUser;
    @FXML
    private TableColumn<user, String> tfFirstNUser;
    @FXML
    private TableColumn<user, String> tfEmailUser;
    @FXML
    private TableColumn<user, String> tfAddressUser;
    @FXML
    private TableColumn<user, String> tfNumberUser;
    @FXML
    private TableColumn<user, String> tfLoginUser;
    @FXML
    private TableColumn<user, String> tfMdpUser;

    /**
     * Initializes the controller class.
     */
    private final ObservableList<user> data = FXCollections.observableArrayList();
    List<user> st = new ArrayList<>();
    @FXML
    private TableColumn<?, ?> tfStateu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{
            
            MyConnection mc= new MyConnection();
            
            
            try{
                
                st=mc.listerUser();
                
                data.addAll(st);
                tfCinUser.setCellValueFactory(new PropertyValueFactory<>("Cin"));
                tfLastNUser.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                tfFirstNUser.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
               tfEmailUser.setCellValueFactory(new PropertyValueFactory<>("Email"));
                tfAddressUser.setCellValueFactory(new PropertyValueFactory<>("Address"));
                tfNumberUser.setCellValueFactory(new PropertyValueFactory<>("Number"));
                tfLoginUser.setCellValueFactory(new PropertyValueFactory<>("Login"));
                tfMdpUser.setCellValueFactory(new PropertyValueFactory<>("Mdp"));
                tfStateu.setCellValueFactory(new PropertyValueFactory<>("State"));
                
                
                
               tftableview_user.setItems(data);
                
            }catch(SQLException ex) {
                Logger.getLogger(Demande_ajController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /*@Override
            public void initialize(URL location, ResourceBundle resources) {
            }*/
        }catch(ParseException ex) {
            Logger.getLogger(Demande_ajController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    

    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
    }*/
    }
        // TODO
        

    @FXML
    private void retourdemande_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Prem_inter_Admin.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    
    }

    @FXML
    private void state(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("state.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
       
    }
    }

   
