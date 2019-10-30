/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Oussama
 */
public class membre {
    private int Cin;
    private String LasteName ;
    private String FirstName ;
    private String Email;
    private String Address;
    private int Number ;
    private String Login;
    private String Mdp ;
    private String Country;
    private String City;
    private int CodePostal;
    private String name;
    private int id;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(int CodePostal) {
        this.CodePostal = CodePostal;
    }

    public membre(int Cin, String LasteName, String FirstName, String Email, String Address, int Number, String Login, String Mdp, String Country, String City, int CodePostal) {
        this.Cin = Cin;
        this.LasteName = LasteName;
        this.FirstName = FirstName;
        this.Email = Email;
        this.Address = Address;
        this.Number = Number;
        this.Login = Login;
        this.Mdp = Mdp;
        this.Country = Country;
        this.City = City;
        this.CodePostal = CodePostal;
    }


    public membre(int Cin, String LasteName, String FirstName, String Email, String Address, int Number, String Login, String Mdp) {
        this.Cin = Cin;
        this.LasteName = LasteName;
        this.FirstName = FirstName;
        this.Email = Email;
        this.Address = Address;
        this.Number = Number;
        this.Login = Login;
        this.Mdp = Mdp;
    }

    public membre() {
        
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getLasteName() {
        return LasteName;
    }

    public void setLasteName(String LasteName) {
        this.LasteName = LasteName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "Cin=" + Cin + ", LasteName=" + LasteName + ", FirstName=" + FirstName + ", Email=" + Email + ", Address=" + Address + ", Number=" + Number + ", Login=" + Login + ", Mdp=" + Mdp + ", Country=" + Country + ", City=" + City + ", CodePostal=" + CodePostal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.Cin;
        hash = 23 * hash + Objects.hashCode(this.LasteName);
        hash = 23 * hash + Objects.hashCode(this.FirstName);
        hash = 23 * hash + Objects.hashCode(this.Email);
        hash = 23 * hash + Objects.hashCode(this.Address);
        hash = 23 * hash + this.Number;
        hash = 23 * hash + Objects.hashCode(this.Login);
        hash = 23 * hash + Objects.hashCode(this.Mdp);
        hash = 23 * hash + Objects.hashCode(this.Country);
        hash = 23 * hash + Objects.hashCode(this.City);
        hash = 23 * hash + this.CodePostal;
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
        final membre other = (membre) obj;
        if (this.Cin != other.Cin) {
            return false;
        }
        if (this.Number != other.Number) {
            return false;
        }
        if (this.CodePostal != other.CodePostal) {
            return false;
        }
        if (!Objects.equals(this.LasteName, other.LasteName)) {
            return false;
        }
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        if (!Objects.equals(this.Mdp, other.Mdp)) {
            return false;
        }
        if (!Objects.equals(this.Country, other.Country)) {
            return false;
        }
        if (!Objects.equals(this.City, other.City)) {
            return false;
        }
        return true;
    }

 
   
}
