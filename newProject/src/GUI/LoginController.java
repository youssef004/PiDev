/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.User;
import Service.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class LoginController implements Initializable {

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private Label verif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn(ActionEvent event) throws SQLException, IOException {
        ServiceUser us = new ServiceUser() ;
        Pattern p = Pattern.compile(
           "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
           "\\@" +
           "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
           "(" +
           "\\." +
           "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
           ")+"
       );
        
        Matcher m = p.matcher(Email.getText());
        if(Email.getText().equals("")){
            verif.setText("right your email");
            verif.setStyle("-fx-text-fill: #ff1744");
        }else if(!m.find()){
            verif.setText("this is not a email");
            verif.setStyle("-fx-text-fill: #ff1744");
        }
        else if(Password.getText().equals("")){
            verif.setText("enter your password");
            verif.setStyle("-fx-text-fill: #ff1744");
        }else{
        User u=new User();
        u=(us.getUserByEmail(Email.getText()));
        if(u.getMdp().equals(Password.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }else{
            verif.setText("Verif password");
            verif.setStyle("-fx-text-fill: #ff1744");           
        }
            
        }
    }

    @FXML
    private void gotoAjouterUser(MouseEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterUserFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        
    }
    
}
