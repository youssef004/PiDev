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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
     
     
     public void ajouterCart(Cart c) throws SQLException {   /*   
      String requete="INSERT INTO `cart` (`IdPlant`, `NamePlant`, `TypePlant`, `QuantityPlant`,`CategoryPlant`,`PricePlant`,`DescriptionPlant`) VALUES ('" +c.getIdPlant()+ "', '" +c.getNamePlant()+ "', '" +c.getTypePlant()+ "', '" +c.getQuantityPlant()+ "','" +c.getCategoriePlant()+ "','" +c.getPricePlant()+"','" +c.getDescriptionPlant()+"')";
      ste.executeUpdate(requete);
      System.out.println("produit ajouté dans le chariot");*/
     }
  
   /*  public void supprimerCart (int IdPlant) throws SQLException{
        String requete ="DELETE FROM cart WHERE cart.`IdPlant` = '" +IdPlant+ "' " ;
        ste.executeUpdate(requete);
        System.out.println("Produit supprimer du chariot");
        
     }
  */
   /* public void modifierCart (int IdChariot) throws SQLException{
        String requete="UPDATE `cart` SET `NumberProduit` = '5', `BonusChariot` = '20' WHERE `cart`.`IdChariot` = '"+IdChariot+"'; ";
        ste.executeUpdate(requete);
           System.out.println("Pannié modifier");
    }*/
  
    
    public void  modifierProduitCart(String NamePlant, int QuantityPlant) throws ParseException{
     
        try {
            ServiceChariot sc = new ServiceChariot();
            java.sql.Statement st=con.createStatement();
            int nbre=st.executeUpdate("update cart set QuantityPlant='"+QuantityPlant+"' where NamePlant='"+NamePlant+"' ");
            System.out.println("Quantite modifié !");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceChariot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerProduitCart(String NamePlant){
        String requete ="DELETE FROM cart  WHERE cart.`NamePlant` = '"+NamePlant+"' ";
        try{
                Statement st = con.createStatement();
                st.executeUpdate(requete);
                System.out.println("Produit supprimé du chariot !");

      }catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());
      }}
    
    /**
     *
     * @return
     */
    
       
       /* List <Cart> cart= new ArrayList<>();
        String req="SELECT `IdPlant`, `NamePlant`, `TypePlant`, `QuantityPlant`, `CategoryPlant`, `DescriptionPlant` ,`PricePlant` FROM cart";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);

        while (rst.next()){
            Cart c = new Cart(
                    rst.getInt("IdPlant"),
                    rst.getString("NamePlant"),
                    rst.getString("TypePlant"),
                    rst.getInt("QuantityPlant"),
                    rst.getString("CategoryPlant"),
                    rst.getFloat("PricePlant"),
                    rst.getString("DescriptionPlant"));
           cart.add(c);
        }
        return cart;
    }*/
   /* public boolean findTotalPrix(int price) throws Exception{
        int i=0; 
        try{ 
            Sta
        }
       String requete = ("SELECT SUM(`PricePlant`) FROM `plants` WHERE 1");
       //ste.executeUpdate(requete);
         System.out.println(ste.executeUpdate(requete));
       */
     
       
 public static void sendEmail (Session session, String toEmail, String subject, String body)  {
try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "Email From Freesia"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new java.util.Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
        	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
}



}
 
    

