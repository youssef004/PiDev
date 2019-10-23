/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class ServiceUser {
     private Connection con = ConnexionBD.getInstanceConnexionBD().getConnection();
    private Statement ste;
     public ServiceUser() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void AjouterUser( User u) throws SQLException {
         
        String requete="INSERT INTO `user` (`Cin`, `LastName`, `FirstName`, `Email`, `Address`, `Number`, `Login`, `Mdp`, `Country`, `City`, `CodePostal`) VALUES ('"+NULL+"', '"+u.getLasteName()+"', '"+u.getFirstName()+"', '"+u.getEmail()+"', '"+u.getAddress()+"','"+u.getNumber()+"', '"+u.getLogin()+"', '"+u.getMdp()+"', '"+u.getCountry()+"', '"+u.getCity()+"', '"+u.getCodePostal()+"');";
           
        //String requete = "INSERT INTO `user` (`Cin`, `LastName`, `FirstName`, `Email`, `Address`, `Number`, `Login`, `Mdp`, `Country`, `City`, `CodePostal`) VALUES ('"+NULL+"', '"+u.getLasteName()+"', '"+u.getFirstName()+"', '"+u.getEmail()+"', '"+u.getAddress()+"', '"+u.getNumber()+"', '"+u.getLogin()+"', '"+u.getMdp()+"','"+u.getCountry()+"','"+u.getCity()+"''"+u.getCodePostal()+"');";
         ste.executeUpdate(requete);
          System.out.println("elment inste");
         
            
        
     }
     public static boolean isInteger(Object object) {
	if(object instanceof Integer) {
		return true;
	} else {
		return false ;
		
		
	}
  
    
    }
     public User getUserByEmail(String Email) throws SQLException{
         String req="SELECT * FROM `user` WHERE `Email` LIKE '"+Email+"' ";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         User u = new User();
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
     
    
}
