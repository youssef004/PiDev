/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Commande;
import Entity.fos_user;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.BrowserComponent;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author Oussama
 */
public class Acceuil {
    Form f1;
    Form f2,f3;
        String subject;

    private Resources theme;
     public Form getF() {
        return f1;
    }
    public void acceuil(String username){
 theme = UIManager.initFirstTheme("/theme");
   
    f1=new Form("Acceuil",new FlowLayout(CENTER,CENTER));
    f2=new Form("Shop",new FlowLayout(CENTER,CENTER));
    f3=new Form("Plants",new FlowLayout(CENTER,CENTER));
  
     Toolbar tb=f1.getToolbar();
         
     
     BrowserComponent browser = new BrowserComponent();
        browser.setURL("http://localhost/integration/web/app_dev.php/pidev/home");
        f1.add(browser);
    
        tb.addMaterialCommandToLeftSideMenu("Annonce", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
            }


     
    
        });
    
        tb.addMaterialCommandToLeftSideMenu("Plants", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 BrowserComponent browser = new BrowserComponent();
                browser.setURL("http://localhost/integration/web/app_dev.php/pidev/homeProduit");
                 f3.add(browser);
                 
                f3.getToolbar().addCommandToLeftBar("back", null, ev -> {f1.show(); });
                f3.show();
            }
        });
    
     tb.addMaterialCommandToLeftSideMenu("Shop", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                                    
             Commandeform b = new Commandeform();
                try {
                    b.alleven();
                             } catch (IOException ex) {
                             }
                        b.getaffann().show();

            }

        });

      tb.addMaterialCommandToLeftSideMenu("Annonce", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            
                                    
            }
        });
         tb.addMaterialCommandToLeftSideMenu("Reclamation", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
            }
        });
         
       f1.getToolbar().addCommandToOverflowMenu("exit", null, e->{Display.getInstance().exitApplication();});//pour sortir de lapp definitif

         
    
    Toolbar tb1 = f2.getToolbar();
        tb1.addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
    
    } 
     public Form getF1() {
        return f1;
    }
    
   
}