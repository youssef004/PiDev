/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Oussama
 */
public class ConnexionBD {
    String url="jdbc:mysql://localhost:3306/freesia";
    String login="root";
    String password="";
    Connection c;
    static ConnexionBD instanceBD;
   
    private ConnexionBD() {
        
          try {
              c = DriverManager.getConnection(url, login,
                      password);
              System.out.println("Connexion etablie");
          } catch (SQLException ex) {
              Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static ConnexionBD getInstanceConnexionBD() {
        if (instanceBD == null)
            instanceBD = new ConnexionBD();
            return  instanceBD;
    }
    public  Connection getConnection() {
            return  c;
    }
    
}
