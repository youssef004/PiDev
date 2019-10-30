/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Menbrecurrent;
import Entity.membre;
import Service.ServiceUser;
import Service.servicecurrent;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import com.restfb.Version;
import com.restfb.types.User;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @FXML
    private Label showPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LogIn(ActionEvent event) throws SQLException, IOException {
        ServiceUser us = new ServiceUser();
        Service.servicecurrent s = new servicecurrent();
        Pattern p = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"
                + "\\@"
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"
                + "("
                + "\\."
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
                + ")+"
        );

        Matcher m = p.matcher(Email.getText());
        if (Email.getText().equals("")) {
            verif.setText("right your email");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (!m.find()) {
            verif.setText("this is not a email");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else if (Password.getText().equals("")) {
            verif.setText("enter your password");
            verif.setStyle("-fx-text-fill: #ff1744");
        } else {
            membre u = new membre();
            u = (us.getUserByEmail(Email.getText()));

            if (u.getMdp().equals(Password.getText())) {

                Menbrecurrent d = new Menbrecurrent(s.getUserByEmail(Email.getText()));

                Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
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

    @FXML
    private void showPAssword(ActionEvent event) {
        String password = Password.getText();
        showPass.setText(password);
    }

    @FXML
    private void facebooklogin(ActionEvent event) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Oussama\\Documents\\NetBeansProjects\\newProject\\chromedriver.exe");
        //   java.io.File file = new java.io.File("src/GUI/Authentification/newfile.txt");;

        String accessToken;
        WebDriver driver = new ChromeDriver();
        ///https://stackoverflow.com/people/auth/facebook/callback
        String authURl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=436759923642453&redirect_uri=https://stackoverflow.com/people/auth/facebook/callback/&scope=email";


        
        //client_id=436759923642453&redirect_uri=https://stackoverflow.com/people/auth/facebook/callback/
        
        
        
        
        // String authURl="https://www.facebook.com/v4.0/dialog/oauth?response_type=token&display=popup&client_id=436759923642453&redirect_uri=https://stackoverflow.com";
        driver.get(authURl);

        while (true) {
            if (driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                String first;
                accessToken=url.replaceAll(".*#access_token=(.+)&.*","$1");
                  System.out.println(accessToken);
                first = accessToken.substring(13, accessToken.lastIndexOf("&"));
                
                
                FacebookClient fbClient = new DefaultFacebookClient(first,Version.VERSION_2_12);//accessToken, Version.VERSION_2_4


                //System.out.println("111111111111111111     "+fbClient.getClass());
                
                //, User.class,Parameter.with("fields", "email")
                User me = fbClient.fetchObject("me",User.class);
               

                /*
                FacebookClient fbClient = new DefaultFacebookClient("me", Version.LATEST);
                User user = fbClient.fetchObject("me", User.class);*///User me = fbClient.fetchObject("me",User.class);
                //System.out.println(me.getFirstName());
                //System.out.println(me)
                driver.quit();

                //System.out.println(me.getFirstName());
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } else {
                System.out.println("erreur");
            }
        }

    }

}
