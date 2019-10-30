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
public class PlantCart {
    private int IdChariot;
    private int NumberProduit;
    private int TotalChariot;
    private int IdPlant;
    private String NamePlant;
    private String TypePlant;
    private int QuantityPlant;
    private String CategoryPlant;
    private Float PricePlant;
    private String DescriptionPlant;
    private String PicturePlant;

    public PlantCart() {
    }

    public PlantCart(int IdChariot, int NumberProduit, int TotalChariot, int IdPlant, String NamePlant, String TypePlant, int QuantityPlant, String CategoryPlant, Float PricePlant, String DescriptionPlant, String PicturePlant) {
        this.IdChariot = IdChariot;
        this.NumberProduit = NumberProduit;
        this.TotalChariot = TotalChariot;
        this.IdPlant = IdPlant;
        this.NamePlant = NamePlant;
        this.TypePlant = TypePlant;
        this.QuantityPlant = QuantityPlant;
        this.CategoryPlant = CategoryPlant;
        this.PricePlant = PricePlant;
        this.DescriptionPlant = DescriptionPlant;
        this.PicturePlant = PicturePlant;
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

    public int getIdPlant() {
        return IdPlant;
    }

    public void setIdPlant(int IdPlant) {
        this.IdPlant = IdPlant;
    }

    public String getNamePlant() {
        return NamePlant;
    }

    public void setNamePlant(String NamePlant) {
        this.NamePlant = NamePlant;
    }

    public String getTypePlant() {
        return TypePlant;
    }

    public void setTypePlant(String TypePlant) {
        this.TypePlant = TypePlant;
    }

    public int getQuantityPlant() {
        return QuantityPlant;
    }

    public void setQuantityPlant(int QuantityPlant) {
        this.QuantityPlant = QuantityPlant;
    }

    public String getCategoryPlant() {
        return CategoryPlant;
    }

    public void setCategoryPlant(String CategoryPlant) {
        this.CategoryPlant = CategoryPlant;
    }

    public Float getPricePlant() {
        return PricePlant;
    }

    public void setPricePlant(Float PricePlant) {
        this.PricePlant = PricePlant;
    }

    public String getDescriptionPlant() {
        return DescriptionPlant;
    }

    public void setDescriptionPlant(String DescriptionPlant) {
        this.DescriptionPlant = DescriptionPlant;
    }

    public String getPicturePlant() {
        return PicturePlant;
    }

    public void setPicturePlant(String PicturePlant) {
        this.PicturePlant = PicturePlant;
    }

    @Override
    public String toString() {
        return "PlantCart{" + "IdChariot=" + IdChariot + ", NumberProduit=" + NumberProduit + ", TotalChariot=" + TotalChariot + ", IdPlant=" + IdPlant + ", NamePlant=" + NamePlant + ", TypePlant=" + TypePlant + ", QuantityPlant=" + QuantityPlant + ", CategoryPlant=" + CategoryPlant + ", PricePlant=" + PricePlant + ", DescriptionPlant=" + DescriptionPlant + ", PicturePlant=" + PicturePlant + '}';
    }
    
}
