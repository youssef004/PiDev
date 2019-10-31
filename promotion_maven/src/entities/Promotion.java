/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ines bouguerra
 */
public class Promotion {

    private int IdPromotion; 
    private String DescriptionPromotion;
    public int PercentagePromotion; 
    private Date StartDate;
    private Date EndDate;
    private String StatePromotion;
    private String Period;

    public Promotion() {
    }

    public Promotion(int IdPromotion, String DescriptionPromotion, int PercentagePromotion, Date StartDate, Date EndDate, String StatePromotion, String Period) {
        this.IdPromotion = IdPromotion;
        this.DescriptionPromotion = DescriptionPromotion;
        this.PercentagePromotion = PercentagePromotion;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.StatePromotion = StatePromotion;
        this.Period = Period;
    }

    public int getIdPromotion() {
        return IdPromotion;
    }

    public void setIdPromotion(int IdPromotion) {
        this.IdPromotion = IdPromotion;
    }

    public String getDescriptionPromotion() {
        return DescriptionPromotion;
    }

    public void setDescriptionPromotion(String DescriptionPromotion) {
        this.DescriptionPromotion = DescriptionPromotion;
    }

    public int getPercentagePromotion() {
        return PercentagePromotion;
    }

    public void setPercentagePromotion(int PercentagePromotion) {
        this.PercentagePromotion = PercentagePromotion;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getStatePromotion() {
        return StatePromotion;
    }

    public void setStatePromotion(String StatePromotion) {
        this.StatePromotion = StatePromotion;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String Period) {
        this.Period = Period;
    
    }

    @Override
    public String toString() {
        return "Promotion{" + "IdPromotion=" + IdPromotion + ", DescriptionPromotion=" + DescriptionPromotion + ", PercentagePromotion=" + PercentagePromotion + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", StatePromotion=" + StatePromotion + ", Period=" + Period + '}'+'\n'+"}";
    }

    public Promotion(int IdPromotion, String DescriptionPromotion, int PercentagePromotion, String StatePromotion, String Period) {
        this.IdPromotion = IdPromotion;
        this.DescriptionPromotion = DescriptionPromotion;
        this.PercentagePromotion = PercentagePromotion;
        this.StatePromotion = StatePromotion;
        this.Period = Period;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.IdPromotion;
        hash = 13 * hash + Objects.hashCode(this.DescriptionPromotion);
        hash = 13 * hash + this.PercentagePromotion;
        hash = 13 * hash + Objects.hashCode(this.StartDate);
        hash = 13 * hash + Objects.hashCode(this.EndDate);
        hash = 13 * hash + Objects.hashCode(this.StatePromotion);
        hash = 13 * hash + Objects.hashCode(this.Period);
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
        final Promotion other = (Promotion) obj;
        if (this.IdPromotion != other.IdPromotion) {
            return false;
        }
        if (this.PercentagePromotion != other.PercentagePromotion) {
            return false;
        }
        if (!Objects.equals(this.DescriptionPromotion, other.DescriptionPromotion)) {
            return false;
        }
        if (!Objects.equals(this.StatePromotion, other.StatePromotion)) {
            return false;
        }
        if (!Objects.equals(this.Period, other.Period)) {
            return false;
        }
        if (!Objects.equals(this.StartDate, other.StartDate)) {
            return false;
        }
        if (!Objects.equals(this.EndDate, other.EndDate)) {
            return false;
        }
        return true;
    }
    
    
    
}
