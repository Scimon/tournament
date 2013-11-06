package com.photobox.resource;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 11:59
 * Data layer for saving and restoring stuff
 */
public class DataLayer {
    private static HttpClient client;
    private static CouchDbInstance instance;

    public static CouchDbConnector connect( String db ) {
        try {
            if ( client == null ) {
                client = new StdHttpClient.Builder().url("http://localhost:5984").build();
                instance = new StdCouchDbInstance(client);
            }
            return instance.createConnector( db , true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
