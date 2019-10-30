/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Service.ServiceDelivery;
import Service.ServicePromotion;
import entities.Delivery;
import entities.Promotion;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ines bouguerra
 */
public class ConnextionBD {

    static String url = "jdbc:mysql://localhost:3306/freesia";
    static String login = "root";
    static String pwd = "";
    static Connection con;
    private static ConnextionBD data;
    static Statement ste;

    public static void main(String[] args) throws ParseException, Exception {
        try {

            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("conenection établie");
            } catch (SQLException ex) {
            System.out.println(ex);
        }

            /**
             */
            /*ServicePromotion service = new ServicePromotion();
            ServiceDelivery serviceD = new ServiceDelivery();
            java.util.Date utilDate;
            utilDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-09");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
            Promotion p2 = new Promotion(77, "p8", 12, sqlDate, sqlDate1, "iiii", "eee");
            Promotion p3 = new Promotion(500, "p3", 12, sqlDate, sqlDate1, "ines", "e3333ee");
            Delivery v1 = new Delivery(1, sqlDate, "h", "i");
            Delivery v2 = new Delivery(5, sqlDate, "hh", "ii");
            Delivery v3 = new Delivery(3, sqlDate, "hhh", "iii");*/
            //service.ajouterPromotion1(p3);
            //serviceD.ajouterDelivery(v1);
            //serviceD.ajouterDelivery(v2);
            //serviceD.ajouterDelivery(v3);
            //serviceD.supprimerDelivery(5);
            //List<Delivery> deliveries = null;
            //deliveries = new ArrayList<>();
            //deliveries=serviceD.readAllDelivery();
            //serviceD.modifierDelivery(1);
            //serviceD.modifierDelivery1(v2);
            //deliveries=serviceD.readAllDelivery();
            //System.out.println(deliveries);
            //service.ajouterPromotion1(p3);
            //service.supprimerPromotion(2);
            //List<Promotion> promotions = null;
            //promotions = new ArrayList<>();
            //promotions = service.readAll();
            //System.out.println(promotions);
            //service.modierPromotion2(1,p3);
            //System.out.println(promotions);
            
        

    }

    private ConnextionBD() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   

    public Connection getConnection() {
        return con;
    }
    public static ConnextionBD getInstance() {
        if (data == null) {
            data = new ConnextionBD();
        }
        return data;
    }
}
