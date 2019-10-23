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
public class Company {
    
    
    private int IdCompany;
    private String NameCompany;
    private String EmailCompany;
    private String PasswordCompany;
    private int NumberCompany;
    private String AddressCompany;

    public Company(int IdCompany, String NameCompany, String EmailCompany, String PasswordCompany, int NumberCompany, String AddressCompany) {
        this.IdCompany = IdCompany;
        this.NameCompany = NameCompany;
        this.EmailCompany = EmailCompany;
        this.PasswordCompany = PasswordCompany;
        this.NumberCompany = NumberCompany;
        this.AddressCompany = AddressCompany;
    } 

    public Company() {
    }
  
    public int getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(int IdCompany) {
        this.IdCompany = IdCompany;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String NameCompany) {
        this.NameCompany = NameCompany;
    }

    public String getEmailCompany() {
        return EmailCompany;
    }

    public void setEmailCompany(String EmailCompany) {
        this.EmailCompany = EmailCompany;
    }

    public String getPasswordCompany() {
        return PasswordCompany;
    }

    public void setPasswordCompany(String PasswordCompany) {
        this.PasswordCompany = PasswordCompany;
    }

    public int getNumberCompany() {
        return NumberCompany;
    }

    public void setNumberCompany(int NumberCompany) {
        this.NumberCompany = NumberCompany;
    }

    public String getAddressCompany() {
        return AddressCompany;
    }

    public void setAddressCompany(String AddressCompany) {
        this.AddressCompany = AddressCompany;
    }

    @Override
    public String toString() {
        return "Company{" + "IdCompany=" + IdCompany + ", NameCompany=" + NameCompany + ", EmailCompany=" + EmailCompany + ", PasswordCompany=" + PasswordCompany + ", NumberCompany=" + NumberCompany + ", AddressCompany=" + AddressCompany + '}';
    }


   
}
