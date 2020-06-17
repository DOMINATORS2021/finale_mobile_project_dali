/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.ServiceProduit;



/**
 *
 * @author PCS
 */
public class AddProduit extends Form{
    public AddProduit(Form previous){
        setTitle("Add a new Product");
        
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","ProductName");
        //TextField tfmarque = new TextField("","Type");
        ComboBox type = new ComboBox("Hunting","Fishing");
        TextField tfprix = new TextField("","Prix");
        TextField tfquantite = new TextField("","Quantite");
        
      
        Button btnValider = new Button("Add Produit");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfprix.getText().length()==0) ||(tfquantite.getText().length()==0) )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Produit p = new Produit(tfName.getText(),Integer.parseInt(tfquantite.getText()),Double.parseDouble(tfprix.getText()),String.valueOf(type.getSelectedItem()));
                        if( ServiceProduit.getInstance().addProduit(p))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                       
                    }
                    
                }
                
                
            }
        });
       
        
        
    
        
        addAll(tfName,type,tfprix,tfquantite,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}
