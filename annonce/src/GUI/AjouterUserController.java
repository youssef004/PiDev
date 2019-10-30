/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.membre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import Service.ServiceUser;
import static Service.ServiceUser.isInteger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class AjouterUserController implements Initializable {

    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfConfirm;
    @FXML
    private TextField tfcountry;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfPostal;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfNumber;
    @FXML
    private Label verif;
    @FXML
    private Label verifPass;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void AjouterUser(ActionEvent event) throws SQLException, IOException {
        Pattern p = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"
                + "\\@"
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"
                + "("
                + "\\."
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
                + ")+"
        );
        Pattern p1 = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tfEmail.getText());
        Matcher m1 = p1.matcher(tfNumber.getText());
        Pattern Pnumberpass = Pattern.compile("[A-Z].*[0-9]");
        Matcher mnumberpass = Pnumberpass.matcher(tfPassword.getText());
        String mdp1 = tfPassword.getText();
        int lenghtmdp = mdp1.length();
        String mdp2 = tfConfirm.getText();
        Matcher m2 = p1.matcher(tfPostal.getText());
       
      if (!m.find()) {
            verif.setText("this is not a email");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfLastName.getText().equals("")) {
            verif.setText("Last Name is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfFirstName.getText().equals("")) {
            verif.setText("First Name is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfAdresse.getText().equals("")) {
            verif.setText("Adresse is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfCity.getText().equals("")) {
            verif.setText("City");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfcountry.getText().equals("")) {
            verif.setText("country is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
            //((tfNumber.getText().equals("")) 
        } else if (tfNumber.getText().equals("")) {
            verif.setText("number is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (!m1.find()) {
            verif.setText("enter a number");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfPostal.getText().equals("")) {
            verif.setText("Code Postal is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
        } 
         else if(!mnumberpass.find()){
            verif.setText("you need number to get Password");
            verif.setStyle("-fx-text-fill: #ff1744");
        }
       else if (!tfPassword.getText().equals(verifPass.getText())) {
            verif.setText("the password not equals");
            verif.setStyle("-fx-text-fill: #ff1744");
        }else if (!mdp1.equals(mdp2)) {
            verif.setText("verify you password");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (!m2.find()) {
            verif.setText("verify you Code postal");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else {
            membre u = new membre();
            u.setLasteName(tfLastName.getText());
            u.setFirstName(tfFirstName.getText());
            u.setAddress(tfAdresse.getText());
            u.setNumber(Integer.valueOf(tfNumber.getText()));
            u.setLogin(tfEmail.getText());
            u.setEmail(tfEmail.getText());
            u.setCin(NULL);
            u.setCity(tfCity.getText());
            u.setCountry(tfcountry.getText());
            u.setMdp(tfPassword.getText());
            u.setCodePostal(Integer.valueOf(tfPostal.getText()));
            ServiceUser SU = null;
            SU = new ServiceUser();
            SU.AjouterUser(u);
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    @FXML
    private void gotologin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private int verifPassword() {
        Pattern Pnumberpass = Pattern.compile("[a-z].*[0-9]");
        Matcher mnumberpass = Pnumberpass.matcher(tfPassword.getText());
        String mdp1 = tfPassword.getText();
        int lenghtmdp = mdp1.length();
        System.out.println(lenghtmdp);
        if (mdp1.equals("")) {
            verif.setText("your password is empty");
            verif.setStyle("-fx-text-fill: #ff1744");
            return 1;
        } else if (!mnumberpass.find()) {
            verif.setText("your password don't containt number");
            verif.setStyle("-fx-text-fill: #ff1744");
            return 1;
        } else if (lenghtmdp <= 8 == true) {
            verif.setText("your password is failed ");
            verif.setStyle("-fx-text-fill: #ff1744");
            return 1;

        } else {
            verif.setText("your password is Strong");
            verif.setStyle("-fx-text-fill: #0000ff");
            return 0;
        }
        

    }

    @FXML
    private void verif(ActionEvent event) {
        verifPassword();
    }

}
