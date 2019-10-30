/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Annonce;
import Service.ServiceAnnonce;
import static com.google.common.collect.Multimaps.index;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.ConnexionBD;
import org.controlsfx.control.Rating;



/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class ListeAnnonceController implements Initializable {

    @FXML
    private TableView<Annonce> liste;
    @FXML
    private TableColumn<Annonce, Date> CDate;
    @FXML
    private TableColumn<Annonce, String> CTitre;
    @FXML
    private TableColumn<Annonce, String> CDescription;
    @FXML
    private TableColumn<Annonce, String> CPicture;
    @FXML
    private Button gotoAjouter;
    @FXML
    private Label TestLabel;
    @FXML
    private Label verif;
    @FXML
    private TextField Cdiscription11;
    @FXML
    private TextField Ctitre11;
    @FXML
    private TextField CPicture11;
    @FXML
    private DatePicker CDate11;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    private int x = NULL;
    @FXML
    private Label verif1;
    @FXML
    private Label verif11;
    @FXML
    private Label verif111;
    @FXML
    private TextField rechercherfiled;
    @FXML
    private ImageView imageview;
    @FXML
    private Label last;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //liste.setEditable(true);
        //CId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        CDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        CDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        CTitre.setCellFactory(TextFieldTableCell.forTableColumn());
        CPicture.setCellFactory(TextFieldTableCell.forTableColumn());
        initColumns();
        loadData();
    }

    @FXML
    private void showAnnonce(MouseEvent event) {

    }

    private void initColumns() {
        //CId.setCellValueFactory(new PropertyValueFactory<>("IdAnnoce"));
        CDescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionAnnonce"));
        CDate.setCellValueFactory(new PropertyValueFactory<>("DateAnnonce"));
        CTitre.setCellValueFactory(new PropertyValueFactory<>("TitreAnnoce"));
        CPicture.setCellValueFactory(new PropertyValueFactory<>("Picture"));

    }

    private void loadData() {
        ObservableList<Annonce> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceAnnonce().listerAnnoce());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        liste.setItems(data);
    }

    @FXML
    private void gotoAjouter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AnnonceMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void ModifierAnnonce(MouseEvent event) {
        /*TestLabel.setText("country is empty");
        TestLabel.setStyle("-fx-text-fill: #ff1744");*/
    }


   /* private void Modifier2Annonce(KeyEvent event) throws IOException, SQLException {
        // String s;
        // s = CDescription.setText();
        // TestLabel.setText(s);
        /* Parent root = FXMLLoader.load(getClass().getResource("../GUI/ModiferSupprimerAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();*/
        //ServiceAnnonce sa = new ServiceAnnonce();

        //Annonce p = liste.getSelectionModel().getSelectedItem();
        //int Id = p.getIdAnnoce();
       // p = sa.getAnnonceById(Id);
        //String title = p.getPicture();
       // Ctitre11.setText(p.getTitreAnnoce());
        //Cdiscription11.setText(p.getDescriptionAnnonce());
        //CPicture11.setText(p.getPicture());
        //FileInputStream input = new FileInputStream("C:\\wamp64\\www\\" + title + "");
        //Image image = new Image(input);
        
        
        
        
        //imageview.setImage(image);
        /*ImageView view = new ImageView();
        view.setImage(image);
        Stage imageShow = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().setAll(view);
        root.getChildren().setAll(box);
        imageShow.setTitle("Product Image");
        imageShow.setHeight(500.0);
        imageShow.setWidth(350.0);
        imageShow.centerOnScreen();
        imageShow.setScene(scene);
        imageShow.showAndWait();*/
       // this.x = Id;
    //}*/

    private void refrechListe(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void returnMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void Deletefromtree(ActionEvent event) {
        Annonce p = liste.getSelectionModel().getSelectedItem();
        ServiceAnnonce s = new ServiceAnnonce();
        int Id = p.getIdAnnoce();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer" + p.getTitreAnnoce());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerAnnonce(Id);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData();
    }


    @FXML
    private void Updatefinal(ActionEvent event) throws SQLException {
        Annonce A = new Annonce();
        A.setDateAnnonce(java.sql.Date.valueOf(CDate11.getValue()));
        A.setPicture(CPicture11.getText());
        A.setDescriptionAnnonce(Cdiscription11.getText());
        A.setTitreAnnoce(Ctitre11.getText());
        ServiceAnnonce AN = new ServiceAnnonce();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier" + A.getTitreAnnoce());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                 AN.modifierAnnonce(A, this.x);
                 refrech( event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
    }

    private void show_Picture(ActionEvent event) throws FileNotFoundException {
        //String title = p.getPicture();
        FileInputStream input = new FileInputStream("C:\\wamp64\\www\\images.jpg");
        Image image = new Image(input);
        ImageView view = new ImageView();
        view.setImage(image);
        Stage imageShow = new Stage();

        Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().setAll(view);
        root.getChildren().setAll(box);

        imageShow.setTitle("Product Image");
        imageShow.setHeight(500.0);
        imageShow.setWidth(350.0);
        imageShow.centerOnScreen();
        imageShow.setScene(scene);
        imageShow.showAndWait();

    }

    @FXML
    private void browseP(ActionEvent event) {
        Stage primary = new Stage();
        //primary.isAlwaysOnTop();
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Selectionner Une Image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = filechooser.showOpenDialog(primary);
        String path ="C:\\wamp64\\www";
        CPicture11.setText(file.getName());
        if(file!=null)
        {           
            try {
                Files.copy(file.toPath(),new File(path+"\\"+file.getName()).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }


    

    @FXML
    private void rechercherAnnonce(KeyEvent event) throws SQLException {
        String s= rechercherfiled.getText();
        ObservableList<Annonce> data = null;
        data = FXCollections.observableArrayList(new ServiceAnnonce().filtreAnnonce(s));
            
       CDescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionAnnonce"));
        CDate.setCellValueFactory(new PropertyValueFactory<>("DateAnnonce"));
        CTitre.setCellValueFactory(new PropertyValueFactory<>("TitreAnnoce"));
        //CPicture.setCellValueFactory(new PropertyValueFactory<>("Picture"));

    
        liste.setItems(data);
    }
private Connection con = ConnexionBD.getInstanceConnexionBD().getConnection();
private Statement ste;
    @FXML
    private void exporttoexcell(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        String query="SELECT * FROM annonce";
        ste=con.createStatement();
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(query);
        
        Annonce a= new Annonce();
        
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet =wb.createSheet("DescriptionAnnonce");
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("DescriptionAnnonce");
        header.createCell(1).setCellValue("DateAnnonce");
        header.createCell(2).setCellValue("TitreAnnoce");
        header.createCell(3).setCellValue("Picture");
        
       
        
        int index = 1;
        while(rst.next()){
            XSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(rst.getString("DescriptionAnnonce"));
            row.createCell(1).setCellValue(rst.getString("DateAnnonce"));
            row.createCell(2).setCellValue(rst.getString("TitreAnnoce"));
            row.createCell(3).setCellValue(rst.getString("Picture"));
            index ++ ;
        }
        FileOutputStream fileOut = new FileOutputStream("Annoce.xlsx");
        wb.write(fileOut);
        fileOut.close();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("information dialog");
        alert.setContentText("Annonce Details Exported in Excel sheet.");
        alert.showAndWait();
          
    }

    @FXML
    private void Modifier2Annonce(MouseEvent event) throws SQLException, FileNotFoundException, ParseException {
        ServiceAnnonce sa = new ServiceAnnonce();

        Annonce p = liste.getSelectionModel().getSelectedItem();
        int Id = p.getIdAnnoce();
        p = sa.getAnnonceById(Id);
        String title = p.getPicture();
        Ctitre11.setText(p.getTitreAnnoce());
        Cdiscription11.setText(p.getDescriptionAnnonce());
        CPicture11.setText(p.getPicture());
        
        FileInputStream input = new FileInputStream("C:\\wamp64\\www\\" + title + "");
        Image image = new Image(input);
        
        imageview.setImage(image);
        this.x = Id;
       
       //the last date
        Date d1 = p.getDateAnnonce();
        java.util.Date date=new java.util.Date();
	Date d2 =  date;
        Date firstDate = p.getDateAnnonce(); 
        LocalDate now = LocalDate.now();
        long diff = d2.getTime() - d1.getTime();
        System.out.println("time"+diff);
        long diffSeconds = diff / 1000 % 60;
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	long diffDays = (diff / (24 * 60 * 60 * 1000));
        long diffyears = diffDays / 360 ;
        long diffmonth ;
        long day;
       if(diffDays>30){
           diffmonth = diffDays/12 ;
           day=diffDays-(diffmonth*12);
           System.out.print(day+"day" );
           last.setText("there is"+diffyears + " years." );
       }else{
           last.setText("there is "+diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes, "+diffSeconds + " s. " );
       }
       last.setStyle("-fx-text-fill: #ff1744");
        
        
        
    }
     private void refrech(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeAnnonce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
     
}
