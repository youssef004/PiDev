/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.reclamation;
import entities.user;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc-hamma
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/freesia";//fi blaset localhost najem nhot @ip win hatit ma base de donne 
    public String login="root";
    public String pwd="";
    public Connection con;
    private Statement ste;
    public MyConnection() throws ParseException{
        try {
            con=DriverManager.getConnection(url,login,pwd);//methode susceptible de declancher une exception de typle mysql
            System.out.println("Connection établie!");
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connection non établie!");

        }
    
    }
       
    public void ajouterReclamation( reclamation r){
        String requete = "INSERT INTO reclamation (IdReclamation,SubjectReclamation,DescriptionReclamation,DateReclamation,StateReclamation)"+"VALUES ('"+r.getIdReclamation()+"','"+r.getSubjectReclamation()+"','"+r.getDescriptionReclamation()+"','"+r.getDateReclamation()+"','"+r.getStateReclamation()+"')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            System.out.println("reclamation ajouté !");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());
        }
    }/*public void modifierReclamation(int IdReclamation){
         String requete="UPDATE `reclamation` SET `SubjectReclamation` = 'papa', `DescriptionReclamation` = 'oumayma', `DateReclamation` = '2019-05-09', `StateReclamation` = 'gkfgdsjfjkldhd' WHERE `reclamation`.`IdReclamation` = '"+IdReclamation+"'; ";
        try{
                Statement st = con.createStatement();
                st.executeUpdate(requete);
                System.out.println("reclamation modifié !");

      }catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());*/
    public void  modifierReclamation(int IdReclamation, String SubjectReclamation,String DescriptionReclamation,Date DateReclamation,String StateReclamation ) throws ParseException{
     
        try {
            MyConnection Cx= new MyConnection();
            java.sql.Statement st=con.createStatement();
            int nbre=st.executeUpdate("update reclamation set SubjectReclamation='"+SubjectReclamation+"',DescriptionReclamation='"+DescriptionReclamation+"',DateReclamation='"+DateReclamation+"' where IdReclamation='"+IdReclamation+"' ");
            System.out.println("reclamation modifié !");

        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       

    }
    public void  modifierState(int Cin, String State) throws ParseException{
     
        try {
            MyConnection Cx= new MyConnection();
            java.sql.Statement st=con.createStatement();
            int nbre=st.executeUpdate("update user set State='"+State+"' where Cin='"+Cin+"' ");
            System.out.println("State modifié !");

        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       

    }



    
    
    
    public void supprimerReclamation(int IdReclamation){
        String requete ="DELETE FROM `reclamation` WHERE `reclamation`.`IdReclamation` = '"+IdReclamation+"' ";
        try{
                Statement st = con.createStatement();
                st.executeUpdate(requete);
                System.out.println("reclamation supprimerReclamation !");

      }catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());
        }
        
        
    }
    public List<reclamation> listerReclamation() throws SQLException {
        List <reclamation> rec= new ArrayList<>();
        String req="SELECT * FROM reclamation";
        Statement st=con.createStatement();
        ResultSet rst=st.executeQuery(req);

        while (rst.next()){
            reclamation r = new reclamation(
                    rst.getInt("IdReclamation"),
                    rst.getString("SubjectReclamation"),
                    rst.getString("DescriptionReclamation"),
                    rst.getDate("DateReclamation"),
                    rst.getString("StateReclamation"));
           rec.add(r);
        }
        return rec;
    }
    public void ajouterUser( user u) {
        String requete = "INSERT INTO `user` (`Cin`,`LastName`,`FirstName`,`Email`,`Address`,`Number`,`Login`,`Mdp`) VALUES ('"+u.getCin()+"','"+u.getLastName()+"','"+u.getFirstName()+"','"+u.getEmail()+"','"+u.getAddress()+"','"+u.getNumber()+"','"+u.getLogin()+"','"+u.getMdp()+"')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            System.out.println("utilisateur ajouté !");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());
        }
    }
     public List<user> listerUser() throws SQLException {
        List <user> us= new ArrayList<>();
        String req="SELECT * FROM user";
        Statement st=con.createStatement();
        ResultSet rst=st.executeQuery(req);

        while (rst.next()){
            user u = new user(
                    rst.getInt("Cin"),
                    rst.getString("LastName"),
                    rst.getString("FirstName"),
                    rst.getString("Email"),
                    rst.getString("Address"),
                    rst.getInt("Number"),
                    rst.getString("Login"),
                    rst.getString("Mdp"),
                    rst.getString("State"));
          us.add(u);
        }
        return us;
    }
}
    
    
    