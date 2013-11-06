package com.photobox.restapp;

import com.photobox.appclasses.Player;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Path("players")
public class Players {

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public List<Player> getPlayers() {
        return Player.getAll();
    }

    @GET @Path( "{playerid}")
    @Produces( MediaType.APPLICATION_JSON )
    public Player getPlayer(@PathParam("playerid") String id ) {
        return Player.load( id );
    }

    @DELETE @Path( "{playerid}")
    public void removePlayer(@PathParam("playerid") String id ) {
        Player.delete( Player.load( id ) );
    }

    @PUT @Path( "{playerid}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Player updatePlayer(@PathParam("playerid") String id, Player update ) {
        Player p = Player.load( id );
        p.update( update );
        return p;
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public Player addPlayer( Player p ) {
        p.save();
        return p;
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
