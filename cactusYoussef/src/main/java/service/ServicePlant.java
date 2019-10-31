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
public class ServicePlant implements IservicePlant {

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
    public void ajouterPlant(Plant p) {
        try {
            String requet = "INSERT INTO plants (IdPlant, NamePlant, TypePlant,"
                    + " QantityPlant, CategoryPlant, PricePlant, PicturePlant, DescriptionPlant)"
                    + "VALUES ('" + p.getIdPlant() + "', '" + p.getNamePlant() + "', '" + p.getTypePlant() + "', '" + p.getQuantityPlant() + "', '" + p.getCategoryPlant() + "', '" + p.getPricePlant() + "', '" + p.getPicturePlant() + "', '" + p.getDescriptionPlant() + "')";

            ste.executeUpdate(requet);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePlant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerPlant(Plant p) throws SQLException {
        String requete = "DELETE FROM plants WHERE IdPlant =?";
        PreparedStatement r = c.prepareStatement(requete);
        r.setInt(1, p.getIdPlant());
        r.executeUpdate();
        System.out.println("testsup");

    }

    @Override
    public boolean rechercherPlant(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayPlant() throws SQLException {

    }

    @Override
    public void modifierPlant(Plant p) throws SQLException {
        PreparedStatement pla = c.prepareStatement("update plants set   NamePlant=?,TypePlant=?,QantityPlant=?,CategoryPlant=?, PricePlant=?, PicturePlant=?, DescriptionPlant=? where IdPlant=?");
        pla.setString(1, p.getNamePlant());
        pla.setString(2, p.getTypePlant());
        pla.setInt(3, p.getQuantityPlant());
        pla.setString(4, p.getCategoryPlant());
        pla.setDouble(5, p.getPricePlant());
        pla.setString(6, p.getPicturePlant());
        pla.setString(7, p.getDescriptionPlant());

        pla.setInt(8, p.getIdPlant());

        pla.executeUpdate();

    }

    public List<Plant> listerPlant() throws SQLException {
        List<Plant> plantes = new ArrayList<>();
        String req = "SELECT * FROM plants ";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {

            Plant p = new Plant(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getDouble(6),
                    rst.getString(7),
                    rst.getString(8));
            plantes.add(p);
        }
        return plantes;
    }

    public Plant getPlantById(int ID) throws SQLException {
        String req = "SELECT * FROM `plants` WHERE `IdPlant` = " + ID + "";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(req);
        Plant p = new Plant();
        if (rst.next()) {
            p.setIdPlant(rst.getInt("IdPlant"));
            p.setNamePlant(rst.getString("NamePlant"));
            p.setTypePlant(rst.getString("TypePlant"));
            p.setQuantityPlant(rst.getInt("QuantityPlant"));
            p.setCategoryPlant(rst.getString("CategoryPlant"));
            p.setPricePlant(rst.getDouble("PricePlant"));
            p.setPicturePlant(rst.getString("PicturePlant"));

            p.setDescriptionPlant(rst.getString("DescriptionPlant"));

        }
        return p;
    }

    public List<Plant> filtrePlant(String s) throws SQLException {
        List<Plant> plant = new ArrayList<>();
        String requette = "select * from plants where IdPlant like'%" + s + "%' or NamePlant like'%" + s + "%' or TypePlant like'%" + s + "%'  or QantityPlant like'%" + s + "%' or CategoryPlant like'%" + s + "%' or PricePlant like'%" + s + "%' or PicturePlant like'%" + s + "%' or DescriptionPlant like'%" + s + "%' ";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(requette);
        while (rst.next()) {
            Plant pl = new Plant(rst.getInt("IdPlant"), rst.getString("NamePlant"), rst.getString("TypePlant"), rst.getInt("QantityPlant"), rst.getString("CategoryPlant"), rst.getDouble("PricePlant"), rst.getString("PicturePlant"), rst.getString("DescriptionPlant"));
            plant.add(pl);
        }
        return plant;
    }

    public List<Plant> getNoQuantity() throws SQLException {
        List<Plant> plant = new ArrayList<>();
        String requette = "select * from plants where  QantityPlant = 0 ";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(requette);
        while (rst.next()) {
            Plant pl = new Plant(rst.getInt("IdPlant"), rst.getString("NamePlant"), rst.getString("TypePlant"), rst.getInt("QantityPlant"), rst.getString("CategoryPlant"), rst.getDouble("PricePlant"), rst.getString("PicturePlant"), rst.getString("DescriptionPlant"));
            plant.add(pl);
        }
        return plant;
    }

    public List<Plant> getLowQuantity() throws SQLException {
        List<Plant> plant = new ArrayList<>();
        String requette = "select * from plants where  QantityPlant>0 and QantityPlant<10";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(requette);
        while (rst.next()) {
            Plant pl = new Plant(rst.getInt("IdPlant"), rst.getString("NamePlant"), rst.getString("TypePlant"), rst.getInt("QantityPlant"), rst.getString("CategoryPlant"), rst.getDouble("PricePlant"), rst.getString("PicturePlant"), rst.getString("DescriptionPlant"));
            plant.add(pl);
        }
        return plant;
    }

    public List<Plant> getEnoughQuantity() throws SQLException {
        List<Plant> plant = new ArrayList<>();
        String requette = "select * from plants where  QantityPlant>10 ";
        Statement ste = c.createStatement();
        ResultSet rst = ste.executeQuery(requette);
        while (rst.next()) {
            Plant pl = new Plant(rst.getInt("IdPlant"), rst.getString("NamePlant"), rst.getString("TypePlant"), rst.getInt("QantityPlant"), rst.getString("CategoryPlant"), rst.getDouble("PricePlant"), rst.getString("PicturePlant"), rst.getString("DescriptionPlant"));
            plant.add(pl);
        }
        return plant;
    }
    /*
public List<Plant> filtrePlant1(String s) throws SQLException {
        List<Plant> plant = new ArrayList<>();
        String requette = "select * from plants where NamePlant like'%"+s+"%' or QantityPlant like'%"+s+"%' ";
        Statement ste=c.createStatement();
        ResultSet rst=ste.executeQuery(requette);
      while (rst.next()) {
            Plant pl=new Plant(rst.getString("NamePlant"),rst.getInt("QantityPlant"));
            plant.add(pl);
        }
    return plant;
    }*/
}
