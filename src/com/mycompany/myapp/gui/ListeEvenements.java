/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.ServiceEvenement;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ListeEvenements extends SideMenuBaseForm {

    ArrayList<Event> list;
    private Resources theme;

    private Resources resourceObjectInstance;

    public ListeEvenements(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("Evenements", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

        list = new ArrayList<>();
        list = ServiceEvenement.getInstance().getAllEvents();

        for (Event p : list) {
            Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            addComponent(gui_Container_1);
            gui_Container_1.setName("Container_1");
            MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Multi_Button_1);
            MultiButton gui_LA = new com.codename1.components.MultiButton();
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
            gui_Multi_Button_1.setUIID("Label");
            gui_Multi_Button_1.setName("Multi_Button_1");

            gui_Multi_Button_1.setPropertyValue("line1", p.getNom());
            gui_Multi_Button_1.setPropertyValue("line2", "#" + p.getOrganisateur());
            gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
            gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
            gui_LA.setUIID("Label");
            gui_LA.setName("LA");
            gui_LA.setPropertyValue("line1", p.getDateDebut());
            gui_LA.setPropertyValue("line2", "à " + p.getAdresse());
            gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            gui_LA.setPropertyValue("uiid2", "RedLabelRight");

            Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            addComponent(gui_imageContainer1);
            gui_imageContainer1.setName("imageContainer1");
            Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
            gui_Container_2.setName("Container_2");
            TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
            Button gui_Button_1 = new com.codename1.ui.Button();
            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);

            gui_Text_Area_1.setText(p.getDescription());
            gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
            gui_Text_Area_1.setName("Text_Area_1");
            gui_Button_1.setText("");
            gui_Button_1.setUIID("Label");
            gui_Button_1.setName("Button_1");
            gui_Button_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EventDetail(
                            new Event(
                                    p.getId(),
                                    p.getNomFile(),
                                    p.getNom(),
                                    p.getType(),
                                    p.getAdresse(),
                                    p.getOrganisateur(),
                                    p.getDateDebut(),
                                    p.getDateFin(),
                                    p.getNum(),
                                    p.getDescription(),
                                    p.getNbrParticipant(),
                                    p.getNbrParticipantMax()),
                            res).show();
                }

            }
            );
            com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,
                    '');
            gui_Button_1.setPressedIcon(com.codename1.ui.FontImage.createMaterial('', gui_Button_1.getStyle()));

            gui_Container_2.setName(
                    "Container_2");
            Label gui_separator1 = new com.codename1.ui.Label();

            addComponent(gui_separator1);

            gui_separator1.setShowEvenIfBlank(
                    true);

            int deviceWidth = Display.getInstance().getDisplayWidth();
            int deviceHeight = Display.getInstance().getDisplayHeight();
            Image placeholder = Image.createImage(deviceWidth -50, deviceWidth - 100, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);

            URLImage url = URLImage.createToStorage(encImage, p.getNomFile() , "http://localhost/HuntKingdom/web/Upload/" + p.getNomFile());
            ScaleImageLabel sl = new ScaleImageLabel(url);

            sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

            gui_imageContainer1.add(BorderLayout.CENTER, sl);

            FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);

            gui_LA.setIconPosition(BorderLayout.EAST);

            gui_Text_Area_1.setRows(
                    2);
            gui_Text_Area_1.setColumns(
                    100);
            gui_Text_Area_1.setGrowByContent(
                    false);
            gui_Text_Area_1.setEditable(
                    false);

            gui_separator1.setUIID(
                    "Separator");

            gui_separator1.setShowEvenIfBlank(
                    true);
        }

        setupSideMenu(res);

    }

    @Override
    protected void showOtherForm(Resources res) {
    }

}
