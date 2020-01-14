/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Commande;
import com.codename1.components.InfiniteScrollAdapter;
import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import Service.ServiceCommande;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author ines bouguerra
 */
public class Commandeform {
    Form aff = new Form("Commande",new FlowLayout(CENTER,CENTER));
    private Resources theme;

    public void alleven() throws IOException {
        ArrayList<Commande> Commande = new ArrayList<>();
        ServiceCommande sa = new ServiceCommande();
        Commande = sa.getcommande();
        Container gridLay = new Container(new GridLayout(2, 2));
        for (Commande c : Commande) {
            affichersingle(c);
        }
        
         TextField searchField = new TextField("", "Search"); // <1>
Style s = UIManager.getInstance().getComponentStyle("Title");

searchField.getAllStyles().setAlignment(Component.LEFT);
        aff.getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
                
        searchField.addDataChangeListener((i1, i2) -> {
            String t = searchField.getText();
            if (t.length() < 1) {
                for (Component cmp : aff.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for (Component cmp : aff.getContentPane()) {
                    String val = null;
                    if (cmp instanceof Label) {
                        val = ((Label) cmp).getText();}
                        
                    else if (cmp instanceof TextArea) {
                        val = ((TextArea) cmp).getText();
                    } else {
                        val = (String) cmp.getPropertyValue("text");
                    }
                    boolean show = val != null && val.toLowerCase().indexOf(t)
                            > -1;
                    cmp.setHidden(!show);
                    cmp.setVisible(show);
                }
            }
            aff.getContentPane().animateLayout(250);
        });
        aff.getToolbar().addCommandToRightBar( "", searchIcon,(f) -> {
            searchField.startEditingAsync();
        });
  aff.show();
    }

    public void affichersingle(Commande c) throws IOException {
        
        Label l1 = new Label();
        l1.setText("Nom de la commande:  "+c.getNomcommande());
        aff.add(l1);
        Label l2 = new Label();
        l2.setText("Date:  "+c.getDate());
        aff.add(l2);
        
        Label l = new Label("Quantite:  "+Integer.toString(c.getQuantitecommande()));
        SpanLabel l3 = new SpanLabel("Prix:  "+Integer.toString((int) c.getPrixcommande()) + "DT");
        Button valider = new Button("Valider");
        Button ajouter = new Button("Ajouter");
         Button modify=new Button("Modify");
     
         FloatingActionButton fabD = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE_OUTLINE);
            RoundBorder rbD = (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rbD.uiid(true);
     
            FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
            RoundBorder rb= (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rb.uiid(true);
      
            FloatingActionButton fabM = FloatingActionButton.createFAB(FontImage.MATERIAL_UPDATE);
            RoundBorder rbM = (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rbM.uiid(true);
     
        aff.add(l3);
        aff.add(l);
        aff.add(fabM);
        aff.add(fab);
        aff.add(fabD);
        aff.add(valider);
        Toolbar.setGlobalToolbar(true);
         fabD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Confirmation", "delete this Article?", "Ok", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/integration/web/app_dev.php/pidev/supp/" + c.getIdcommande());
                        NetworkManager.getInstance().addToQueue(req);
                        Dialog.show("Suppression de l'", "Article "
                                + c.getNomcommande()+ "  a été supprimé avec succès!", "OK", null);
                        Commandeform cc = new Commandeform();
                    try {
                        cc.alleven();
                    } catch (IOException ex) {
                    }
                    cc.getaffann().show();
                    }
          
         };
         });
         
          fabM.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        modifierCommande commande=new modifierCommande();
                          commande.getF11().show();
            aff.getToolbar().addCommandToRightBar("back", null, new ActionListener() { //retouuuuuuuuuuuuuuuuuuuurrr
            @Override
            public void actionPerformed(ActionEvent evt) {
                Acceuil f = new Acceuil();
                f.acceuil(resp);
           
                   f.getF().show();
            }
        });
              }
          });
          valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EmailUtil email=new EmailUtil();
                        email.sendEmail(resp);
                ToastBar.showErrorMessage("Email a été envoyé");
         
            }
        });
     /* aff.getToolbar().addCommandToLeftBar("back", null,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 Acceuil a=new Acceuil();
          a.getF().show();}
            
        });*/
      fab.addActionListener(e-> {
              addCommande ser = new addCommande();
          ser.getF10().show();
                //new Commandeform().addCommande(resp, resp);
         
        });
     aff.getToolbar().addCommandToRightBar("back", null, new ActionListener() { //retouuuuuuuuuuuuuuuuuuuurrr
            @Override
            public void actionPerformed(ActionEvent evt) {
                Acceuil f = new Acceuil();
                f.acceuil(resp);
                f.getF().show();
                  ToastBar.showErrorMessage("commande ajouter!");
            }
        });
}
         
 
    public Form getaffann() {

        return aff;
    }
    String resp="";
    
    
    /*public String addCommande(String commande1 ,String commande2){ //, String image,String status , String price, String quantity){ //} ,int idUser,int idCategory){

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/integration/web/app_dev.php/pidev/ajout");
        con.setHttpMethod ( "POST" );
        con.addArgument("commande1", commande1);
        con.addArgument("commande1", commande2);

        con.addResponseListener(new ActionListener<NetworkEvent> () {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    resp = new String(con.getResponseData());
                    System.out.println(resp);
                }
                catch(Exception e){
                    e.getMessage();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);//pour etablir la conx
        System.err.println ( resp );
        return resp;
    }*/
  
}


























