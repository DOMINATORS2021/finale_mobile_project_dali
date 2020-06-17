/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycomapny.myapp.utils.Statics;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.gui.ListeProduits;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 *
 * @author PCS
 */
public class ServiceProduit {
   
    public ArrayList<Produit> produits;
    public static ServiceProduit instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public ServiceProduit(){
        req= new ConnectionRequest();
        
    }
    
    public static ServiceProduit getInstance(){
        if(instance==null){
           instance = new ServiceProduit();
        }
        return instance;
    }
    
    public ArrayList<Produit> parseProduits(String jsonText) throws IOException{
        
        produits= new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String,Object> produitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String,Object>> list = (List<Map<String,Object>>)produitsListJson.get("root");
        for(Map<String,Object> obj : list){
            Produit p = new Produit();
            float id = Float.parseFloat(obj.get("id").toString());
            p.setId((int)id);
            p.setNom(obj.get("nom").toString());
            p.setQuantite((int)Float.parseFloat(obj.get("quantite").toString()));
            p.setPrix((double)Float.parseFloat(obj.get("prix").toString()));
            p.setType(obj.get("type").toString());
            p.setNvquantite((int)Float.parseFloat(obj.get("nvquantite").toString()));
            p.setNvprix((double)Float.parseFloat(obj.get("nvprix").toString()));
            
            
            
            produits.add(p);
        }
     return produits ;
    }
     
    
    
       
    public ArrayList<Produit> getAllProduits(){
        String url = Statics.BASE_URL+"/ProduitsMob";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    produits = parseProduits(new String(req.getResponseData()));
                } catch (IOException ex) {
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
        public ArrayList<Produit> getProduitsEnPromo(){
        String url = Statics.BASE_URL+"/ProduitsMobPromo";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    produits = parseProduits(new String(req.getResponseData()));
                } catch (IOException ex) {
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
     
   
   
    
     public boolean addProduit(Produit p) {
       
       String url = Statics.BASE_URL + "/AddProductMob?nom="+p.getNom() + "&type="+p.getType()+"&prix="+p.getPrix()+"&quantite="+p.getQuantite();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
//     
//     public ArrayList<Produit> getAllProduitsParCategorie(){
//         Produit p = new Produit();
//         String url = Statics.BASE_URL + "/AfficherProduitFrontMobile?id_categorie="+p.getId_categorie();
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                try {
//                    produits = parseProduits(new String(req.getResponseData()));
//                } catch (IOException ex) {
//                    
//                }
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return produits;
//    }
     
      public ArrayList<Produit> rechercheProduit(){
         Produit p = new Produit();
         String url = Statics.BASE_URL + "/FindProduitMobile?id_produit="+p.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    produits = parseProduits(new String(req.getResponseData()));
                } catch (IOException ex) {
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
      public void affecterProduit(Produit p,Resources res) {
             ConnectionRequest con = new ConnectionRequest();
        String Url = Statics.BASE_URL + "/admin/dModifierStock/"+
 p.getId()+"?prix_Mg=" + p.getPrix_Mg()
                + "&nvquantite=" + p.getNvquantite();
              
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             Dialog.show("Succés", "Produit Affecté", "ok", null);

             ListeProduits a =new ListeProduits(res);
       a.show();
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }
     
      
}
