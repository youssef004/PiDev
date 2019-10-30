/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Oussama
 */
public class Menbrecurrent {
     static int Cin;
    static String LasteName ;
    static String FirstName ;
    static String Email;
    static String Address;
    static int Number ;
    static String Login;
    static String Mdp ;
    static String Country;
    static String City;
    static int CodePostal;
    static String name;
    static int id;
    
    
    
    public Menbrecurrent() {
    }
    
    public Menbrecurrent(Menbrecurrent M) {
       Cin = M.Cin;
        LasteName =  M.LasteName;
        FirstName =  M.FirstName;
        Email =  M.Email;
        Address =  M.Address;
        Number =  M.Number;
        Login =  M.Login;
        Mdp =  M.Mdp;
        Country =  M.Country;
        City =  M.City;
        CodePostal =  M.CodePostal;
    }
    
    
    

    public static int getCin() {
        return Cin;
    }

    public static void setCin(int Cin) {
        Menbrecurrent.Cin = Cin;
    }

    public static String getLasteName() {
        return LasteName;
    }

    public static void setLasteName(String LasteName) {
        Menbrecurrent.LasteName = LasteName;
    }

    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String FirstName) {
        Menbrecurrent.FirstName = FirstName;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        Menbrecurrent.Email = Email;
    }

    public static String getAddress() {
        return Address;
    }

    public static void setAddress(String Address) {
        Menbrecurrent.Address = Address;
    }

    public static int getNumber() {
        return Number;
    }

    public static void setNumber(int Number) {
        Menbrecurrent.Number = Number;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String Login) {
        Menbrecurrent.Login = Login;
    }

    public static String getMdp() {
        return Mdp;
    }

    public static void setMdp(String Mdp) {
        Menbrecurrent.Mdp = Mdp;
    }

    public static String getCountry() {
        return Country;
    }

    public static void setCountry(String Country) {
        Menbrecurrent.Country = Country;
    }

    public static String getCity() {
        return City;
    }

    public static void setCity(String City) {
        Menbrecurrent.City = City;
    }

    public static int getCodePostal() {
        return CodePostal;
    }

    public static void setCodePostal(int CodePostal) {
        Menbrecurrent.CodePostal = CodePostal;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Menbrecurrent.name = name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Menbrecurrent.id = id;
    }

    

    
    
}
