/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Plants;
import freesia2.MyConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
     public void findTotalPrix() throws Exception{
       String requete = ("SELECT SUM(`PricePlant`) FROM `plants` WHERE 1");
       //ste.executeUpdate(requete);
         System.out.println(ste.executeUpdate(requete));
       
     }
 
    public List<Plants> listerPlant() throws SQLException {
        List <Plants> Plantss= new ArrayList<>();
        String req="SELECT * FROM plants";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);
     
        while (rst.next()){
            Plants p = new Plants(
                    rst.getInt("IdPlant"),
                    rst.getString("NamePlant"),
                    rst.getString("TypePlant"),
                    rst.getInt("QantityPlant"),
                    rst.getString("CategoryPlant"),
                    rst.getFloat("PricePlant"),
                    rst.getString("DescriptionPlant")
                    );
           Plantss.add(p);
        }
        return Plantss;
    }
}  

     

     
   
 
