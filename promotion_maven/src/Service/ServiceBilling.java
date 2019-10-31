/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entities.Bill;
import java.sql.Connection;
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
public class ServiceBilling {
    private Connection con = ConnextionBD.getInstance().getConnection();
    private Statement ste;

    public ServiceBilling() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterBill(Bill v) throws SQLException {

        String requete;
        requete = "INSERT INTO `Bill` (`Idfacture`,`DateEmission`,`TotalPrice`,`ModePayment`,'StateFacture') " + "VALUES ('" + v.getIdfacture() + "', '" + v.getDateEmission() + "', '" + v.getTotalPrice() + "','"
                + v.getModePayment() + "', '" + v.getStateFacture()+ "');";
        ste.executeUpdate(requete);
        System.out.println("élement insérer");
    }
    public List<Bill> readAllBill() throws SQLException {
        String req = "select * from Bill";
        ResultSet resultat = ste.executeQuery(req);

        Bill bill = null;
        List<Bill> bills = new ArrayList<>();
        while (resultat.next()) {
            bill = new Bill(resultat.getInt(1), resultat.getDate(2), resultat.getInt(3),resultat.getDate(4),
                    resultat.getString(5),resultat.getString(6));
            bills.add(bill);
        }
        
        return bills;
    }
    
}
