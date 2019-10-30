/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Menbrecurrent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class servicecurrent {
    private Connection con = ConnexionBD.getInstanceConnexionBD().getConnection();
    private Statement ste;
     public servicecurrent() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public Menbrecurrent getUserByEmail(String Email) throws SQLException{
         String req="SELECT * FROM `membre` WHERE `Email` LIKE '"+Email+"' ";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         Menbrecurrent u = new Menbrecurrent();
         if(rs.next()){
             u.setCin(rs.getInt("Cin"));
             u.setLasteName(rs.getString("LastName"));
             u.setFirstName(rs.getString("FirstName"));
             u.setEmail(rs.getString("Email"));
             u.setAddress(rs.getString("Address"));
             u.setNumber(rs.getInt("Number"));
             u.setLogin(rs.getString("login"));
             u.setMdp(rs.getString("Mdp"));
             u.setCountry(rs.getString("Country"));
             u.setCity(rs.getString("City"));
             u.setCodePostal(rs.getInt("CodePostal"));
         }
         return u;
     }
     public void updateprofile(Menbrecurrent m ,int Id) throws SQLException{
         String req="UPDATE `membre` SET `LastName` = '"+m.getLasteName()+"', `FirstName` = '"+m.getFirstName()+"', `Email` = '"+m.getEmail()+"', `Address` = '"+m.getAddress() +"', `Number` = '"+m.getNumber() +"', `Login` ='"+m.getEmail()  +"', `Mdp` = '"+m.getMdp() +"', `Country` = '"+m.getCountry() +"' , `City` = '"+m.getCity() +"', `CodePostal` = '"+m.getCodePostal() +"' WHERE `membre`.`Cin` = '"+Id+"'; ";
        ste.executeUpdate(req);
           System.out.println("elment modifier");
     }
     
    
}
