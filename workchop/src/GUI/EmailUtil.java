package GUI;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import static main.Config.*;
public class EmailUtil {

    
    public static  void sendEmail(String content){
    
        ConnectionRequest r = new ConnectionRequest();
        r.setUrl(MAIL_API_URL);
        r.setPost(true);
        
        //r.addRequestHeader("x-apikey", "bcb8c66bd822cc8a807b574c5f4a20e54da07");
        r.addRequestHeader("x-apikey", "c03ce06a5e2fe3bdb31ccb8e351c9d005d919");

        r.addArgument("to","raya.hadhri@esprit.tn");
        r.addArgument("subject", "Confirmation Commande");        
        r.addArgument("html", "Vous avez confirmer votre commande");
        r.addArgument("sendername", "Freesia");
        r.addArgument("company", "Freesia");
        
        NetworkManager.getInstance().addToQueueAndWait(r);
          
    }
}