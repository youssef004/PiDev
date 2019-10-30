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
public class Cart {
    private int IdChariot;
    private int NumberProduit;
    private int TotalChariot;
    private float BonusChariot;

    public Cart() {
    }

    public Cart(int IdChariot, int NumberProduit, int TotalChariot, float BonusChariot) {
        this.IdChariot = IdChariot;
        this.NumberProduit = NumberProduit;
        this.TotalChariot = TotalChariot;
        this.BonusChariot = BonusChariot;
    }

    public int getIdChariot() {
        return IdChariot;
    }

    public void setIdChariot(int IdChariot) {
        this.IdChariot = IdChariot;
    }

    public int getNumberProduit() {
        return NumberProduit;
    }

    public void setNumberProduit(int NumberProduit) {
        this.NumberProduit = NumberProduit;
    }

    public int getTotalChariot() {
        return TotalChariot;
    }

    public void setTotalChariot(int TotalChariot) {
        this.TotalChariot = TotalChariot;
    }

    public float getBonusChariot() {
        return BonusChariot;
    }

    public void setBonusChariot(float BonusChariot) {
        this.BonusChariot = BonusChariot;
    }

    @Override
    public String toString() {
        return "Cart{" + "IdChariot=" + IdChariot + ", NumberProduit=" + NumberProduit + ", TotalChariot=" + TotalChariot + ", BonusChariot=" + BonusChariot + '}';
    }
   

}