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
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.gui.ListeProduits;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceEvenement {

    public ArrayList<Event> events;
    public static ServiceEvenement instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEvenement() {
        req = new ConnectionRequest();

    }

    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    }

    public ArrayList<Event> parseEvents(String jsonText) throws IOException {

        events = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> produitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String, Object>> list = (List<Map<String, Object>>) produitsListJson.get("root");
        for (Map<String, Object> obj : list) {
            Event p = new Event();
            float id = Float.parseFloat(obj.get("id").toString());
            p.setId((int) id);
            p.setNom(obj.get("nom").toString());
            p.setAdresse(obj.get("adresse").toString());
            p.setDescription(obj.get("description").toString());
            p.setOrganisateur(obj.get("organisateur").toString());
            p.setType(obj.get("type").toString());
            p.setNum(obj.get("num").toString());
            if (obj.get("nbr_participant") == null) {
                p.setNbrParticipant(0);
            } else {
                p.setNbrParticipant((int) Float.parseFloat(obj.get("nbr_participant").toString()));
            }
            p.setNbrParticipantMax((int) Float.parseFloat(obj.get("nbr_participant_max").toString()));
            p.setDateDebut(obj.get("date_debut").toString());
            p.setDateFin(obj.get("date_fin").toString());
            p.setNomFile(obj.get("nomfile").toString());
            events.add(p);
        }
        return events;
    }

    public ArrayList<Event> getAllEvents() {
        String url = Statics.BASE_URL + "/api/event";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    events = parseEvents(new String(req.getResponseData()));
                } catch (IOException ex) {

                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }
    
   
}
