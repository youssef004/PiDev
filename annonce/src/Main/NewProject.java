/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entity.Annonce;
import Entity.membre;
import Service.ServiceAnnonce;
import Service.ServiceUser;
import java.sql.Connection;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class NewProject {
        //private Connection conn = ConnexionBD.getInstanceConnexionBD().getConnection();


        static String url="jdbc:mysql://localhost:3306/freesia";
        static String login="root";
        static String pwd="";
        static Connection con; 
        static Statement ste;
       private static NewProject data;
    public static void main(String[] args) throws ParseException {
        
         try {  
            con=DriverManager.getConnection(url, login, pwd);   
            System.out.println("connexion etablie" );
            ste=con.createStatement();
            
            ServiceAnnonce save = new ServiceAnnonce();
            ServiceUser table = new ServiceUser();

            java.util.Date utilDate;
            utilDate = new SimpleDateFormat("dd MMM yyyy").parse("01 NOVEMBER 2019");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            //Annonce post = new Annonce(NULL,"New","new",sqlDate,"hjhjjhjj");
           // Annonce post1 = new Annonce(NULL,"OKkkkkkk",sqlDate,"sqlDate","hjhjjhjj");
            membre User1 =new membre(NULL, "oumayma", "oumayma", "oumayma", "oumayma", 22222, "oumayma", "oumayma","country","Code",50);
            //save.ajouterAnnonce(post);
//            save.modifierAnnonce(post1 ,129);
            //save.supprimerAnnonce(125);
            //System.out.println("connexion ajouter" );
            //save.listerAnnoce().forEach(e-> System.out.println(e));
   
            //table.AjouterUser(User1);
            //System.out.println("fin ajout" );
            String s="oussama.boubaker@esprit.tn";
             Pattern p = Pattern.compile("^[A-Za-z0-9-]+(\\-[A-Za-z0-9])*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])");
             Matcher m = p.matcher(s);
             System.out.println();
             

           
            //System.out.println("Les annonces sont: ");
            save.listerAnnoce().forEach(e-> System.out.println(e));
        } catch (SQLException ex){
            System.out.println(ex);
        }
         
        // TODO code application logic here
    }
    public Connection getConnection() {
        return con;
    }
    public static NewProject getInstance() {
        if (data == null) {
            data = new NewProject();
        }
        return data;
    }
    
    
    
}