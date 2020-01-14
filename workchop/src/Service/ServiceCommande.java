/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entity.Commande;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ines bouguerra
 */
public class ServiceCommande {

    public ArrayList<Commande> getcommande() {
        ArrayList<Commande> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/integration/web/app_dev.php/pidev/mobcomm");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(tasks);
                    //System.out.println(tasks);
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Commande task = new Commande();
                       
                      
                       float idcommande = Float.parseFloat(obj.get("idcommande").toString());
                       float prixcommande = Float.parseFloat(obj.get("prixcommande").toString());
                       float quantitecommande = Float.parseFloat(obj.get("quantitecommande").toString());
//                       float nomfavoris = Float.parseFloat(obj.get("nomFavoris").toString());
                       
                       task.setIdcommande((int) idcommande);
                       task.setNomcommande(obj.get("nomcommande").toString());
                       task.setPrixcommande((int) prixcommande);
                       task.setQuantitecommande((int) quantitecommande);
                       LinkedHashMap map = ((LinkedHashMap) obj.get("date"));
                        Double i = (Double) map.get("timestamp");
                        java.util.Date time = new java.util.Date((long) i.longValue() * 1000);
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                        task.setDate(f.format(time));
                     //  task.setNomfavoris((int) nomfavoris);
                      
                       System.out.println("eeee"+task.getIdcommande()+"ddd"+task.getNomcommande()+"task."+task.getPrixcommande()+"erererer"+task.getQuantitecommande()+"ererrerer"+task.getDate()+"rrr"+task.getNomfavoris());
                      // hm.put(obj.get("username").toString(),obj.get("mail").toString());
                      System.out.println(task);
                        listTasks.add(task);
                      

                    }
                        //System.out.println(listTasks);
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return listTasks;
    }
    
 String resp = "";
      public String addCommande(String nom, String quantite) { //, String image,String status , String price, String quantity){ //} ,int idUser,int idCategory){

        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("POST");

        con.addArgument("nom", nom);
        System.out.println("aloo"+nom);
        con.addArgument("quantite", quantite);
        
        
        con.setUrl("http://localhost/integration/web/app_dev.php/pidev/ajout?nom="+nom+"&quantite="+quantite+"&state=0&date=%2222/04/2020%22");
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    resp = new String(con.getResponseData());
                   // System.out.println("aaaaaaaaaaaaaaaaaaaa"+resp);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);//pour etablir la conx
        //System.err.println(resp);
        return resp;
    }
    
     
     public void sendMail(){
       
         Message m = new Message("<html><body>Check out <a href=\"https://www.codenameone.com/\">Codename One</a></body></html>");
        m.setMimeType(Message.MIME_HTML);

// notice that we provide a plain text alternative as well in the send method
        boolean success = m.sendMessageViaCloudSync("Codename One", "hadhriraya@gmail.com", "Name Of User", "Message Subject",
                            "Check out Codename One at https://www.codenameone.com/");
         System.out.println("success: "+success);
    }

         public void modifierCommande(String quantite){
      ConnectionRequest concom = new ConnectionRequest();
      Commande r=new Commande();
        concom.setPost(true);
        concom.setHttpMethod("POST");
        concom.addArgument("quantite",String.valueOf(r.getQuantitecommande()));
      
       String url = "http://localhost/integration/web/app_dev.php/pidev/modif/24?quantite"+quantite;
    
               concom.setUrl(url);
  
        NetworkManager.getInstance().addToQueueAndWait(concom);
        System.out.println("added Succefully");
    }
     
     
    
}