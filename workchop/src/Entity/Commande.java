/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author user
 */
public class Commande {
    private int idcommande;
    private String nomcommande;
    private String date;
    private int quantitecommande;
    private int nomfavoris;
    private int prixcommande;

    public Commande() {
    }

    public Commande(int idcommande, String nomcommande, String date, int quantitecommande, int nomfavoris, int prixcommande) {
        this.idcommande = idcommande;
        this.nomcommande = nomcommande;
        this.date = date;
        this.quantitecommande = quantitecommande;
        this.nomfavoris = nomfavoris;
        this.prixcommande = prixcommande;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public String getNomcommande() {
        return nomcommande;
    }

    public void setNomcommande(String nomcommande) {
        this.nomcommande = nomcommande;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantitecommande() {
        return quantitecommande;
    }

    public void setQuantitecommande(int quantitecommande) {
        this.quantitecommande = quantitecommande;
    }

    public int getNomfavoris() {
        return nomfavoris;
    }

    public void setNomfavoris(int nomfavoris) {
        this.nomfavoris = nomfavoris;
    }

    public float getPrixcommande() {
        return prixcommande;
    }

    public void setPrixcommande(int prixcommande) {
        this.prixcommande = prixcommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "idcommande=" + idcommande + ", nomcommande=" + nomcommande + ", date=" + date + ", quantitecommande=" + quantitecommande + ", nomfavoris=" + nomfavoris + ", prixcommande=" + prixcommande + '}';
    }
    
    

}