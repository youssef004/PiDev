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
public class Delivery {
    private int IdDelivery; 
    private Date DateDelivery;
    private String DescriptionDelivery;
    private String StateDelivery;

    public Delivery() {
    }

    public Delivery(int IdDelivery, Date DateDelivery, String DescriptionDelivery, String StateDelivery) {
        this.IdDelivery = IdDelivery;
        this.DateDelivery = DateDelivery;
        this.DescriptionDelivery = DescriptionDelivery;
        this.StateDelivery = StateDelivery;
    }

    public int getIdDelivery() {
        return IdDelivery;
    }

    public void setIdDelivery(int IdDelivery) {
        this.IdDelivery = IdDelivery;
    }

    public Date getDateDelivery() {
        return DateDelivery;
    }

    public void setDateDelivery(Date DateDelivery) {
        this.DateDelivery = DateDelivery;
    }

    public String getDescriptionDelivery() {
        return DescriptionDelivery;
    }

    public void setDescriptionDelivery(String DescriptionDelivery) {
        this.DescriptionDelivery = DescriptionDelivery;
    }

    public String getStateDelivery() {
        return StateDelivery;
    }

    public void setStateDelivery(String StateDelivery) {
        this.StateDelivery = StateDelivery;
    }

    @Override
    public String toString() {
        return "Delivery{" + "IdDelivery=" + IdDelivery + ", DateDelivery=" + DateDelivery + ", DescriptionDelivery=" + DescriptionDelivery + ", StateDelivery=" + StateDelivery + '}'+'\n';
    }
    
}
