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
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
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

/**
 * FXML Controller class
 *
 * @author user
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfpassword;
    @FXML
    private Label tf_mdp_incorrect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connexion(ActionEvent event) throws IOException, SQLException {
        ServiceCompany gs = new ServiceCompany() ;
        Pattern p = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+"
        );
        Matcher m = p.matcher(tfLogin.getText());
        if(tfLogin.getText().equals("")){
            tf_mdp_incorrect.setText("write your email");
            tf_mdp_incorrect.setStyle("-fx-text-fill: #ff1744");
        }else if(!m.find()){
            tf_mdp_incorrect.setText("this is not a email");
            tf_mdp_incorrect.setStyle("-fx-text-fill: #ff1744");
        }
        else if(tfpassword.getText().equals("")){
            tf_mdp_incorrect.setText("enter your password");
            tf_mdp_incorrect.setStyle("-fx-text-fill: #ff1744");
            
        }
        //else if()
        else{
            Company a=new Company();
            a=(gs.getCompanyByEmail(tfLogin.getText()));
            if(a.getPasswordCompany().equals( tfpassword.getText()))
            {
                Parent root = FXMLLoader.load(getClass().getResource("panieFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }else{
                tf_mdp_incorrect.setText("Verif password");
                tf_mdp_incorrect.setStyle("-fx-text-fill: #ff1744");
            }

        }
 
     }
    }
    