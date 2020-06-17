/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.components.ToastBar;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.gui.AddProduit;
import com.mycompany.myapp.gui.BudgetPieChart;
import com.mycompany.myapp.gui.ChartDemosForm;
import com.mycompany.myapp.gui.ListeDesProduitsMg;
import com.mycompany.myapp.gui.ListeEvenements;
import com.mycompany.myapp.gui.ListeProduits;
import com.mycompany.myapp.gui.ListeProduitsEnPromotion;

/**
 * Common code that can setup the side menu
 *
 * @author Shai Almog
 */
public abstract class SideMenuBaseForm extends Form {
  
        
    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("mentor.png");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        
        getToolbar().addComponentToSideMenu(sidemenuTop);
        //getToolbar().addMaterialCommandToSideMenu("Ajout Des Categorie", FontImage.MATERIAL_DASHBOARD,  e -> new AddCategorie(this).show());
       
        getToolbar().addMaterialCommandToSideMenu("Ajout Des Produits", FontImage.MATERIAL_DASHBOARD,  e -> new AddProduit(this).show());
       
        getToolbar().addMaterialCommandToSideMenu("All Products", FontImage.MATERIAL_LIST,  e -> new ListeProduits(res).show());
        getToolbar().addMaterialCommandToSideMenu("Promotions ", FontImage.MATERIAL_LIST,  e -> new ListeProduitsEnPromotion(res).show());
        getToolbar().addMaterialCommandToSideMenu("Amount by product", FontImage.MATERIAL_PIE_CHART,  e -> new ChartDemosForm().show());
        getToolbar().addMaterialCommandToSideMenu("Evenements ", FontImage.MATERIAL_LIST,  e -> new ListeEvenements(res).show());
        getToolbar().addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_ACCOUNT_CIRCLE,  e -> new ProfileForm(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
    }
    
   
    
    protected abstract void showOtherForm(Resources res);
}
