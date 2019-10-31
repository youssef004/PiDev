/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testFXML;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;



/**
 *
 * @author Youssef
 */
public class Whatsapp {
    
    
    // Install the Java helper library from twilio.com/docs/java/install



    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC61858dec2acb8c174114e421949102ec";
    public static final String AUTH_TOKEN = "7fbf59475ecff8b5087dcbd31aeeb4c8";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+21654848436"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "the product has been added")
            .create();

        System.out.println(message.getSid());
    }

}
