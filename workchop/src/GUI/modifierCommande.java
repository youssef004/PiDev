/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Commande;
import Service.ServiceCommande;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author oumyma houmrani
 */
public class modifierCommande {
    Resources theme;
    private Form f11;
    public static final String ACCOUNT_SID = "AC9422bdb073ff17859eb6c7f2af574cb5";
    public static final String AUTH_TOKEN = "bc51373481296767685b7ce381ad3f7a";
    TableLayout tl;
    ServiceCommande Servicecommande;
    List<Commande> commandeList;
   

    public modifierCommande() {
        Commande c=new Commande();
        f11 = new Form("modify quantity");
        TableLayout tl;
        int spanButton = 2;
        if (Display.getInstance().isTablet()) {
            tl = new TableLayout(7, 2);
        } else {
            tl = new TableLayout(14, 1);
            spanButton = 1;
        }
        tl.setGrowHorizontally(true);
        f11.setLayout(tl);
        Button saveBtn = new Button("OK");
        saveBtn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN,15));

        Picker Ddate = new Picker();
        TextField nomc = new TextField(c.getNomcommande());
        TextField quantiteC = new TextField(c.getQuantitecommande());
        
        Font materialFont = FontImage.getMaterialDesignFont();
        int size = Display.getInstance().convertToPixels(6, true);
        materialFont = materialFont.derive(size, Font.STYLE_PLAIN);

        TableLayout.Constraint cn = tl.createConstraint();
        cn.setHorizontalSpan(spanButton);
        cn.setHorizontalAlign(Component.RIGHT);
        f11.add("Date").add(Ddate).
             
                add("Your Quantity").add(quantiteC).
                add(GridLayout.encloseIn(1, saveBtn));
        f11.show();
        
        saveBtn.addActionListener(e-> {
              ServiceCommande ser = new ServiceCommande();
              
          ser.modifierCommande( quantiteC.getText());
           System.out.println(quantiteC.getText());
            Dialog.show("quantity modified successfuly","", "Display All commandes", null);
                Commandeform alo = new Commandeform();
                        try {
                            ser.modifierCommande( quantiteC.getText());
                            alo.alleven();
                            
                        } catch (IOException ex) {
                        }
                    alo.getaffann().show();
           
           
            
           
            }
       );
    
}

   
    public Form getF11() {
        return f11;
    }
}
