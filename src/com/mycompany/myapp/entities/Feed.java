/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author LENOVO
 */
public class Feed {

    private int id;
    private int idUser;
    private int idEvent;
    private String date;
    private String description;
    private String username;

    public Feed() {
    }

    public Feed(String date, String description, String username) {
        this.date = date;
        this.description = description;
        this.username = username;
    }

    

    public Feed(int id, int idUser, int idEvent, String date, String description) {
        this.id = id;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.date = date;
        this.description = description;
    }

    public Feed(int id, int idUser, int idEvent, String date, String description, String username) {
        this.id = id;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.date = date;
        this.description = description;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

}
