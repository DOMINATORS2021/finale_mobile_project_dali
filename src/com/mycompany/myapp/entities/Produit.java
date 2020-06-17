/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;



/**
 *
 * @author PCS
 */
public class Produit {
  private int id ;
    private String nom;
     private int quantite;
    private double prix;
     private String type ;
    private Date dates;
    private Date datee;
    private double nvprix;
    private String nomfile;  
    private int nvquantite;
    private double prix_Mg;
    private int id_categorie;
    private String nom_marque;
    public Produit(){};
   


   
   
      public Produit(String nom, int quantite,double prix, String marque,int id_categorie) {
        
        this.nom = nom;
        this.quantite = quantite;
        this.prix=prix;
        this.type = type;
        this.id_categorie=id_categorie;
       
                
     }
       public Produit(String nom, int quantite,double prix, String marque,int nvquantite,double prix_Mg) {
        
        this.nom = nom;
        this.quantite = quantite;
        this.prix=prix;
        this.type = type;
        this.nvquantite=nvquantite;
        this.prix_Mg=prix_Mg;
       
                
     }

    public Produit(int id, String nom, int quantite, double prix, String type) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.type = type;
    }

    public Produit(String nom, int quantite, double prix, String type) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.type = type;
    }
   
    
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    public String getNomfile() {
        return nomfile;
    }

    public void setNomfile(String nomfile) {
        this.nomfile = nomfile;
    }


  
    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getNvprix() {
        return nvprix;
    }

    public void setNvprix(double nvprix) {
        this.nvprix = nvprix;
    }

    public int getNvquantite() {
        return nvquantite;
    }

    public void setNvquantite(int nvquantite) {
        this.nvquantite = nvquantite;
    }
     public double getPrix_Mg() {
        return prix_Mg;
    }

    public void setPrix_Mg(double prix_Mg) {
        this.prix_Mg = prix_Mg;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }
    

   


   
}
