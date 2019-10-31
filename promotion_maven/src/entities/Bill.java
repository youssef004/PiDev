/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ines bouguerra
 */
public class Bill {
    int Idfacture;
    Date DateEmission;
    int TotalPrice;
    Date DatePayment;
    String ModePayment;
    String StateFacture;

    public Bill() {
    }

    public Bill(int Idfacture, Date DateEmission, int TotalPrice, String ModePayment, String StateFacture) {
        this.Idfacture = Idfacture;
        this.DateEmission = DateEmission;
        this.TotalPrice = TotalPrice;
        this.ModePayment = ModePayment;
        this.StateFacture = StateFacture;
    }

    public Bill(int Idfacture, Date DateEmission, int TotalPrice, Date DatePayment, String ModePayment, String StateFacture) {
        this.Idfacture = Idfacture;
        this.DateEmission = DateEmission;
        this.TotalPrice = TotalPrice;
        this.DatePayment = DatePayment;
        this.ModePayment = ModePayment;
        this.StateFacture = StateFacture;
    }

   
    public int getIdfacture() {
        return Idfacture;
    }

    public void setIdfacture(int Idfacture) {
        this.Idfacture = Idfacture;
    }

    public Date getDateEmission() {
        return DateEmission;
    }

    public void setDateEmission(Date DateEmission) {
        this.DateEmission = DateEmission;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public Date getDatePayment() {
        return DatePayment;
    }

    public void setDatePayment(Date DatePayment) {
        this.DatePayment = DatePayment;
    }

    public String getModePayment() {
        return ModePayment;
    }

    public void setModePayment(String ModePayment) {
        this.ModePayment = ModePayment;
    }

    public String getStateFacture() {
        return StateFacture;
    }

    public void setStateFacture(String StateFacture) {
        this.StateFacture = StateFacture;
    }

    @Override
    public String toString() {
        return "Facture{" + "Idfacture=" + Idfacture + ", DateEmission=" + DateEmission + ", TotalPrice=" + TotalPrice + ", DatePayment=" + DatePayment + ", ModePayment=" + ModePayment + ", StateFacture=" + StateFacture + '}';
    }
    

    
}
