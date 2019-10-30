/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Plants;
import static com.sun.org.apache.xpath.internal.XPath.SELECT;
import freesia.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.SELECT;


/**
 *
 * @author user
 */
public class ServicePlants {
  
    private Connection con = MyConnexion.getInstance().getConnection();
    private Statement ste;
     public  ServicePlants() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
 //"SELECT * FROM `plants` WHERE `IdChariot` = 2"
    public List<Plants> listerPlant() throws SQLException {
        List <Plants> Plantss= new ArrayList<>();
        String req="SELECT `IdPlant`,`NamePlant`, `TypePlant`, `NumberProduit`, `CategoryPlant`, `PricePlant`, `DescriptionPlant` FROM `plants`AS p INNER JOIN cart AS c ON (c.IdChariot=p.IdChariot) WHERE (p.IdChariot=2) " ;
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);
     
        while (rst.next()){
            Plants p = new Plants(
                    rst.getInt("IdPlant"),
                    rst.getString("NamePlant"),
                    rst.getString("TypePlant"),
                    rst.getInt("NumberProduit"),
                    rst.getString("CategoryPlant"),
                    rst.getFloat("PricePlant"),
                    rst.getString("DescriptionPlant")
                    // rst.getString("PicturePlant")
                    );
           Plantss.add(p);
        }
        return Plantss;
    }
    public void suprrimerProduit(int Id) throws SQLException {
       String req="UPDATE `plants` SET `IdChariot` = '5' WHERE `plants`.`IdPlant` = '"+Id+"' ";
       Statement stm=con.createStatement();
        ste.executeUpdate(req);
       System.out.println("element supprimé");
       
    }
     public String AfficheTotalProduit(int id) throws SQLException  {
       String req="SELECT COUNT(*) FROM `plants` WHERE IdChariot=(select IdChariot from user where IdUser ='"+id+"')";
       Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);
        rst.next();
        String totale= rst.getString("COUNT(*)");
        System.out.println(totale);
        return(totale);
    }
     
       public String TotalPrixProduit() throws SQLException {
       String req="SELECT SUM(PricePlant) FROM plants WHERE IdChariot=2";
        Statement stm=con.createStatement();
         ResultSet rst=stm.executeQuery(req);
        rst.next();
        String prix= rst.getString("SUM(PricePlant)");
        System.out.println(prix);
        return(prix);
       
       }    
    public void modifProduit(String NamePlant,int NumberProduit) {
   
         try {
            ServicePlants sc = new ServicePlants();
            java.sql.Statement st=con.createStatement();
            String req = "UPDATE cart SET NumberProduit="+String.valueOf(NumberProduit)+" WHERE IdChariot=(SELECT p.IdChariot FROM plants p WHERE p.NamePlant = '"+NamePlant+"') ";
            //int nbre=st.executeUpdate("UPDATE cart SET NumberProduit=6 WHERE IdChariot=(SELECT p.IdChariot FROM plants p WHERE p.NamePlant = \"sahar\") ");
            int nbre=st.executeUpdate(req);
            System.out.println("Quantite modifié !");
 
        } catch (SQLException ex) {
            Logger.getLogger(ServiceChariot.class.getName()).log(Level.SEVERE, null, ex);}
       //UPDATE cart SET NumberProduit=8 (SELECT p.`IdPlant`, p.`NamePlant`, p.`TypePlant`, c.`NumberProduit`, p.`CategoryPlant`, p.`PricePlant`, p.`DescriptionPlant` FROM `plants` p INNER JOIN cart c ON (p.IdChariot=c.IdChariot) WHERE p.NamePlant="raya")
   
        }}
 /*UPDATE `cart` AS c INNER JOIN `plants` as p SET c.`NumberProduit`='" +NumberProduit+ "' WHERE p.NamePlant='" +NamePlant+"'
/*SELECT `NamePlant`, `TypePlant`, `NumberProduit`, `CategoryPlant`, `PricePlant`, `DescriptionPlant` FROM `plants`AS p INNER JOIN cart AS c ON (p.IdChariot=c.IdChariot) WHERE (p.QuantityPlant>c.NumberProduit)*/