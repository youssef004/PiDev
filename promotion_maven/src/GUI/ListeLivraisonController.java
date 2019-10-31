/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceDelivery;
import entities.Delivery;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.ConnextionBD;

/**
 * FXML Controller class
 *
 * @author ines bouguerra
 */
public class ListeLivraisonController implements Initializable {

    @FXML
    private TableColumn<Delivery, Integer> cid;
    @FXML
    private TableColumn<Delivery, String> cdate;
    @FXML
    private TableColumn<Delivery, String> cdiscription;
    @FXML
    private TableColumn<Delivery, String> cstate;
    private ObservableList<Delivery> deliveriesData = FXCollections.observableArrayList();
    List<Delivery> deliveries;
    @FXML
    private TableView<Delivery> listelivraison;
    Connection con;

    /**
     * Initializes the controller class.
     */
    public ListeLivraisonController() {

        con = (Connection) ConnextionBD.getInstance().getConnection();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Delivery> deliveries = new ArrayList<Delivery>();

        /*
        try {
            System.out.println(serviceDelivery.readAll().size());
            deliveries = serviceDelivery.readAll();
            nombrepromotion.setText(String.valueOf(promotions.size()));

            
            //deliveries = serviceDelivery.readAllDelivery();
            deliveriesData.addAll(deliveries);
        } catch (SQLException ex) {
            Logger.getLogger(ListeLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cid.setCellValueFactory(new PropertyValueFactory<>("IdDelivery"));
        cdate.setCellValueFactory(new PropertyValueFactory<>("DateDelivery"));
        cdiscription.setCellValueFactory(new PropertyValueFactory<>("DescriptionDelivery"));
        cstate.setCellValueFactory(new PropertyValueFactory<>("StateDelivery"));
        listelivraison.setItems(deliveriesData);*/
        //////////////////////////////
        ArrayList<Delivery> v = null;
        ServiceDelivery serviceDelivery = new ServiceDelivery();
        try {
            System.out.println(serviceDelivery.readAllDelivery().size());
            deliveries = serviceDelivery.readAllDelivery();
            deliveriesData.addAll(deliveries);
            v = (ArrayList<Delivery>) serviceDelivery.readAllDelivery();

        } catch (SQLException ex) {
            Logger.getLogger(ListeLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ObservableList<Delivery> deliveriesData = FXCollections.observableArrayList();

        cid.setCellValueFactory(new PropertyValueFactory<>("IdDelivery"));
        cdate.setCellValueFactory(new PropertyValueFactory<>("DateDelivery"));
        cdiscription.setCellValueFactory(new PropertyValueFactory<>("DescriptionDelivery"));
        cstate.setCellValueFactory(new PropertyValueFactory<>("StateDelivery"));
        listelivraison.setItems(deliveriesData);

        /////////////////////
    }

    @FXML
    private void afficheLivraison(MouseEvent event) throws IOException {
        /*try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifierLivraison.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception ex) {
            System.out.println("Cant load a new window");

        }*/


        /* FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("ModifierLivraison.fxml"));
            Scene scene = new Scene(loader.load());
            ModifierLivraisonController ct = loader.getController();
            ct.setDelivery(v);

            Stage stageAff = new Stage();
            stageAff.setScene(scene);

            stageAff.show();
            ((Node) (event.getSource())).getScene().getWindow().hide;*/
        ///////////////****/////////////////////////
        Delivery v = listelivraison.getSelectionModel().getSelectedItem();
        int index = listelivraison.getSelectionModel().getSelectedIndex();
        Delivery d = listelivraison.getItems().get(index);
        System.out.println(d);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierLivraison.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        ModifierLivraisonController controller = loader.getController();
        controller.setIdm(String.valueOf(d.getIdDelivery()));
        controller.setDescm(d.getDescriptionDelivery());
        controller.setStatem(d.getStateDelivery());

        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        

    }

    @FXML
    private void retourner(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterLivraison.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setTitle("management delivery");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception ex) {
            System.out.println("Cant load a new window");

        }
    }

}
