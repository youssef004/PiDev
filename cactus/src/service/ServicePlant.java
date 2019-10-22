/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Plant;
import iservice.IservicePlant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author Youssef
 */
public class ServicePlant implements IservicePlant{
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public ServicePlant() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
// ajouter des plantes
     @Override
    public void ajouterPlant  (Plant p) {
        try{
         String requet = "INSERT INTO plants (IdPlant, NamePlant, TypePlant,"
                + " QantityPlant, CategoryPlant, PricePlant, DescriptionPlant)"
                + "VALUES ('"+p.getIdPlant()+"', '"+p.getNamePlant()+"', '"+p.getTypePlant()+"', '"+p.getQuantityPlant()+"', '"+p.getCategoryPlant()+"', '"  +p.getPricePlant()+"', '"+p.getDescriptionPlant()+"')" ;
        
        ste.executeUpdate(requet);
    } catch (SQLException ex) {
        Logger.getLogger(ServicePlant.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    


    @Override
    public void supprimerPlant(Plant p) throws SQLException {
        String requete = "DELETE FROM plants WHERE IdPlant =?" ;
        PreparedStatement r = c.prepareStatement(requete);
        r.setInt(1, p.getIdPlant());
        r.executeUpdate();
        
        
    }

    @Override
    public boolean rechercherPlant(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayPlant() throws SQLException{
        
       

    }
       

    @Override
    public void modifierPlant(Plant p) throws SQLException {
            PreparedStatement pla = c.prepareStatement("update plants set   NamePlant=?,TypePlant=?,QantityPlant=?,CategoryPlant=?, PricePlant=?,DescriptionPlant=? where IdPlant=?");
            pla.setString(1, p.getNamePlant());
            pla.setString(2, p.getTypePlant());
            pla.setInt(3, p.getQuantityPlant());
            pla.setString(4, p.getCategoryPlant());
            pla.setDouble(5, p.getPricePlant());
            pla.setString(6, p.getDescriptionPlant());
      
            pla.setInt(7, p.getIdPlant());
           
         pla.executeUpdate();
 
    }
    public List<Plant> listerPlant() throws SQLException {
        List <Plant> plantes= new ArrayList<>();
        String req="SELECT * FROM plants ";
        Statement ste=c.createStatement();
        ResultSet rst=ste.executeQuery(req);

        while (rst.next()){
           Plant p=new Plant(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getDouble(6),
                    rst.getString(7));
            plantes.add(p);
        }
        return plantes;
    }
 
    
    }

   
    

