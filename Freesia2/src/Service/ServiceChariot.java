/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import Entity.Cart;
import Entity.Plants;
import java.util.ArrayList;
import java.util.List;
import freesia2.MyConnexion;
import static java.sql.JDBCType.NULL;
import javax.management.Query;

/**
 *
 * @author user
 */

public class ServiceChariot {
    private Connection con = MyConnexion.getInstance().getConnection();
    private Statement ste;
     public ServiceChariot() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void ajouterCart(Cart c) throws SQLException, SQLException, SQLException, SQLException {      
      String requete="INSERT INTO `cart` (`IdChariot`, `NumberProduit`, `TotalChariot`, `BonusChariot`,'IdPlant') VALUES ('" +c.getIdChariot()+ "', '" +c.getNumberProduit()+ "', '" +c.getTotalChariot()+ "', '" +c.getBonusChariot()+ "',''" +c.getIdPlant()+ ");";
      ste.executeUpdate(requete);
      System.out.println("produit ajouté");
     }
  
     public void supprimerCart (int IdChariot) throws SQLException{
        String requete ="DELETE FROM cart WHERE cart.`IdChariot` = '" +IdChariot+ "' " ;
        ste.executeUpdate(requete);
        System.out.println("Produit supprimer");
        
     }
  
    public void modifierCart (int IdChariot) throws SQLException{
        String requete="UPDATE `cart` SET `NumberProduit` = '5', `BonusChariot` = '20' WHERE `cart`.`IdChariot` = '"+IdChariot+"'; ";
        ste.executeUpdate(requete);
           System.out.println("Pannié modifier");
    }
  

    public List<Cart> listerCart() throws SQLException {
        List <Cart> cart= new ArrayList<>();
        String req="SELECT * FROM cart";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);

        while (rst.next()){
            Cart c = new Cart(
                    rst.getInt("IdChariot"),
                    rst.getInt("NumberProduit"),
                    rst.getInt("TotalChariot"),
                    rst.getFloat("BonusChariot"),
                    rst.getInt("IdPlant"));
           cart.add(c);
        }
        return cart;
    }
   /* public Cart getPlantById(int Id) throws SQLException{
      /*   String req="SELECT * FROM plants WHERE IdPlant LIKE '"+IdPlant+"' ";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         Cart a = new Cart();
         if(rs.next()){
             a.setId(rs.getInt("CinAdmin"));
             a.setFirstNameAdmin(rs.getString("FirstNameAdmin"));
             a.setLasttNameAdmin(rs.getString("LastNameAdmin"));
             a.setEmailAdmin(rs.getString("EmailAdmin"));
             a.setPwdAdmin(rs.getString("PwdAdmin"));
      
         }
         return (a);*/

    
     

     
    }
    

