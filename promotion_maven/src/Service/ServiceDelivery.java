/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entities.Delivery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.ConnextionBD;

/**
 *
 * @author ines bouguerra
 */
public class ServiceDelivery {

    private Connection con = ConnextionBD.getInstance().getConnection();
    private Statement ste;

    public ServiceDelivery() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterDelivery(Delivery v) throws SQLException {

        String requete;
        requete = "INSERT INTO `Delivery` (`IdDelivery`,`DateDelivery`,`DescriptionDelivery`,`StateDelivery`) " + "VALUES ('" + v.getIdDelivery() + "', '" + v.getDateDelivery() + "', '" + v.getDescriptionDelivery() + "','"
                + v.getStateDelivery() + "');";
        ste.executeUpdate(requete);
        System.out.println("élement insérer");
    }

    public void supprimerDelivery(int IdDelivery) throws SQLException {
        String requete = "DELETE FROM `Delivery` WHERE `Delivery`.`IdDelivery` = " + IdDelivery + " ";
        ste.executeUpdate(requete);
        System.out.println("élément supprimer");

    }

    public void modifierDelivery(int IdDelivery,String DescriptionDelivery,String StateDelivery) throws SQLException {
       
            ServiceDelivery sv= new ServiceDelivery();
            java.sql.Statement st=con.createStatement();
            st.executeUpdate("update Delivery set DescriptionDelivery='"+DescriptionDelivery+"',StateDelivery='"+StateDelivery+"' where IdDelivery='"+IdDelivery+"' ");
            System.out.println(" modifié !");

        
    }

    public List<Delivery> readAllDelivery() throws SQLException {
        String req = "select * from Delivery";
        ResultSet resultat = ste.executeQuery(req);

        Delivery delivery = null;
        List<Delivery> deliveries = new ArrayList<>();
        while (resultat.next()) {
            delivery = new Delivery(resultat.getInt(1), resultat.getDate(2), resultat.getString(3),
                    resultat.getString(4));
            deliveries.add(delivery);
        }
        
        return deliveries;
    }
    public void modifierDelivery1(Delivery v) throws SQLException {
        String req = "update`Delivery` (`IdDelivery`, `DateDelivery`, `DescriptionDelivery`, `StateDelivery`) "
                + "VALUES (?,?,?,?)";
        PreparedStatement pres;
        pres = con.prepareStatement(req);
        pres.setInt(1, v.getIdDelivery());
        pres.setDate(2, v.getDateDelivery());
        pres.setString(3, v.getDescriptionDelivery());
        pres.setString(4, v.getStateDelivery());
        

       

        pres.executeUpdate();
        System.out.println("update2 element");

    }
    
}
