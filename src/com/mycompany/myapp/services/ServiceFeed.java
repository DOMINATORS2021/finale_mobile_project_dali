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
import com.mycompany.myapp.entities.Feed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceFeed {
    public ArrayList<Feed> events;
    public static ServiceFeed instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceFeed() {
        req = new ConnectionRequest();

    }

    public static ServiceFeed getInstance() {
        if (instance == null) {
            instance = new ServiceFeed();
        }
        return instance;
    }

    public ArrayList<Feed> parseEvents(String jsonText) throws IOException {

        events = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> produitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String, Object>> list = (List<Map<String, Object>>) produitsListJson.get("root");
        for (Map<String, Object> obj : list) {
            Feed p = new Feed();
            float idUser = Float.parseFloat(obj.get("id_user").toString());
            p.setIdUser((int) idUser);
            p.setDate(obj.get("date_feed").toString());
            p.setDescription(obj.get("description").toString());
            p.setUsername(obj.get("username").toString());
            events.add(p);
        }
        return events;
    }

    public ArrayList<Feed> getFeed(int idEvent) {
        String url = Statics.BASE_URL + "/api/feed/"+idEvent;
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
    
    public boolean ajouter(int idUser,int idEvent,String desc) {
        String url = Statics.BASE_URL + "/api/addFeed/"+idUser+"/"+idEvent+"/"+desc;
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

}
