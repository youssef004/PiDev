/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import java.sql.*;
import static java.sql.Types.NULL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class OUSSFXMLMain extends Application {
    private Connection conn = ConnexionBD.getInstanceConnexionBD().getConnection();

    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String accessTokrn="EAAGNOxgZA0FUBAIedlXxv9ELnN4ouAaJAbsO4MMUTIFGUZAonEvVktIRUmHckZASZCMGfJV75LWwv7RtZANbyXrbZAM8mNsRICo1AcVHSFKZBtOwNV31sqPkdkLpq3ZCKx4p0spG7nJnX3VOdv3RWm4eQ99lX8OOqEStewQ6KG5pSwZDZD";
        //FacebookClient fbClient= new DefaultFacebookClient(accessTokrn,com.restfb.Version.VERSION_2_5);
        //User me = fbClient.fetchObject("me",User.class);
        //System.out.println(me.getName());

        launch(args);
    }
     
}
