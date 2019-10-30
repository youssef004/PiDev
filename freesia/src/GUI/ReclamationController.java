/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import service.MyConnection;
import entities.reclamation;
import entities.user;
import freesia.Freesia;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pc-hamma
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField tfIdReclamation;
    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfSubject;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfState;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    @FXML
    private void ajouterReclamation(ActionEvent event) {
            reclamation u = new reclamation();
            u.setIdReclamation(Integer.valueOf(tfIdReclamation.getText()));
            u.setSubjectReclamation(tfSubject.getText());
            u.setDescriptionReclamation(tfDescription.getText());
            u.setDateReclamation(Date.valueOf(tfDate.getValue()));
            u.setStateReclamation(tfState.getText());
            MyConnection mc = null;
        try {
            mc = new MyConnection();
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
            mc.ajouterReclamation(u);
        } 


    @FXML
    private void modifierReclamation(ActionEvent event) {
        reclamation u = new reclamation();
         u.setIdReclamation(Integer.valueOf(tfIdReclamation.getText()));
         u.setSubjectReclamation(tfSubject.getText());
         u.setDescriptionReclamation(tfDescription.getText());
         u.setDateReclamation(Date.valueOf(tfDate.getValue()));
         u.setStateReclamation(tfState.getText());
        
         MyConnection mc;
        try {
            mc = new MyConnection();
            mc.modifierReclamation(u.getIdReclamation(),u.getSubjectReclamation(),u.getDescriptionReclamation(),u.getDateReclamation(),u.getStateReclamation());
            
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }

        
        
        
        
         /*reclamation ur = new reclamation();
        tfIdReclamation.setText(Integer.toString(ur.getIdReclamation()));
        tfSubject.setText(ur.getSubjectReclamation());
        tfDescription.setText(ur.getDescriptionReclamation());
        //tfDate.setText((ur.getDateReclamation()));
        tfState.setText(ur.getStateReclamation());*/

    @FXML
    private void supperReclamation(ActionEvent event) {
        reclamation r = new reclamation();
        r.setIdReclamation(Integer.valueOf(tfIdReclamation.getText()));
        
        MyConnection mc;
        try {
            mc = new MyConnection();
            mc.supprimerReclamation(r.getIdReclamation());
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
        
    }
        
        
        
        
    
    
