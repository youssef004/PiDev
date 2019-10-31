/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import GUI.CalculPromotionController;
import entities.Promotion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnextionBD;

/**
 *
 * @author ines bouguerra
 */
public class ServicePromotion {

    private Connection con = ConnextionBD.getInstance().getConnection();
    private Statement ste;
    private String DescriptionPromotion;

    public ServicePromotion() {

        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void ajouterPromotion(Promotion p) throws SQLException {
        String requete = "INSERT INTO `promotion` (`DescriptionPromotion`, `PercentagePromotion`, `StartDate`, `EndDate`, `StatePromotion`, `Period`) "
                + "VALUES ()";
        PreparedStatement pres = con.prepareStatement(requete);
        //pres.setInt(1, p.getIdPromotion());
        pres.setString(1, p.getDescriptionPromotion());
        pres.setInt(2, p.getPercentagePromotion());
        pres.setDate(3, p.getStartDate());
        pres.setDate(4, p.getEndDate());
        pres.setString(5, p.getStatePromotion());
        pres.setString(6, p.getPeriod());

        pres.executeUpdate();
        System.out.println("élement insérer");

    }

    public void ajouterPromotion1(Promotion p) throws SQLException {

        String requete = "INSERT INTO `Promotion` (`DescriptionPromotion`, `PercentagePromotion`,`StartDate`,`EndDate`,`StatePromotion`,`Period`) " + "VALUES ('" + p.getDescriptionPromotion() + "', '" + p.getPercentagePromotion()
                + "', '" + p.getStartDate() + "', '" + p.getEndDate() + "', '" + p.getStatePromotion() + "', '" + p.getPeriod() + "');";
        ste.executeUpdate(requete);
        System.out.println("élement insérer");
    }

    public void supprimerPromotion(int IdPromotion) throws SQLException {
        String requete = "DELETE FROM `Promotion` WHERE `Promotion`.`IdPromotion` = " + IdPromotion + " ";
        ste.executeUpdate(requete);
        System.out.println("élément supprimer");

    }

    public List<Promotion> readAll() throws SQLException {
        String req = "select * from Promotion";
        ResultSet resultat = ste.executeQuery(req);

        Promotion promotion = null;
        List<Promotion> promotions = new ArrayList<>();
        while (resultat.next()) {
            promotion = new Promotion(resultat.getInt(1), resultat.getString(2), resultat.getInt(3), resultat.getDate(4),
                    resultat.getDate(5), resultat.getString(6), resultat.getString(7));
            promotions.add(promotion);
        }
        //System.out.println(promotions);
        return promotions;
    }

    public void modifierPromotion(int IdPromotion) throws SQLException {
        String requete = "UPDATE `promotion` SET `DescriptionPromotion` = 'première description', `PercentagePromotion` = '40', `StartDate` = '2019-08-01', `EndDate` = '2018-10-18', `StatePromotion` = 'finis', `Period` = '17 jours' WHERE `promotion`.`IdPromotion` = 1";
        ste.executeUpdate(requete);
        System.out.println("update element");

    }

    public void modifierPromotion1(int IdPromotion, String DescriptionPromotion, int percentagePromotion, String Period) throws SQLException {

        ServicePromotion sp = new ServicePromotion();
        java.sql.Statement st = con.createStatement();
        st.executeUpdate("update Promotion set IdPromotion='" + IdPromotion + "',DescriptionPromotion='" + DescriptionPromotion + "',PercentagePromotion='" + percentagePromotion + "',Period='" + Period + "' where IdPromotion='" + IdPromotion + "' ");
        System.out.println(" modifié !");

    }

    /* 
    public void modierPromotion2(int Id,Promotion p) throws SQLException{
        System.out.println("1");
       
        String req="UPDATE `promotion` SET `DescriptionPromotion` = '"  +p.getDescriptionPromotion()+"', `PercentagePromotion` = '"  +p.getPercentagePromotion()+"', `StartDate` = '"+p.getStartDate()+"', `StartDate` = '"+p.getStartDate()+"', `Period` = '"+p.getPeriod()+"' WHERE `promotion`.`IdPromotion` = "+Id+";";
         System.out.println("2");
        Statement s = con.createStatement();         
        ResultSet rs = s.executeQuery(req);

    }*/
    public void modifier(int IdPromotion, String SescriptionPromotion, int PercentagePromotion, Date StartDate, Date EndDate, String StatePromotion, String Period) throws ParseException {

        try {
            ServicePromotion p = new ServicePromotion();
            java.sql.Statement st = con.createStatement();
            int nbre;
            nbre = st.executeUpdate("update promotion set DescriptionPromotion='" + DescriptionPromotion + "',PercentagePromotion='" + PercentagePromotion + "',StartDate='" + StartDate + "',EndDate='" + EndDate + "',StatePromotion='" + StatePromotion + "',Period='" + Period + "' where IdPromotion='" + IdPromotion + "'");
            System.out.println("votre promotion modifié !");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Promotion getPromotionById(int IdPromotion) throws SQLException {
        String req = "SELECT * FROM `Promotion` WHERE `IdPromotion` = '" + IdPromotion + "'";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(req);
        Promotion p = new Promotion();
        if (rs.next()) {
            p.setIdPromotion(rs.getInt("IdPromotion"));
            p.setPercentagePromotion(rs.getInt("IdPromotion"));
            p.setDescriptionPromotion(rs.getString("DescriptionPromotion"));
            p.setStartDate(rs.getDate("StartDate"));
            p.setEndDate(rs.getDate("EndDate"));
            //p.setPicture(rs.getString("Picture"));
            p.setPeriod(rs.getString("Period"));
            p.setStatePromotion(rs.getString("StatePromotion"));

        }
        return p;
    }

     public float calculateP() throws SQLException {
    String req = "SELECT p.`PricePlant` FROM `plants` p INNER JOIN promotion pr WHERE (p.IdPromotion=pr.IdPromotion)";
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        rst.next();
       // float pricefinal=(pricePlant*PercentagePromotionC)/100;

        float price;
        try {
            price = rst.getFloat("PricePlant");
            return (price);
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0 ;
        }
       

}
     
   public float calculate(){
        
       return 0;
   }
}  
    


/*}*/
// 
//Promotion p = new Promotion();
//int PercentagePromotionC=;
//  floatpricefinal=(pricePlant*PercentagePromotionC)/100;
//System.out.println("Final Price:"+pricefinal);
//return pricefinal;

