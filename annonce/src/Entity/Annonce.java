/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Oussama
 */
public class Annonce {
    private  int IdAnnoce ;
    private String DescriptionAnnonce  ;
    private Date DateAnnonce ;
    private String TitreAnnoce;
    
    private String picture ;


    public Annonce(int IdAnnoce, String DescriptionAnnonce, Date DateAnnonce, String TitreAnnoce, String picture) {
        this.IdAnnoce = IdAnnoce;
        this.DescriptionAnnonce = DescriptionAnnonce;
        this.DateAnnonce = DateAnnonce;
        this.TitreAnnoce = TitreAnnoce;
        this.picture = picture;
    }

    

    

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    

    

   
    public Annonce(){
        
    }

    

   

    public int getIdAnnoce() {
        return IdAnnoce;
    }

    public void setIdAnnoce(int IdAnnoce) {
        this.IdAnnoce = IdAnnoce;
    }

    public String getDescriptionAnnonce() {
        return DescriptionAnnonce;
    }

    public void setDescriptionAnnonce(String DescriptionAnnonce) {
        this.DescriptionAnnonce = DescriptionAnnonce;
    }

    

    public String getTitreAnnoce() {
        return TitreAnnoce;
    }

    public void setTitreAnnoce(String TitreAnnoce) {
        this.TitreAnnoce = TitreAnnoce;
    }

    public Date getDateAnnonce() {
        return DateAnnonce;
    }

    public void setDateAnnonce(Date DateAnnonce) {
        this.DateAnnonce = DateAnnonce;
    }

    @Override
    public String toString() {
        return "Annonce{" + "IdAnnoce=" + IdAnnoce + ", DescriptionAnnonce=" + DescriptionAnnonce + ", TitreAnnoce=" + TitreAnnoce + ", DateAnnonce=" + DateAnnonce + ", picture=" + picture + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.IdAnnoce;
        hash = 47 * hash + Objects.hashCode(this.DescriptionAnnonce);
        hash = 47 * hash + Objects.hashCode(this.TitreAnnoce);
        hash = 47 * hash + Objects.hashCode(this.DateAnnonce);
        hash = 47 * hash + Objects.hashCode(this.picture);
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
        final Annonce other = (Annonce) obj;
        if (this.IdAnnoce != other.IdAnnoce) {
            return false;
        }
        if (!Objects.equals(this.DescriptionAnnonce, other.DescriptionAnnonce)) {
            return false;
        }
        if (!Objects.equals(this.TitreAnnoce, other.TitreAnnoce)) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.DateAnnonce, other.DateAnnonce)) {
            return false;
        }
        return true;
    }

  


  
   
    
   

    
    
     

    

    
    
    

    
    }

    
    
    
    

