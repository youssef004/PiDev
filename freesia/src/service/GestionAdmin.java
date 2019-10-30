/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Admin;
import entities.reclamation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc-hamma
 */
public class GestionAdmin {
     public String url="jdbc:mysql://localhost:3306/freesia";//fi blaset localhost najem nhot @ip win hatit ma base de donne 
    public String login="root";
    public String pwd="";
    public Connection con;
    private Statement ste;
    public GestionAdmin() throws ParseException{
        try {
            con=DriverManager.getConnection(url,login,pwd);//methode susceptible de declancher une exception de typle mysql
            System.out.println("Connection établie!");
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connection non établie!");

        }
    
    }
    
     public void ajouterAdmin( Admin a){
        String requete = "INSERT INTO admin (CinAdmin,FirstNameAdmin,LastNameAdmin,EmailAdmin,PwdAdmin)"+"VALUES ('"+a.getCinAdmin()+"','"+a.getFirstNameAdmin()+"','"+a.getLasttNameAdmin()+"','"+a.getEmailAdmin()+"','"+a.getPwdAdmin()+"')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            System.out.println("admin ajouté !");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());
        }
    }
     
     public Admin getAdminByEmail(String EmailAdmin) throws SQLException{
         String req="SELECT * FROM admin WHERE EmailAdmin LIKE '"+EmailAdmin+"' ";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         Admin a = new Admin();
         if(rs.next()){
             a.setCinAdmin(rs.getInt("CinAdmin"));
             a.setFirstNameAdmin(rs.getString("FirstNameAdmin"));
             a.setLasttNameAdmin(rs.getString("LastNameAdmin"));
             a.setEmailAdmin(rs.getString("EmailAdmin"));
             a.setPwdAdmin(rs.getString("PwdAdmin"));
      
         }
         return (a);
     }
     
        
    
    
    
}
