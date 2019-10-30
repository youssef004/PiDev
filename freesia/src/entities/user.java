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
public class user {
    private int Cin;
    private String LastName;
    private String FirstName;
    private String Email;
    private String Address;
    private int Number;
    private String Login;
    private String Mdp;
    private String State;
    
    public user(){}
    
    public user(int Cin, String LastName, String FirstName, String Email, String Address, int Number, String Login, String Mdp, String State){
    this.Cin=Cin;
    this.LastName=LastName;
    this.FirstName=FirstName;
    this.Email=Email;
    this.Address=Address;
    this.Number=Number;
    this.Login=Login;
    this.Mdp=Mdp;
    this.State=State;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
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
    
    
    
}
