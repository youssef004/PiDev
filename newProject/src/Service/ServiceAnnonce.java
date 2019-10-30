/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
//import cactus.Cactus;
import Entity.Annonce;

import java.util.ArrayList;
import java.util.List;

import utils.ConnexionBD;

/**
 *
 * @author Oussama
 */
public class ServiceAnnonce {
    private Connection con = ConnexionBD.getInstanceConnexionBD().getConnection();
    private Statement ste;
     public ServiceAnnonce() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void ajouterAnnonce(Annonce A) throws SQLException {
         //String requete="INSERT INTO `annonce` (`IdAnnonce`, `DescriptionAnnonce`, `DateAnnonce`, `TitreAnnoce`, `DescriptionEvennement`, `DateEvennement`) VALUES ();";
          String requete = "INSERT INTO `annonce` (`IdAnnonce`, `DescriptionAnnonce`, `DateAnnonce`,`TitreAnnoce`,`Picture`) " + "VALUES ('"+A.getIdAnnoce()+"', '" +A.getDescriptionAnnonce()+"', '"+A.getDateAnnonce()+
                  "', '"+A.getTitreAnnoce()+"', '"+A.getPicture()+"');";
         ste.executeUpdate(requete);
           System.out.println("elment inste");
     }
     public void supprimerAnnonce (int Idannonce) throws SQLException{
        String requete ="DELETE FROM `annonce` WHERE `annonce`.`IdAnnonce` = " +Idannonce+ " " ;
        ste.executeUpdate(requete);
        System.out.println("elment supprimer");
        
     }
  
    public void modifierAnnonce (Annonce A ,int Id) throws SQLException{
        String requete="UPDATE `annonce` SET `DescriptionAnnonce` = '"+A.getDescriptionAnnonce()+"', "
        + "`DateAnnonce` = '"+A.getDateAnnonce()+"', `TitreAnnoce` = '"+A.getTitreAnnoce()+"', `Picture` = '"+A.getPicture()+"' WHERE `annonce`.`IdAnnonce` ='"+Id+"'; ";
        ste.executeUpdate(requete);
           System.out.println("elment modifier");

    }
    
    public List<Annonce> listerAnnoce() throws SQLException {
        List <Annonce> annonces= new ArrayList<>();
        String req="SELECT * FROM annonce";
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(req);

        while (rst.next()){
            Annonce p=new Annonce(
                    rst.getInt("idAnnonce"),
                    rst.getString("DescriptionAnnonce"),
                    rst.getDate("DateAnnonce"),
                    rst.getString("TitreAnnoce"),
                    rst.getString("Picture"));
            annonces.add(p);
        }
        return annonces;
    }
    public Annonce getAnnonceById(int ID) throws SQLException{
         String req="SELECT * FROM `annonce` WHERE `IdAnnonce` = '"+ID+"'";
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery(req);
         Annonce u = new Annonce();
         if(rs.next()){
             u.setIdAnnoce(rs.getInt("IdAnnonce"));
             u.setDescriptionAnnonce(rs.getString("DescriptionAnnonce"));
             u.setDateAnnonce(rs.getDate("DateAnnonce"));
             u.setPicture(rs.getString("Picture"));
             u.setTitreAnnoce(rs.getString("TitreAnnoce"));
            
         }
         return u;
     }

     public List<Annonce> filtreAnnonce(String s) throws SQLException {
        List<Annonce> annonce = new ArrayList<>();
        String requette = "select * from annonce where IdAnnonce like'%"+s+"%' or DescriptionAnnonce like'%"+s+"%' or DateAnnonce like'%"+s+"%' or TitreAnnoce like'%"+s+"%' or Picture like'%"+s+"%'";
         Statement st = con.createStatement();
         ResultSet rst = st.executeQuery(requette);
      while (rst.next()) {
            Annonce pl=new Annonce(rst.getInt("IdAnnonce"),rst.getString("DescriptionAnnonce"),rst.getDate("DateAnnonce"),rst.getString("TitreAnnoce"),rst.getString("Picture"));
            annonce.add(pl);
        }
    return annonce;
    }
     
   
     }
     
     
     
     
    

