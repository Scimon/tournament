package com.photobox.restapp;

import com.photobox.appclasses.Player;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("players")
class Players {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayers() {
        List<Player> PlayerList = new ArrayList<Player>();
        PlayerList.add( new Player( "Simon", "Proctor") );
        PlayerList.add( new Player( "Claudio", "Ferrete") );
        return PlayerList;
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    /*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    */
}
