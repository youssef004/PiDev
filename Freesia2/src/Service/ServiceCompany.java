/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Company;
import freesia2.MyConnexion;
import java.sql.Connection;
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
public class ServiceCompany {
    
    private Connection con = MyConnexion.getInstance().getConnection();
    private Statement ste;
     public ServiceCompany () {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void ajouterCompany(Company c) throws SQLException {      
      String requete="INSERT INTO `company` (`IdCompany`, `NameCompany`, `EmailCompany`, `PasswordCompany`, `NumberCompany`, `AddressCompany`) VALUES ('" +c.getIdCompany()+ "', '" +c.getNameCompany()+ "', '" +c.getEmailCompany()+ "', '" +c.getPasswordCompany()+ "', '" +c.getNumberCompany()+ "', '" +c.getAddressCompany()+"')";
      ste.executeUpdate(requete);
      System.out.println("votre compte Compagnie est ajoutée");
     }
  
     public void supprimerCompany (int IdCompany) throws SQLException{
        String requete ="DELETE FROM company WHERE company.`IdCompany` = '" +IdCompany+ "' " ;
        ste.executeUpdate(requete);
        System.out.println("Votre Compangnie compte est supprimé");
        
     }
  public void  modifierCompany(int IdCompany, String NameCompany,String EmailCompany,String PasswordCompany,int NumberCompany,String AddressCompany ) throws ParseException{
     
        try {
            ServiceCompany sc= new ServiceCompany();
            java.sql.Statement st=con.createStatement();
            int nbre=st.executeUpdate("update company set NameCompany='"+NameCompany+"',EmailCompany='"+EmailCompany+"',PasswordCompany='"+PasswordCompany+"',NumberCompany='"+NumberCompany+"',AddressCompany='"+AddressCompany+"' where IdCompany='"+IdCompany+"'");
            System.out.println("votre compte modifié !");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
    public List<Company> listerCompany() throws SQLException {
        List <Company> company= new ArrayList<>();
        String req="SELECT * FROM company";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);

        while (rst.next()){
            Company c = new Company(
                    rst.getInt("IdCompany"),
                    rst.getString("NameCompany"),
                    rst.getString("EmailCompany"),
                    rst.getString("PasswordCompany"),
                    rst.getInt("NumberCompany"),
                    rst.getString("AddressCompany"));
           company.add(c);
        }
        return company;
    }
}
     

     
   
    
