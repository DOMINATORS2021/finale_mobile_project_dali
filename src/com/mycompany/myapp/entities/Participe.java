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
public class Participe {

    private int idEvent;
    private int idUser;

    public Participe() {
    }

    public Participe( int idEvent, int idUser) {
        this.idEvent = idEvent;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Participe{" + "idEvent=" + idEvent + ", idUser=" + idUser + '}';
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
