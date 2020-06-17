package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.ServiceProduit;

import java.util.ArrayList;



public class ListeDesProduitsMg extends SideMenuBaseForm  {
   
    ArrayList<Produit> list;
   private Resources theme;
  
    
    private Resources resourceObjectInstance;

    
    
    public ListeDesProduitsMg(Resources res) {
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
                                    new Label("Produits Magasin", "Title")
                                )
                            )
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
       
         list=new ArrayList<>();
         list=ServiceProduit.getInstance().getAllProduits();
        
          
         for(Produit p:list){
            if(p.getPrix_Mg()!=0){
                
          
          Container c1=new Container(BoxLayout.y());
          Label l=new Label(p.getNom());
            c1.add(l);
             add(c1);
           
      
            
             l.addPointerPressedListener(e->{
                Form f2=new Form("Détails Produits", BoxLayout.y());
                SpanLabel sp=new SpanLabel("Détails produit");
                sp.setWidth(20);
                //ImageViewer uni = new ImageViewer(theme.getImage("uni.jpg"));
                SpanLabel spl=new SpanLabel("Nom du produit : "+"  "+p.getNom());
                SpanLabel spl2=new SpanLabel("Type : "+"  "+p.getType());
                SpanLabel spl3=new SpanLabel("Prix : "+"  "+p.getPrix_Mg());
                SpanLabel spl4=new SpanLabel("Quantite : "+"  "+p.getNvquantite());
                
                Container c2 = new Container(BoxLayout.x());
                ShareButton sh = new ShareButton();
                LikeButton li = new LikeButton();
                c2.addAll(sh,li);
                Container c3 = new Container(BoxLayout.y());
                f2.setScrollableY(true);
                c3.addAll(sp,spl,spl2,spl3,spl4);
             
                f2.addAll(c3,c2);


                f2.getToolbar().addCommandToLeftBar("Back", null, ev->{
                    this.show();
                });
                f2.show();
               
            });
            c1.setLeadComponent(l);
           
         
            }
            }
        
        setupSideMenu(res);
        
       
      
         } 
    
    /*private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }*/

    @Override
    protected void showOtherForm(Resources res) {
    }
    

    
     /*   void search(String text) {
        if(text == null || text.length() == 0) {
               System.out.println("sss");
                c1.setHidden(false);
               c1.setVisible(true);
               
            }
        else {
              for(Component c1 :getContentPane())
              {
                //  System.out.println(c1.);
                  text = text.toLowerCase();
        }
        }
        getContentPane().animateLayout(200);
    }

*/
  
   
  
}
