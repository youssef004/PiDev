/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import entities.Plant;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Spinner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static javafx.scene.input.KeyCode.S;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.imageio.stream.FileImageInputStream;

//import jdk.nashorn.internal.runtime.Property;
import service.ServicePlant;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AfficherPlantsController implements Initializable {

    private int x = NULL;
    @FXML
    private TableColumn<Plant, Integer> tf_id;
    @FXML
    private TableColumn<Plant, String> tf_name;
    @FXML
    private TableColumn<Plant, String> tf_type;
    @FXML
    private TableColumn<Plant, Integer> tf_quantity;
    @FXML
    private TableColumn<Plant, String> tf_category;
    @FXML
    private TableColumn<Plant, Double> tf_price;
    @FXML
    private TableColumn<Plant, String> tf_description;
    @FXML
    private TableView<Plant> tf_tree_table;
    @FXML
    private Button btn_refresh;
    @FXML
    private TextField tf_name_mod;
    @FXML
    private TextField tf_type_mod;
    @FXML
    private TextField tf_category_mod;
    @FXML
    private Spinner<Integer> tf_quantity_mod;
    @FXML
    private TextField tf_price_mod;
    @FXML
    private TextArea tf_description_mod;
    @FXML
    private TableColumn<?, ?> tf_picture;
    @FXML
    private Label namePicture;

    /**
     * Initializes the controller class.
     */
    private int x1 = NULL;

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        initSpinner();
        tf_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tf_name.setCellFactory(TextFieldTableCell.forTableColumn());
        tf_type.setCellFactory(TextFieldTableCell.forTableColumn());
        tf_quantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tf_category.setCellFactory(TextFieldTableCell.forTableColumn());
        tf_price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        // tf_picture.setCellFactory(TextFieldTableCell.forTableColumn());
        tf_description.setCellFactory(TextFieldTableCell.forTableColumn());

        loadData();

        //tf_tree_table.setEditable(true);
        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = null;
        try {
            pl = (ArrayList<Plant>) svp.listerPlant();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPlantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Plant> data = FXCollections.observableArrayList(pl);
        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QuantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("PicturePlant"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));

        tf_tree_table.setItems(data);

    }

    public AfficherPlantsController() {
    }
    private Connection myconn0 = ConnexionBD.getInstanceConnexionBD().getConnection();

    private void loadData() {
        ObservableList<Plant> data = null;

        try {
            data = FXCollections.observableArrayList(new ServicePlant().listerPlant());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void refresh_plant(ActionEvent event) throws SQLException {
        ServicePlant svp = new ServicePlant();
        ArrayList<Plant> pl = (ArrayList<Plant>) svp.listerPlant();
        ObservableList<Plant> data = FXCollections.observableArrayList(pl);
        tf_id.setCellValueFactory(new PropertyValueFactory<>("IdPlant"));
        tf_name.setCellValueFactory(new PropertyValueFactory<>("NamePlant"));
        tf_type.setCellValueFactory(new PropertyValueFactory<>("TypePlant"));
        tf_quantity.setCellValueFactory(new PropertyValueFactory<>("QantityPlant"));
        tf_category.setCellValueFactory(new PropertyValueFactory<>("CategoryPlant"));
        tf_price.setCellValueFactory(new PropertyValueFactory<>("PricePlant"));
        tf_picture.setCellValueFactory(new PropertyValueFactory<>("Picture"));
        tf_description.setCellValueFactory(new PropertyValueFactory<>("DescriptionPlant"));
        tf_tree_table.setItems(data);
    }

    private void modifier_affiche_plant(ActionEvent event) throws SQLException {
        Plant p = new Plant();
        p.setNamePlant(tf_name_mod.getText());
        p.setTypePlant(tf_type_mod.getText());

        //tf_quantity.setEditable(true);
        p.setQuantityPlant(tf_quantity_mod.getValue());

        p.setCategoryPlant(tf_category_mod.getText());
        p.setPricePlant(Integer.valueOf(tf_price_mod.getText()));
        p.setPicturePlant(namePicture.getText());
        p.setDescriptionPlant(tf_description_mod.getText());
        p.setIdPlant(x1);

        ServicePlant PS = null;
        PS = new ServicePlant();
        PS.modifierPlant(p);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Le produit " + p.getNamePlant() + " a été créé.");
        alert.showAndWait();

    }

    @FXML
    private void delete_plant(ActionEvent event) {
        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();
        ServicePlant s = new ServicePlant();
        int IdPlant = p.getIdPlant();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer" + p.getNamePlant());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                s.supprimerPlant(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData();
    }

    @FXML
    private void retour_affiche(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Ajouter.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void initSpinner() {
        tf_quantity_mod.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200));
    }

    @FXML
    private void description_modify(KeyEvent event) throws SQLException, FileNotFoundException {
        //System.out.println("test");
        ServicePlant sp = new ServicePlant();

        Plant p = tf_tree_table.getSelectionModel().getSelectedItem();

        int Id = p.getIdPlant();
        System.out.println(Id);
        p = sp.getPlantById(Id);

        // tf_quantity.setEditable(true);
        tf_name_mod.setText(p.getNamePlant());
        tf_type_mod.setText(p.getTypePlant());
        // tf_quantity_mod.setText(p.getQuantityPlant().getValue());

        tf_category_mod.setText(p.getCategoryPlant());
        tf_price_mod.setText(String.valueOf(p.getPricePlant()));
        // tf_picture.setText(p.getPicturePlant());
        tf_description_mod.setText(p.getDescriptionPlant());

        this.x1 = Id;

        String title = p.getPicturePlant();
        System.out.println(title);
        FileInputStream input = new FileInputStream("C:\\wamp64\\www\\" + title + "");
        //  Image image = new Image("C:\\wamp64\\www\\" +title+"") {};
        // ImageView view = new ImageView(input);
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

    Connection c = ConnexionBD
            .getInstanceConnexionBD()
            .getConnection();

    private void table_afficher_image(MouseEvent event) {
        Plant plant = tf_tree_table.getSelectionModel().getSelectedItem();
        ServicePlant splant = new ServicePlant();
        int id = plant.getIdPlant();
        String req = "select PicturePlant from plants where IdPlant=" + id;
        try {
            Statement ste = c.createStatement();
            ResultSet rst = ste.executeQuery(req);
            if (rst.next()) {

                String title = rst.getString("image");
                System.out.println(title);
                // Image image = new Image("C:\\wamp64\\www\\image/" + title) {};
                //  ImageView view = new ImageView();
                //    view.setImage(image);
                Stage imageShow = new Stage();

                Group root = new Group();
                Scene scene = new Scene(root);
                HBox box = new HBox();
                //  box.getChildren().setAll(view);
                root.getChildren().setAll(box);

                imageShow.setTitle("Product Image");
                imageShow.setHeight(500.0);
                imageShow.setWidth(350.0);
                imageShow.centerOnScreen();
                imageShow.setScene(scene);
                imageShow.showAndWait();

            }
        } catch (Exception e) {
        }

    }

    /*@FXML
    private void modifier_affiche_plant(MouseEvent event) throws SQLException {
        Plant p = new Plant();
        p.setNamePlant(tf_name_mod.getText());
        p.setTypePlant(tf_type_mod.getText());

        //tf_quantity.setEditable(true);
        p.setQuantityPlant(tf_quantity_mod.getValue());

        p.setCategoryPlant(tf_category_mod.getText());
        p.setPricePlant(Integer.valueOf(tf_price_mod.getText()));
        p.setPicturePlant(namePicture.getText());
        p.setDescriptionPlant(tf_description_mod.getText());
        p.setIdPlant(x1);

        ServicePlant PS = null;
        PS = new ServicePlant();
        PS.modifierPlant(p);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Le produit " + p.getNamePlant() + " a été créé.");
        alert.showAndWait();

    }*/

    @FXML
    private void Brows(ActionEvent event) {
        Stage primary = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selectionner une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(primary);
        String path = "C:\\wamp64\\www";
        namePicture.setText(file.getName());
        if (file != null) {
            try {
                Files.copy(file.toPath(), new File(path + "\\" + file.getName()).toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void modifier_affiche_plant(MouseEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {
          Plant p = new Plant();
        p.setNamePlant(tf_name_mod.getText());
        p.setTypePlant(tf_type_mod.getText());

        //tf_quantity.setEditable(true);
        p.setQuantityPlant(tf_quantity_mod.getValue());

        p.setCategoryPlant(tf_category_mod.getText());
       p.setPricePlant(Double.valueOf(tf_price_mod.getText()));
        p.setPricePlant(5);
        p.setPicturePlant(namePicture.getText());
        p.setDescriptionPlant(tf_description_mod.getText());
        p.setIdPlant(x1);

        ServicePlant PS = null;
        PS = new ServicePlant();
        PS.modifierPlant(p);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Le produit " + p.getNamePlant() + " a été modifié.");
        alert.showAndWait();

    }

}
