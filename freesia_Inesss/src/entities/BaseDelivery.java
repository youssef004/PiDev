/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ines bouguerra
 */
public class BaseDelivery {

    private int IdUserD;
    private int NumberD;
    private String FirstNameD;
    private String LastNameD;
    private int TotalProduitD;
    private int ShippingCostD;
    private int Total;
    private String deliveryMethod;

    public BaseDelivery() {
    }

    public BaseDelivery(int IdUserD, int NumberD, String FirstNameD, String LastNameD, int TotalProduitD, int ShippingCostD, int Total, String deliveryMethod) {
        this.IdUserD = IdUserD;
        this.NumberD = NumberD;
        this.FirstNameD = FirstNameD;
        this.LastNameD = LastNameD;
        this.TotalProduitD = TotalProduitD;
        this.ShippingCostD = ShippingCostD;
        this.Total = Total;
        this.deliveryMethod = deliveryMethod;
    }

    public int getIdUserD() {
        return IdUserD;
    }

    public void setIdUserD(int IdUserD) {
        this.IdUserD = IdUserD;
    }

    public int getNumberD() {
        return NumberD;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IdUserD;
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
        final BaseDelivery other = (BaseDelivery) obj;
        if (this.IdUserD != other.IdUserD) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseDelivery{" + "IdUserD=" + IdUserD + ", NumberD=" + NumberD + ", FirstNameD=" + FirstNameD + ", LastNameD=" + LastNameD + ", TotalProduitD=" + TotalProduitD + ", ShippingCostD=" + ShippingCostD + ", Total=" + Total + ", deliveryMethod=" + deliveryMethod + '}';
    }

    public void setNumberD(int NumberD) {
        this.NumberD = NumberD;
    }

    public String getFirstNameD() {
        return FirstNameD;
    }

    public void setFirstNameD(String FirstNameD) {
        this.FirstNameD = FirstNameD;
    }

    public String getLastNameD() {
        return LastNameD;
    }

    public void setLastNameD(String LastNameD) {
        this.LastNameD = LastNameD;
    }

    public int getTotalProduitD() {
        return TotalProduitD;
    }

    public void setTotalProduitD(int TotalProduitD) {
        this.TotalProduitD = TotalProduitD;
    }

    public int getShippingCostD() {
        return ShippingCostD;
    }

    public void setShippingCostD(int ShippingCostD) {
        this.ShippingCostD = ShippingCostD;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
    
            
}
