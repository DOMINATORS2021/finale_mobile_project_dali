/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.entities.Participe;
import com.mycompany.myapp.entities.Feed;
import com.mycompany.myapp.services.ServiceFeed;
import com.mycompany.myapp.services.ServiceParticipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class EventDetail extends Form {

    private int ok, x, y = 0;
    private boolean z;
    private int idUser = 1;
    ArrayList<Feed> list;

    public EventDetail(Event a, com.codename1.ui.util.Resources resourceObjectInstance) {
        ok = initK(a.getId(), a.getNbrParticipant());
        setTitle(a.getNom());

        setLayout(BoxLayout.y());

        ServiceParticipe eventsdao = new ServiceParticipe();
        Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Multi_Button_1);
        MultiButton gui_LA = new com.codename1.components.MultiButton();
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");

        gui_Multi_Button_1.setPropertyValue("line1", a.getDateDebut());
        gui_Multi_Button_1.setPropertyValue("line2", "#" + a.getOrganisateur());
        gui_Multi_Button_1.setPropertyValue("uiid1", a.getNom());
        gui_Multi_Button_1.setPropertyValue("uiid2", a.getNom());
        gui_LA.setUIID("Label");
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", a.getDateFin());
        gui_LA.setPropertyValue("line2", "à " + a.getAdresse());
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");

        Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        addComponent(gui_imageContainer1);
        gui_imageContainer1.setName("imageContainer1");
        Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Container_2.setName("Container_2");

        TextArea type = new com.codename1.ui.TextArea();
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.NORTH, type);

        type.setText("Type: " + a.getType());
        type.setUIID("typeSlightlySmallerFontLabelLeft");
        type.setName("type");

        TextArea num = new com.codename1.ui.TextArea();
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, num);

        num.setText("Numero: " + a.getNum());
        num.setUIID("aaaaSlightlySmallerFontLabelLeft");
        num.setName("num");

        TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Text_Area_1);

        gui_Text_Area_1.setText("Description: " + a.getDescription());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setName("Text_Area_1");

        Label gui_separator1 = new com.codename1.ui.Label();
        addComponent(gui_separator1);
        gui_separator1.setShowEvenIfBlank(true);

        int deviceWidth = Display.getInstance().getDisplayWidth();
        int deviceHeight = Display.getInstance().getDisplayHeight();
        Image placeholder = Image.createImage(deviceWidth, deviceWidth - 100, 0xbfc9d2);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        URLImage url = URLImage.createToStorage(encImage, a.getNomFile() + "act2", "http://localhost/HuntKingdom/web/Upload/" + a.getNomFile());
        ScaleImageLabel sl = new ScaleImageLabel(url);
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);

        num.setRows(2);
        num.setColumns(100);
        num.setGrowByContent(false);
        num.setEditable(false);

        type.setRows(2);
        type.setColumns(100);
        type.setGrowByContent(false);
        type.setEditable(false);

        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);

        Container gui_Container_3 = new com.codename1.ui.Container();
        addComponent(gui_Container_3);
        gui_Container_1.setName("Container_3");
        TextField text = new TextField();
        text.setUIID("SlightlySmallerFontLabelLeft");
        text.setText("nombre total de place: " + a.getNbrParticipantMax());
        TextField text1 = new TextField();
        text1.setUIID("SlightlySmallerFontLabelLeft");
        text1.setText("nombre de participant: " + a.getNbrParticipant());
        gui_Container_3.addComponent(text);
        gui_Container_3.addComponent(text1);

        text.setEditable(false);
        text1.setEditable(false);

        String k;
        if (ok == 0) {

            k = "participer";

        } else {
            k = "annuler";
        }

        Button participerP = new Button(k);
        addComponent(participerP);
        if (a.getNbrParticipant() == a.getNbrParticipantMax() && ok == 0 ) {
            participerP.setVisible(false);
            TextField t = new TextField();
            t.setUIID("SlightlySmallerFontLabelLeft");
            t.setText("aucune place pour reserver");
            gui_Container_3.addComponent(t);
        }

        participerP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (ok == 0) {
                    ok = 1;
                    eventsdao.participer(a.getId(), 1);
                    participerP.setText("annuler");
                    Message m = new Message("je veux participer a votre evenement, Merci");
                    Display.getInstance().sendMessage(new String[]{"serenity.russie@gmail.com"}, "demande de participation", m);
                    if (z) {
                        text1.setText("le nombre de place disponible: " + String.valueOf(x));
                    } else {
                        text1.setText("le nombre de place disponible: " + String.valueOf(y));
                    }
                } else {
                    ok = 0;
                    eventsdao.iparticiper(a.getId(), 1);
                    participerP.setText("participer");
                    if (z) {
                        text1.setText("le nombre de place disponible: " + String.valueOf(y));
                    } else {
                        text1.setText("le nombre de place disponible: " + String.valueOf(x));
                    }
                }
            }
        });

        Label gui_separator3 = new com.codename1.ui.Label();

        addComponent(gui_separator3);

        gui_separator3.setShowEvenIfBlank(
                true);

        gui_separator3.setUIID(
                "Separator");

        gui_separator3.setShowEvenIfBlank(
                true);

        TextArea comments = new com.codename1.ui.TextArea();
        addComponent(comments);

        comments.setText("Commentaires");
        comments.setUIID("SlightlySmallerFontLabelLeft");
        comments.setName("Text_Area_1");
        comments.setRows(2);
        comments.setColumns(100);
        comments.setGrowByContent(false);
        comments.setEditable(false);

        list = new ArrayList<>();
        list = ServiceFeed.getInstance().getFeed(a.getId());

        for (Feed p : list) {
            Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            addComponent(gui_Container_4);
            gui_Container_4.setName("Container_1");

            Label username = new Label(p.getUsername());
            gui_Container_4.add(com.codename1.ui.layouts.BorderLayout.WEST, username);
            Label date = new Label(p.getDate());
            gui_Container_4.add(com.codename1.ui.layouts.BorderLayout.EAST, date);
            TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
            gui_Container_4.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Text_Area_2);

            gui_Text_Area_2.setText(p.getDescription());
            gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
            gui_Text_Area_2.setName("Text_Area_1");
            gui_Text_Area_2.setRows(2);
            gui_Text_Area_2.setColumns(100);
            gui_Text_Area_2.setGrowByContent(false);
            gui_Text_Area_2.setEditable(false);
            Label gui_separator2 = new com.codename1.ui.Label();

            addComponent(gui_separator2);

            gui_separator2.setShowEvenIfBlank(
                    true);

            gui_separator2.setUIID(
                    "Separator");

            gui_separator2.setShowEvenIfBlank(
                    true);
        }
        Button valider = new Button("Valider");
        TextField com = new TextField("", "commentez", 20, TextArea.ANY);
        addComponent(com);
        addComponent(valider);
        valider.addActionListener(e -> {
            if ((com.getText().length() == 0)) {
                Dialog.show("Attention", "remplir le champ", new Command("OK"));
            } else {
                if (ServiceFeed.getInstance().ajouter(1, a.getId(), com.getText())) {
                    Dialog.show("succès", "commentaire ajouter", new Command("OK"));
                    new EventDetail(a, resourceObjectInstance).show();
                } else {
                    Dialog.show("ERROR", "errur côté serveur", new Command("OK"));
                }
            }

        });

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ListeEvenements(resourceObjectInstance).show());
    }

    public int initK(int n, int m) {
        x = m;
        ServiceParticipe pdao = new ServiceParticipe();
        List<Participe> Participes = pdao.getAll();
        for (Participe p : Participes) {
            if (p.getIdUser() == 1 && p.getIdEvent() == n) {
                y = m - 1;
                z = true;
                return 1;
            }
        }
        z = false;
        y = m + 1;
        return 0;
    }

}
