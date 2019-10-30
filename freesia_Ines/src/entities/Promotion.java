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
public class Promotion {

    private int IdPromotion; 
    private String DescriptionPromotion;
    private int PercentagePromotion; 
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
    
    
    
}
