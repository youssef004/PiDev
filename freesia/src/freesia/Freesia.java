/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freesia;

import entities.Admin;
import service.MyConnection;
import entities.user;
import entities.reclamation;
import java.text.ParseException;
//import static java.time.Clock.system;
import java.util.Properties;
import java.sql.*;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import jdk.nashorn.internal.objects.NativeDate;
import service.GestionAdmin;


/**
 *
 * @author pc-hamma
 */
public class Freesia {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
   
    public static void main(String[] args) throws ParseException, SQLException {
        MyConnection save = new MyConnection();
        GestionAdmin admin = new GestionAdmin();
        java.util.Date utilDate;
        utilDate = new SimpleDateFormat("dd MM yyyy").parse("01 05 2019");
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);
        reclamation post =new reclamation(90,"esprit","oumayma",sqlDate,"hhhhhhh");
        Admin pos = new Admin(1,"oumayma","ouma","ouss","raya");
        admin.ajouterAdmin(pos);
        
       // ste.con.createStatement();
       
        //reclamation post2 =new reclamation(2,"kjhjghj","fhfhg",sqlDate,"hhhhhhh");
        //save.ajouterReclamation(post2);
        //user usr=new user(22, "oumayma", "oussema", "youssef", "oumayma", 12, "youssef", "oumayma");
        //save.ajouterUser(usr);
        //save.ajouterUser(new user(1, "test", "test", "tejhgj", "test", 1, "tehgfh", "test"));
        //save.ajouterReclamation(post);
        
       // post.modifierReclamation();
        //save.supprimerReclamation(80);
        //System.out.println("ajouter fini");
            
        
    }
      
    
}
