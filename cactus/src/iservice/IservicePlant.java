/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Plant;
import java.sql.SQLException;

/**
 *
 * @author Youssef
 */
public interface IservicePlant {
    public void ajouterPlant(Plant p);
    public void supprimerPlant(Plant p)throws SQLException;
    public boolean rechercherPlant(String nom);  
    public void displayPlant() throws SQLException; 
    public void modifierPlant(Plant p) throws SQLException; 
   
    
}
