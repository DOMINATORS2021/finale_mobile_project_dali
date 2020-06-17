/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Event {

    private int id;
    private String nomFile;
    private String nom;
    private String type;
    private String adresse;
    private String organisateur;
    private String dateDebut;
    private String dateFin;
    private String num;
    private String description;
    private int nbrParticipant;
    private int nbrParticipantMax;

    public Event() {
    }

    public Event(int id, String nomFile, String nom, String type, String adresse, String organisateur, String dateDebut, String dateFin, String num, String description, int nbrParticipant, int nbrParticipantMax) {
        this.id = id;
        this.nomFile = nomFile;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.organisateur = organisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.num = num;
        this.description = description;
        this.nbrParticipant = nbrParticipant;
        this.nbrParticipantMax = nbrParticipantMax;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nomFile=" + nomFile + ", nom=" + nom + ", type=" + type + ", adresse=" + adresse + ", organisateur=" + organisateur + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", num=" + num + ", description=" + description + ", nbrParticipant=" + nbrParticipant + ", nbrParticipantMax=" + nbrParticipantMax + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFile() {
        return nomFile;
    }

    public void setNomFile(String nomFile) {
        this.nomFile = nomFile;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrParticipant() {
        return nbrParticipant;
    }

    public void setNbrParticipant(int nbrParticipant) {
        this.nbrParticipant = nbrParticipant;
    }

    public int getNbrParticipantMax() {
        return nbrParticipantMax;
    }

    public void setNbrParticipantMax(int nbrParticipantMax) {
        this.nbrParticipantMax = nbrParticipantMax;
    }

}
