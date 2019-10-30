/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Cart;
import Entity.Commande;
import freesia2.MyConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceCommande {
     private Connection con = MyConnexion.getInstance().getConnection();
    private Statement ste;
     public ServiceCommande() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void ajouterCommande(Commande c) throws SQLException, SQLException, SQLException, SQLException {      
      String requete="INSERT INTO `commande` (`IdCommande`, `Date_Commande`) VALUES ('" +c.getIdCommande()+ "', '" +c.getDate_Commande()+ "' );";
      ste.executeUpdate(requete);
      System.out.println("Commande ajouté");
     }
  
     public void supprimerCommande (int IdCommande) throws SQLException{
        String requete ="DELETE FROM commande WHERE commande.`IdCommande` = '" +IdCommande+ "' " ;
        ste.executeUpdate(requete);
        System.out.println("Commande supprimer");
        
     }
  
   public void  modifierCommande(int IdCommande, Date Date_Commande ) throws ParseException{
     
        try {
            ServiceCommande sc= new ServiceCommande();
            java.sql.Statement st=con.createStatement();
            int nbre=st.executeUpdate("update commande set IdCommande='"+IdCommande+"',Date_Commande='"+Date_Commande+"'");
            System.out.println("votre compte modifié !");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceCompany.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public List<Commande> listerCommande() throws SQLException {
        List <Commande> Commande= new ArrayList<>();
        String req="SELECT * FROM commande";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);

        while (rst.next()){
           Commande c = new Commande(
                    rst.getInt("IdCommandet"),
                    rst.getInt("Date_Commande"));
                    
           Commande.add(c);
        }
        return Commande;
    }
}
