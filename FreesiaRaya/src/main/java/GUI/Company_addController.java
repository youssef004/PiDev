/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Company;
import Service.ServiceCompany;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Company_addController implements Initializable {

    @FXML
    private TextField tfnomcompany;
    @FXML
    private TextField tfemailcompany;
    @FXML
    private TextField tfpswcompany;
    @FXML
    private TextField tfnumerocompany;
    @FXML
    private TextField tfadressecompany;
    private TextField tfidcompany;
    @FXML
    private AnchorPane tfCompte_company;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutcomptecompany(ActionEvent event) throws SQLException, IOException { 
        
        Company c = new Company(); 
        if (tfnomcompany.getText().trim().isEmpty() || tfemailcompany.getText().trim().isEmpty() || tfnumerocompany.getText().trim().isEmpty() || tfpswcompany.getText().trim().isEmpty() ||  tfadressecompany.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Attention ! il faut remplir tous les champs !");}
        else{
       
        
        //c.setIdCompany(Integer.valueOf(tfidcompany.getText()));
        c.setNameCompany(tfnomcompany.getText());
        c.setEmailCompany(tfemailcompany.getText());
        c.setPasswordCompany(tfpswcompany.getText());
        c.setNumberCompany(Integer.valueOf(tfnumerocompany.getText()));
        c.setAddressCompany(tfadressecompany.getText());
        
        ServiceCompany sc = new ServiceCompany();
        try {
            sc.ajouterCompany(c);
        } catch (SQLException ex) {
            Logger.getLogger(Company_addController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Parent root = FXMLLoader.load(getClass().getResource("/Compte_company_ajouter.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        try  { //debut code SMS
            // Construct data
            String data = "";
            /*
             * Note the suggested encoding for certain parameters, notably
             * the username, password and especially the message.  ISO-8859-1
             * is essentially the character set that we use for message bodies,
             * with a few exceptions for e.g. Greek characters.  For a full list,
             * see:  https://www.bulksms.com/developer/eapi/submission/character-encoding/
             */ 
            data += "username=" + URLEncoder.encode("raya_hadhri", "ISO-8859-1");
            data += "&password=" + URLEncoder.encode("RayaRaya1", "ISO-8859-1");
            data += "&message=" + URLEncoder.encode("VOTRE COMPTE PEPINIERE A ETE CREER AVEC SUCCES: vous pouvez maintenant ajouter vos plantes", "ISO-8859-1");
            data += "&want_report=1";
            data += "&msisdn=21658109060";

            // Send data
            // Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
            URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
        }}
    @FXML
    private void gotoAjouter(KeyEvent event) throws IOException {
    }

    @FXML
    private void suppcomptecompany(ActionEvent event) throws IOException  {
      
        
        Parent root = FXMLLoader.load(getClass().getResource("/Compte_company_supprimé.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        
        /*Company c = new Company();
        c.setNameCompany(tfnomcompany.getText());
        
        ServiceCompany sc;
        sc = new ServiceCompany();
        sc.supprimerCompany(c.getNameCompany());
       */
    
    }

    @FXML
    private void modifcomptecompany(ActionEvent event) throws ParseException, IOException {
        
        Company c = new Company();
        // c.setIdCompany(Integer.valueOf(tfidcompany.getText()));
         c.setNameCompany(tfnomcompany.getText());
         c.setEmailCompany(tfemailcompany.getText());
         c.setPasswordCompany(tfpswcompany.getText());
         c.setNumberCompany(Integer.valueOf(tfnumerocompany.getText()));
         c.setAddressCompany(tfadressecompany.getText());
        
        ServiceCompany sc;
        sc = new ServiceCompany();
        sc.modifierCompany(c.getIdCompany(),c.getNameCompany(),c.getEmailCompany(),c.getPasswordCompany(),c.getNumberCompany(),c.getAddressCompany());
    
        Parent root = FXMLLoader.load(getClass().getResource("/Compte_company_modifier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }}


    
