/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceCommande;
import com.codename1.capture.Capture;
import com.codename1.io.Log;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.Map;


/**
 *
 * @author oumyma houmrani
 */
public class addCommande {
    Resources theme;
    private Form f10;
    public static final String ACCOUNT_SID = "AC9422bdb073ff17859eb6c7f2af574cb5";
    public static final String AUTH_TOKEN = "bc51373481296767685b7ce381ad3f7a";
    TableLayout tl;

    public addCommande() {
        f10 = new Form("ajouter une commande");
        TableLayout tl;
        int spanButton = 2;
        if (Display.getInstance().isTablet()) {
            tl = new TableLayout(7, 2);
        } else {
            tl = new TableLayout(14, 1);
            spanButton = 1;
        }
        tl.setGrowHorizontally(true);
        f10.setLayout(tl);
        Picker Ddate = new Picker();
        TextField nom = new TextField("", "Name");
        TextArea quantiteC = new TextArea(5, 20);
        quantiteC.setHint("Quantity");
        Font materialFont = FontImage.getMaterialDesignFont();
        int size = Display.getInstance().convertToPixels(6, true);
        materialFont = materialFont.derive(size, Font.STYLE_PLAIN);
        Button btnadd = new Button("Save");
        btnadd.setIcon(FontImage.create("\uE161", btnadd.getUnselectedStyle(),
                materialFont));
        Button btndisplay = new Button("Display");

        TableLayout.Constraint cn = tl.createConstraint();
        cn.setHorizontalSpan(spanButton);
        cn.setHorizontalAlign(Component.RIGHT);
        f10.add("Date").add(Ddate).
                add("Nom Commande").add(nom).
                add("Your Quantity").add(quantiteC).
                add(GridLayout.encloseIn(2, btnadd, btndisplay));
        Button b = new Button("Freesia Details");
        b.getAllStyles().setBorder(Border.createEmpty());
        b.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
        f10.add(b);
        b.addActionListener((e) -> Log.p("Clicked"));
        f10.show();
        btndisplay.addActionListener((e) -> {
            try {
                    Commandeform rs=new Commandeform();
                    
                    rs.alleven();
                } catch (IOException ex) {
                }
                            
        });
        btnadd.addActionListener(e-> {
              ServiceCommande ser = new ServiceCommande();
              
            ser.addCommande (nom.getText (),quantiteC.getText() ); 
          
            try {
                new Commandeform().alleven();
            } catch (IOException ex) {
            }
        
        });
        
                Label picture = new Label("", "Container");
f10.add(picture);
f10.getUnselectedStyle().setBgColor(0x0FFFF);
f10.getUnselectedStyle().setBgTransparency(255);
Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
Image camera = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
f10.getToolbar().addCommandToRightBar("", camera, (ev) -> {
    try {
        int width = Display.getInstance().getDisplayWidth();
        Image capturedImage = Image.createImage(Capture.capturePhoto(width, -1));
        Image roundMask = Image.createImage(width, capturedImage.getHeight(), 0xff000000);
        Graphics gr = roundMask.getGraphics();
        gr.setColor(0xffffff);
        gr.fillArc(0, 0, width, width, 0, 360);
        Object mask = roundMask.createMask();
        capturedImage = capturedImage.applyMask(mask);
        picture.setIcon(capturedImage);
        f10.revalidate();
    } catch(IOException err) {
        Log.e(err);
    }
});
    
}
    public Form getF10() {
        return f10;
    }
}
