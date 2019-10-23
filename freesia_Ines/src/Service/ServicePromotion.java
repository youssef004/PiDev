/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entities.Promotion;
import java.sql.*;
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
public class ServicePromotion {

    private Connection con = ConnextionBD.getInstance().getConnection();
    private Statement ste;

    public ServicePromotion()  {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
     
    }

    public void ajouterPromotion(Promotion p) throws SQLException {
        String requete = "INSERT INTO `promotion` (`IdPromotion`, `DescriptionPromotion`, `PercentagePromotion`, `StartDate`, `EndDate`, `StatePromotion`, `Period`) "
                + "VALUES ()";
        PreparedStatement pres = con.prepareStatement(requete);
        pres.setInt(1, p.getIdPromotion());
        pres.setString(2, p.getDescriptionPromotion());
        pres.setInt(3, p.getPercentagePromotion());
        pres.setDate(4, p.getStartDate());
        pres.setDate(5, p.getEndDate());
        pres.setString(6, p.getStatePromotion());
        pres.setString(7, p.getPeriod());

        pres.executeUpdate();
        System.out.println("élement insérer");

    }

    public void ajouterPromotion1(Promotion p) throws SQLException {

        String requete = "INSERT INTO `Promotion` (`IdPromotion`, `DescriptionPromotion`, `PercentagePromotion`,`StartDate`,`EndDate`,`StatePromotion`,`Period`) " + "VALUES ('" + p.getIdPromotion() + "', '" + p.getDescriptionPromotion() + "', '" + p.getPercentagePromotion()
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
        String requete = "UPDATE `promotion` SET `DescriptionPromotion` = 'ines' WHERE `promotion`.`IdPromotion` ='" + IdPromotion + "'; ";
        ste.executeUpdate(requete);
        System.out.println("update element");

    }

   /* public void modifierPromotion1(int IdPromotion,String SescriptionPromotion,int PercentagePromotion,Date StartDate,Date EndDate,String StatePromotion,String Period) throws SQLException {
        String req = "INSERT INTO `promotion` (`IdPromotion`, `DescriptionPromotion`, `PercentagePromotion`, `StartDate`, `EndDate`, `StatePromotion`, `Period`) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        Promotion p = new Promotion();
        pres.setInt(1, p.getIdPromotion());
        pres.setString(2, p.getDescriptionPromotion());
        pres.setInt(3, p.getPercentagePromotion());
        pres.setDate(4, p.getStartDate());
        pres.setDate(5, p.getEndDate());
        pres.setString(6, p.getStatePromotion());
        pres.setString(7, p.getPeriod());

        pres.setInt(7, p.getIdPromotion());

        pres.executeUpdate();
        System.out.println("update2 element");

    }
    public void modierPromotion2(int Id,Promotion p) throws SQLException{
        System.out.println("1");
       
        String req="UPDATE `promotion` SET `DescriptionPromotion` = '"  +p.getDescriptionPromotion()+"', `PercentagePromotion` = '"  +p.getPercentagePromotion()+"', `StartDate` = '"+p.getStartDate()+"', `StartDate` = '"+p.getStartDate()+"', `Period` = '"+p.getPeriod()+"' WHERE `promotion`.`IdPromotion` = "+Id+";";
         System.out.println("2");
        Statement s = con.createStatement();         
        ResultSet rs = s.executeQuery(req);

    }*/
    
    public Promotion getPromotionById(int IdPromotion) throws SQLException{
         String req="SELECT * FROM `Promotion` WHERE `IdPromotion` = '"+IdPromotion+"'";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         Promotion p = new Promotion();
         if(rs.next()){
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
}