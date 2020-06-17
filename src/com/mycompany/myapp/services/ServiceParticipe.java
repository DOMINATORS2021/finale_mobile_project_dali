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
import com.codename1.ui.events.ActionListener;
import com.mycomapny.myapp.utils.Statics;
import com.mycompany.myapp.entities.Participe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceParticipe {

    public ArrayList<Participe> events;
    private ConnectionRequest req;
    public static ServiceParticipe instance = null;

    public ServiceParticipe() {
        req = new ConnectionRequest();

    }

    public static ServiceParticipe getInstance() {
        if (instance == null) {
            instance = new ServiceParticipe();
        }
        return instance;
    }

    public ArrayList<Participe> parseEvents(String jsonText) throws IOException {
        events = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> produitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String, Object>> list = (List<Map<String, Object>>) produitsListJson.get("root");
        for (Map<String, Object> obj : list) {
            Participe p = new Participe();
            float idEvent = Float.parseFloat(obj.get("idEvent").toString());
            p.setIdEvent((int) idEvent);
            float idUser = Float.parseFloat(obj.get("idUser").toString());
            p.setIdUser((int) idUser);
            events.add(p);
        }
        return events;

    }

    public ArrayList<Participe> getAll() {
        String url = Statics.BASE_URL + "/api/participe";
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

    public ArrayList<Participe> participer(int a, int b) {
        String url = Statics.BASE_URL + "/api/participe/"+a + "/"+ b;
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

    public ArrayList<Participe> iparticiper(int a, int b) {
        String url = Statics.BASE_URL + "/api/iparticipe/"+a + "/"+ b;
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
