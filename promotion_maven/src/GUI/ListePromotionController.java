/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServicePromotion;
import entities.Promotion;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class ListePromotionController implements Initializable {

    @FXML
    private Label tflistpromotion;
    @FXML
    private TableView<Promotion> listePromotion;
    @FXML
    private TableColumn<Promotion, Integer> comumnid;
    @FXML
    private TableColumn<Promotion, Integer> columnpercentage;
    @FXML
    private TableColumn<Promotion, String> columnstartdate;
    @FXML
    private TableColumn<Promotion, String> columnenddate;
    @FXML
    private TableColumn<Promotion, String> columnstate;
    @FXML
    private TableColumn<Promotion, String> columnperiod;
    @FXML
    private TableColumn<Promotion, String> columndescription;
    private final ObservableList<Promotion> promotionsData = FXCollections.observableArrayList();
    List<Promotion> promotions;
    @FXML
    private Label nombrepromotion;
    //private ComboBox<String> combosearchpromotion;
    //ObservableList<String> listSearchPromotion = FXCollections.observableArrayList("ID", "Percentage", "State", "Period");
    @FXML
    private Button tfreturn;
    private TextField searchpromotion;
    @FXML
    private TextField filterfield;
    @FXML
    private Button btpdf;
    @FXML
    private AnchorPane pane;
private Window wind;
    @FXML
    private TextField pdffield;
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Promotion> promotions = new ArrayList<Promotion>();
        ServicePromotion servicePromotion = new ServicePromotion();
        try {
            System.out.println(servicePromotion.readAll().size());
            promotions = servicePromotion.readAll();
            nombrepromotion.setText(String.valueOf(promotions.size()));
            /////*******//////
            comumnid.setCellValueFactory(new PropertyValueFactory<>("IdPromotion"));
            columnpercentage.setCellValueFactory(new PropertyValueFactory<>("percentagePromotion"));
            columnstartdate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
            columnenddate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
            columnstate.setCellValueFactory(new PropertyValueFactory<>("StatePromotion"));
            columnperiod.setCellValueFactory(new PropertyValueFactory<>("Period"));
            columndescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionPromotion"));
            /////*******//////
            promotionsData.addAll(promotions);
            listePromotion.setItems(promotionsData);
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //combosearchpromotion.setItems(listSearchPromotion);
        promotions = new ArrayList<Promotion>();
        ///////////////////filtre//////////////////////////////
        FilteredList<Promotion> filteredData = new FilteredList<>(promotionsData, b -> true);
        filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(promotion -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(promotion.getPercentagePromotion()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } 
                if (String.valueOf(promotion.getStartDate()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                }
                if (String.valueOf(promotion.getEndDate()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                }
                if (promotion.getStatePromotion().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
                 if (promotion.getPeriod().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                 }	
                     else {
                        return false;
                }

            });
        });
        SortedList<Promotion> sortedData = new SortedList<Promotion>(filteredData);
        sortedData.comparatorProperty().bind(listePromotion.comparatorProperty());
        listePromotion.setItems(sortedData);

        ///////////////////filtre//////////////////////////////
    }    

    private void updatecolumnpromotion(MouseEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPromotionFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");

        }
    }

    @FXML
    private void supprimerPromotion(ActionEvent event) {
        /*Promotion p = new Promotion();
        p.setIdPromotion(Integer.valueOf(tfiddelete.getText()));
        ServicePromotion sp = new ServicePromotion();
        try {
            sp.supprimerPromotion(p.getIdPromotion());
        } catch (SQLException ex) {
            Logger.getLogger(ListePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Promotion p = listePromotion.getSelectionModel().getSelectedItem();
        ServicePromotion sp = new ServicePromotion();
        int IdPromotion = p.getIdPromotion();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete " + p.getDescriptionPromotion()+"?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                sp.supprimerPromotion(IdPromotion);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void returnAction(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPromotionFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("ListePromotion");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }
    }

    @FXML
    private void reafficherlistepromotion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListePromotion.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Cant load a new window");
        }
    }
    
    
   
    
    
    @FXML
    private void pdf(ActionEvent event) {
    
    Document document = new Document();
       
        try{
             
            
            Promotion v = listePromotion.getItems().get(listePromotion.getSelectionModel().getSelectedIndex());
            String p ,  b , c , d;
            String a=".pdf";
            p = (pdffield.getText()).concat(a);
            
           
            
             if(pdffield.getText().length()== 0)
            {Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Name your file");
            alert.showAndWait();  }
            else{
            
            PdfWriter.getInstance(document, new FileOutputStream(p));
           
            document.open();
            Paragraph p1 = new Paragraph("List of Deliveries");
            Paragraph p2 = new Paragraph("Help me find Promotion !!");
            Paragraph p3 = new Paragraph(" ");
            Paragraph p7 = new Paragraph(" ");
            Paragraph p8 = new Paragraph("It's a :");
            Paragraph p9 = new Paragraph(v.getIdPromotion());
            Paragraph p4 = new Paragraph(" ");
            Paragraph p5 = new Paragraph("Promotion Description :");
            Paragraph p6 = new Paragraph(v.getDescriptionPromotion());
            Paragraph p10 = new Paragraph(" ");
            Paragraph p11 = new Paragraph("Promotion Percentage : ");
            Paragraph p12 = new Paragraph(v.getPercentagePromotion());
            Paragraph p13 = new Paragraph(" ");
            Paragraph p14 = new Paragraph("Period of promotion");
            Paragraph p17 = new Paragraph(v.getPeriod());
            Paragraph p18 = new Paragraph(" ");
            Paragraph p19 = new Paragraph("State of promotion :");
            Paragraph p20 = new Paragraph(v.getStatePromotion());
            /*Paragraph p21 = new Paragraph(" ");
            Paragraph p22 = new Paragraph("Numéro de téléphone :");
            Paragraph p23 = new Paragraph();
            Paragraph p24 = new Paragraph(" ");
            Paragraph p25 = new Paragraph("Adresse mail :");
            Paragraph p26 = new Paragraph(v.getPercentagePromotion());*/
            
            document.add(p1);
            document.add(p2);
            document.add(p3);
            document.add(p4);
            document.add(p5);
            document.add(p6);
            document.add(p7);
            document.add(p8);
            document.add(p9);
            document.add(p10);
            document.add(p11);
            document.add(p12);
            document.add(p13);
            document.add(p14);
            //document.add(p15);
            //document.add(p16);
            document.add(p17);
            document.add(p18);
            document.add(p19);
            document.add(p20);
            /*document.add(p21);
            document.add(p22);
            document.add(p23);
            document.add(p24);
            document.add(p25);
            document.add(p26);*/
            
           
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Pdf created successfully");
            alert.showAndWait();  }}
        catch(Exception e){
            System.out.println(e);
        }
        document.close();
    
    
    
    
    }

    @FXML
    private void updatecolumn(MouseEvent event) {
    }
}
        

    
    
    
    
    

