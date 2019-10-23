/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author pc-hamma
 */
public class reclamation {
    private int IdReclamation;
    private String SubjectReclamation;
    private String DescriptionReclamation;
    private Date DateReclamation;
    private String StateReclamation;
    
    public reclamation(){}
    
    public reclamation(int IdReclamation, String SubjectReclamation,String DescriptionReclamation,Date DateReclamation,String StateReclamation )
    {
        this.IdReclamation=IdReclamation;
        this.SubjectReclamation=SubjectReclamation;
        this.DescriptionReclamation=DescriptionReclamation;
        this.DateReclamation=DateReclamation;
        this.StateReclamation=StateReclamation;
    }

   

    public int getIdReclamation() {
        return IdReclamation;
    }

    public void setIdReclamation(int IdReclamation) {
        this.IdReclamation = IdReclamation;
    }

    public String getSubjectReclamation() {
        return SubjectReclamation;
    }

    public void setSubjectReclamation(String SubjectReclamation) {
        this.SubjectReclamation = SubjectReclamation;
    }

    public String getDescriptionReclamation() {
        return DescriptionReclamation;
    }

    public void setDescriptionReclamation(String DescriptionReclamation) {
        this.DescriptionReclamation = DescriptionReclamation;
    }

    public Date getDateReclamation() {
        return DateReclamation;
    }

    public void setDateReclamation(Date DateReclamation) {
        this.DateReclamation = DateReclamation;
    }

    public String getStateReclamation() {
        return StateReclamation;
    }

    public void setStateReclamation(String StateReclamation) {
        this.StateReclamation = StateReclamation;
    }
    
    
    
}
