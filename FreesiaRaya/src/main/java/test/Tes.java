/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entity.Cart;
import Service.ServiceChariot;
import freesia.MyConnexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class Tes {}
 
 /*  static String url="jdbc:mysql://localhost:3306/pidev";//fi blaset localhost najem nhot @ip win hatit ma base de donne 
    static String login="root";
    static String pwd="";
    static Connection con;
    static Statement ste;
    private static MyConnexion data;
    public static void main(String[] args) throws ParseException, SQLException {
       
       /* java.util.Date utilDate;
        utilDate = new SimpleDateFormat("dd MM yyyy").parse("01 05 2019");
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);*/
            //ServiceChariot save = new ServiceChariot();
         
              /*ServiceCompany save = new ServiceCompany();
             Company pos= new Company(NULL,"raya","raya@esprit.com","lkdalzj",5,"10rue5saKD");
            save.ajouterCompany(pos);*/
            //Cart A= new Cart (NULL,4,331,21);
           // save.ajouterCart(A);   
           //save.supprimerCart(111);
          //save.modifierAnnonce(112);
       //save.listerCart().forEach(e->System.out.println(e));
         
     
        //} catch (SQLException ex) {
           // System.out.println(ex.getMessage());
           // System.out.println("Connection non établie!");

        //}
   
  /*  private Tes(){
        try {
            con=DriverManager.getConnection(url,login,pwd);
            System.out.println("connexion etabli");
        } catch (SQLException ex) {
            Logger.getLogger(Tes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
        
         public Connection getConnection()
         { return con;}
         
        public static MyConnexion getInstance(){
         if (data == null){ 
             data = new MyConnexion();
         }
        return data;
         }



}*/
    
  /* static String url="jdbc:mysql://localhost:3306/freesia2";//fi blaset localhost najem nhot @ip win hatit ma base de donne 
    static String login="root";
    static String pwd="";
    static Connection con;
    static Statement ste;
    private static MyConnexion data;
    public static void main(String[] args) throws ParseException{
         try {
      
            con=DriverManager.getConnection(url,login,pwd);//methode susceptible de declancher une exception de typle mysql
            System.out.println("Connection établie!");
            ste=con.createStatement();
            
            //ServiceCart save = new ServiceCart();
           

            Cart a= new Cart (1,3,33,3);
            String requete ="INSERT INTO `cart` ( `NumberProduit`, `TotalChariot`, `BonusChariot`,IdPlant) VALUES ('"+a.getNumberProduit()+"', '"+a.getTotalChariot()+"', '"+a.getBonusChariot()+"', '"+a.getIdChariot()+"');";
      ste.executeUpdate(requete);
            //save.ajouterCart(A);   
           //save.supprimerCart(111);
          //save.modifierAnnonce(112);
       //save.listerCart().forEach(e->System.out.println(e));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connection non établie!");

        }}
         public Connection getConnection()
         { return con;}
         
        public static MyConnexion getInstance(){
         if (data == null){ 
             data = new MyConnexion();
         }
        return data;
         }*/

