/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author pc-hamma
 */
public class Admin {
    private int CinAdmin;
    private String FirstNameAdmin;
    private String LasttNameAdmin;
    private String EmailAdmin;
    private String PwdAdmin;
    

public Admin(){}
public Admin(int CinAdmin, String FirstNameAdmin, String LastNameAdmin, String EmailAdmin, String PwdAdmin){
    this.CinAdmin=CinAdmin;
    this.FirstNameAdmin=FirstNameAdmin;
    this.LasttNameAdmin=LastNameAdmin;
    this.EmailAdmin=EmailAdmin;
    this.PwdAdmin=PwdAdmin;
    
}

    public int getCinAdmin() {
        return CinAdmin;
    }

    public void setCinAdmin(int CinAdmin) {
        this.CinAdmin = CinAdmin;
    }

    public String getFirstNameAdmin() {
        return FirstNameAdmin;
    }

    public void setFirstNameAdmin(String FirstNameAdmin) {
        this.FirstNameAdmin = FirstNameAdmin;
    }

    public String getLasttNameAdmin() {
        return LasttNameAdmin;
    }

    public void setLasttNameAdmin(String LasttNameAdmin) {
        this.LasttNameAdmin = LasttNameAdmin;
    }

    public String getEmailAdmin() {
        return EmailAdmin;
    }

    public void setEmailAdmin(String EmailAdmin) {
        this.EmailAdmin = EmailAdmin;
    }

    public String getPwdAdmin() {
        return PwdAdmin;
    }

    public void setPwdAdmin(String PwdAdmin) {
        this.PwdAdmin = PwdAdmin;
    }




}

