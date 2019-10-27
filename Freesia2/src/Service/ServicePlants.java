/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Plants;
import static com.sun.org.apache.xpath.internal.XPath.SELECT;
import freesia2.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
 
    public List<Plants> listerPlant() throws SQLException {
        List <Plants> Plantss= new ArrayList<>();
        String req="SELECT * FROM `plants` WHERE `IdChariot` = 2";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);
     
        while (rst.next()){
            Plants p = new Plants(
                    rst.getInt("IdPlant"),
                    rst.getString("NamePlant"),
                    rst.getString("TypePlant"),
                    rst.getInt("QuantityPlant"),
                    rst.getString("CategoryPlant"),
                    rst.getFloat("PricePlant"),
                    rst.getString("DescriptionPlant"),
                     rst.getString("PicturePlant")
                    );
           Plantss.add(p);
        }
        return Plantss;
    }
    public void suprrimerProduit(int Id) throws SQLException {
       String req="UPDATE `plants` SET `IdChariot` = '5' WHERE `plants`.`IdPlant` = "+Id+" ";
       Statement stm=con.createStatement();
        ste.executeUpdate(req);
       System.out.println("element supprimé");
       
    }
     public String AfficheTotalProduit() throws SQLException  {
       String req="SELECT COUNT(*) FROM `plants` WHERE IdChariot=2";
       Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);
        rst.next();
        String totale= rst.getString("COUNT(*)");
        System.out.println(totale);
        return(totale);
    }
     
       public String TotalPrixProduit() throws SQLException {
       String req="SELECT SUM(PricePlant) FROM plants WHERE IdChariot=2 ";
        Statement stm=con.createStatement();
         ResultSet rst=stm.executeQuery(req);
        rst.next();
        String prix= rst.getString("SUM(PricePlant)");
        System.out.println(prix);
        return(prix);
   
       }      } 
       
       
       
       /* try{
         PreparedStatement preparedStmt = con.prepareStatement(req);
        
      // ResultSet resultset=con.getInt(req);
       //int res = req.getPricePlant();
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e);
        }  System.out.println(req);
     }
      */

     

   
 
