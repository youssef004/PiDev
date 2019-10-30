/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Menbrecurrent;
import Entity.membre;
import Service.ServiceAnnonce;
import Service.servicecurrent;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class ProfileUpdateController implements Initializable {

    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField number;
    @FXML
    private TextField tfcountry;
    @FXML
    private TextField tfcity;
    @FXML
    private TextField tfcodepostal;
    @FXML
    private TextField MDP1;
    @FXML
    private TextField MDP2;
    @FXML
    private Label verif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tfEmail.setText(Entity.Menbrecurrent.getEmail());
        tfFirstName.setText(Menbrecurrent.getFirstName());
        LastName.setText(Menbrecurrent.getLasteName());
        Adresse.setText(Menbrecurrent.getAddress());
        //number.getValue().(Menbrecurrent.getNumber());
        tfcountry.setText(Menbrecurrent.getCountry());
        tfcity.setText(Menbrecurrent.getCity());
        MDP1.setText(Menbrecurrent.getMdp());
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
        Pattern Pnumberpass = Pattern.compile("[a-z].*[0-9]");
        Matcher mnumberpass = Pnumberpass.matcher(MDP1.getText());
        String mdp1 = MDP1.getText();
        Menbrecurrent A = new Menbrecurrent();
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
        Matcher m1 = p1.matcher(number.getText());
       
        if (tfFirstName.getText().equals("")) {
            verif.setText("this right your first name");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (LastName.getText().equals("")) {
            verif.setText("this right your last name");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfEmail.getText().equals("")) {
            verif.setText("right you email");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (!m.find()) {
            verif.setText("this is not your email");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (MDP1.getText().equals("")) {
            verif.setText("right your password");
            verif.setStyle("-fx-text-fill: #ff1744");
        } 
        else if(!mnumberpass.find()){
            verif.setText("you need number to get Password");
            verif.setStyle("-fx-text-fill: #ff1744");
        }
       else if (!MDP1.getText().equals(MDP2.getText())) {
            verif.setText("the password not equals");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (Adresse.getText().equals("")) {
            verif.setText("right your addresse");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (tfcity.getText().equals("")) {
            verif.setText("right your city");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else {
            A.setEmail(tfEmail.getText());
            A.setCountry(tfcountry.getText());
            A.setFirstName(tfFirstName.getText());
            A.setLasteName(LastName.getText());
            
            A.setLogin(tfEmail.getText());
             A.setMdp(MDP1.getText());
             A.setAddress(Adresse.getText());            
            A.setNumber(Integer.valueOf(number.getText()));
            A.setCodePostal(Integer.valueOf(tfcodepostal.getText()));
            A.setCity(tfcity.getText());

            int Id = Entity.Menbrecurrent.getCin();

            servicecurrent AN = new servicecurrent();
            AN.updateprofile(A, Id);
        }

    }

    @FXML
    private void gotoacceuill(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    private int verifPassword() {
        Pattern Pnumberpass = Pattern.compile("[a-z].*[0-9]");
        Matcher mnumberpass = Pnumberpass.matcher(MDP1.getText());
        String mdp1 = MDP1.getText();
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

}
