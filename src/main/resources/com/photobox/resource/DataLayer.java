package com.photobox.resource;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 11:59
 * Data layer for saving and restoring stuff
 */
public class DataLayer {
    static private MongoClient client;
    static private DB db;

    public DataLayer() {
        try {
            client = client == null ? new MongoClient( "localhost" ) : client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        db = db == null ? client.getDB( "tournaments" ) : db;
    }
}
