/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Plant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.ServicePlant;
import utils.ConnexionBD;

/**
 *
 * @author Youssef
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        
    
    //Connection myconn0= ConnexionBD.getInstanceConnexionBD().getConnection();
    List<Plant> plants = null ;
    plants = new ArrayList<>();
 
    ServicePlant a = new ServicePlant(); 
    Plant p1 = new Plant(11,"test","test",5,"test",150,"hello test","hello test");
   // Plant p1 = new Plant(10);
    // a.ajouterPlant(p1);
  
    
    // supprimer
  //  a.supprimerPlant(p1);
    
    //modifier
   Plant p2 = new Plant(10,"bonjour","test",5,"test",350,"hello test","hello test");
   // a.modifierPlant(p2);
 
   a.listerPlant().forEach(e->System.out.println(e));
        
      }
}