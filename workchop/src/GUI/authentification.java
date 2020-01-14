/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.fos_user;
import Service.Serviceauthentification;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author Oussama
 */
public class authentification {

    Form f;
    String UserName;
    Resources res;

    public void authentification() {

        Serviceauthentification ser = new Serviceauthentification();
        f = new Form("welcome to freesia", BoxLayout.y());
        TextField user = new TextField("", "User Name");
        TextField pass = new TextField("", "password", 10, TextArea.PASSWORD);

        Button SignIn = new Button("SignIn");
        Button Login = new Button("Login");

        Label userl = new Label("UserName");
        Label passl = new Label("Password");

        userl.getAllStyles().setFgColor(0x471CBD);
        userl.getAllStyles().setTextDecoration(Style.BACKGROUND_GRADIENT_RADIAL);
        passl.getAllStyles().setFgColor(0x471CBD);
        passl.getAllStyles().setTextDecoration(Style.BACKGROUND_GRADIENT_RADIAL);

        Container cx = new Container(BoxLayout.x());
        Container cx1 = new Container(BoxLayout.x());
        Container cx2 = new Container(new FlowLayout(CENTER, CENTER));
        cx.add(userl);
        cx.add(user);
        cx1.add(passl);
        cx1.add(pass);
        cx2.add(Login);
        cx2.add(SignIn);
        f.add(cx);
        f.add(cx1);
        f.add(cx2);
        Label controleuser = new Label("");
        Label controlepass = new Label("");
        Label controletext = new Label("");
        Login.addActionListener((evt) -> {
            ArrayList<fos_user> a = new ArrayList();
            if (!user.getText().isEmpty()) {
                a = ser.getList1(user.getText());

                System.out.println(a);
                if (!a.isEmpty()) {
                    for (fos_user mr : a) {
                        if (mr.getPassword().equals(pass.getText())) {
                            System.out.println("hello");
                            Acceuil acc = new Acceuil();
                            acc.acceuil(UserName);
                            acc.getF1().show();

                            UserName = user.getText();
                            authentification ao = new authentification();

                            // al.ge().show();
                        } else {
                            controlepass.setText("password incorrect");
                            f.refreshTheme();
                        }
                    }
                } else {
                    controleuser.setText("username introuvable");
                    f.refreshTheme();
                }
            } else {
                controletext.setText("text field vide");
                f.refreshTheme();
            }
        });

        user.addDataChangedListener((type, u) -> {

            controleuser.setText("");
            controletext.setText("");
            f.refreshTheme();
        });
        user.addDataChangedListener((type, index) -> {
            controlepass.setText("");
            f.refreshTheme();
        });
        f.add(controleuser);
        f.add(controletext);
        f.add(controlepass);

    }

    public Form getF() {
        return f;
    }

}