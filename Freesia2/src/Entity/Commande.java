/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author user
 */
public class Commande {
    private int IdCommande;
    private int Date_Commande;

    public Commande() {
    }

    public Commande(int IdCommande, int Date_Commande) {
        this.IdCommande = IdCommande;
        this.Date_Commande = Date_Commande;
    }

    public int getIdCommande() {
        return IdCommande;
    }

    public void setIdCommande(int IdCommande) {
        this.IdCommande = IdCommande;
    }

    public int getDate_Commande() {
        return Date_Commande;
    }

    public void setDate_Commande(int Date_Commande) {
        this.Date_Commande = Date_Commande;
    }

    @Override
    public String toString() {
        return "Commande{" + "IdCommande=" + IdCommande + ", Date_Commande=" + Date_Commande + '}';
    }
    
}
