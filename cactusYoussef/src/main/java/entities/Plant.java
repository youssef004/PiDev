/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Youssef
 */
public class Plant {
    private int IdPlant ;
    private String NamePlant;
    private String TypePlant;
    private int QuantityPlant;
    private String CategoryPlant;
    private double PricePlant;
    private String PicturePlant;
    private String DescriptionPlant;

    public Plant() {
    }

    public Plant(int IdPlant, String NamePlant, String TypePlant, int QuantityPlant, String CategoryPlant, double PricePlant, String PicturePlant, String DescriptionPlant) {
        this.IdPlant = IdPlant;
        this.NamePlant = NamePlant;
        this.TypePlant = TypePlant;
        this.QuantityPlant = QuantityPlant;
        this.CategoryPlant = CategoryPlant;
        this.PricePlant = PricePlant;
        this.PicturePlant = PicturePlant;
        this.DescriptionPlant = DescriptionPlant;
    }
/*
   public Plant (String NamePlant,int QuantityPlant){
        this.NamePlant = NamePlant;
        this.QuantityPlant = QuantityPlant;
       
   }
*/
    public Plant(int IdPlant) {
        this.IdPlant = IdPlant;
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

    public double getPricePlant() {
        return PricePlant;
    }

    public void setPricePlant(double PricePlant) {
        this.PricePlant = PricePlant;
    }

    public String getPicturePlant() {
        return PicturePlant;
    }

    public void setPicturePlant(String PicturePlant) {
        this.PicturePlant = PicturePlant;
    }

    public String getDescriptionPlant() {
        return DescriptionPlant;
    }

    public void setDescriptionPlant(String DescriptionPlant) {
        this.DescriptionPlant = DescriptionPlant;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.IdPlant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plant other = (Plant) obj;
        if (this.IdPlant != other.IdPlant) {
            return false;
        }
        if (!Objects.equals(this.NamePlant, other.NamePlant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plant{" + "IdPlant=" + IdPlant + ", NamePlant=" + NamePlant + ", TypePlant=" + TypePlant + ", QuantityPlant=" + QuantityPlant + ", CategoryPlant=" + CategoryPlant + ", PricePlant=" + PricePlant + ", PicturePlant=" + PicturePlant + ", DescriptionPlant=" + DescriptionPlant + '}';
    }

    

    
    
}
