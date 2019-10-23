/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import entities.Admin;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;
import service.GestionAdmin;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class AuthentifAdminController implements Initializable {

    @FXML
    private TextField tfEmailAdmin;
    @FXML
    private TextField tfPwdAdmin;
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
    private void authentifAdmin(ActionEvent event) throws IOException, SQLException {
        try {
            GestionAdmin gs = new GestionAdmin() ;
            Pattern p = Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                            "\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                            "\\." +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            ")+"
            );
            
            Matcher m = p.matcher(tfEmailAdmin.getText());
            if(tfEmailAdmin.getText().equals("")){
                verif.setText("write your email");
                verif.setStyle("-fx-text-fill: #ff1744");
            }else if(!m.find()){
                verif.setText("this is not a email");
                verif.setStyle("-fx-text-fill: #ff1744");
            }
            else if(tfPwdAdmin.getText().equals("")){
                verif.setText("enter your password");
                verif.setStyle("-fx-text-fill: #ff1744");
                
            }
            //else if()
            else{
                Admin a=new Admin();
                a=(gs.getAdminByEmail(tfEmailAdmin.getText()));
                if(a.getPwdAdmin().equals(tfPwdAdmin.getText()))
                {
                    Parent root = FXMLLoader.load(getClass().getResource("Prem_inter_Admin.fxml"));
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
        } catch (ParseException ex) {
            Logger.getLogger(AuthentifAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
     }
        
    }
    

