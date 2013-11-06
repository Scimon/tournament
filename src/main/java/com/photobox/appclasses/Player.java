package com.photobox.appclasses;

import com.photobox.resource.DataLayer;

import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.*;
import org.ektorp.CouchDbConnector;
import org.ektorp.DocumentNotFoundException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 10:01
 * A Player in a tournament
 */

@XmlRootElement(name = "player")
@JsonIgnoreProperties({"id", "revision"})
public class Player {

    @JsonProperty("_id")
    public String id;
    @JsonProperty("_rev")
    public String rev;

	public String firstName;
	public String lastName;
	public Calendar dateOfBirth;

	public Player() {
        firstName = "";
        lastName = "";
        dateOfBirth = null;
	}

	public Player(String name) {
        firstName = name;
        lastName = "";
        dateOfBirth = null;

	}

	public Player(String name, Calendar date) {
		firstName = name;
        lastName = "";
		dateOfBirth = date;
	}

	public Player(String first, String last) {
		firstName = first;
		lastName = last;
        dateOfBirth = null;
	}

	public Player(String first, String last, Calendar date) {
        firstName = first;
		lastName = last;
		dateOfBirth = date;
	}

    public Boolean equals( Player p ) {
        if ( ! firstName.equals( p.firstName ) ) return false;
        if ( ! lastName.equals( p.lastName ) ) return false;
        if ( ! dateOfBirth.equals( p.dateOfBirth ) ) return false;
        return true;
    }

    public String save() {
        CouchDbConnector conn = DataLayer.connect("players");
        conn.create(this);

        return this.id;
    }

     public Player update( Player update ) {
        CouchDbConnector conn = DataLayer.connect( "players" );
        if ( update.firstName != null ) firstName = update.firstName;
        if ( update.lastName != null ) lastName = update.lastName;

        conn.update(this);

        return this;
    }

    public static void delete( Player p ) {
        CouchDbConnector conn = DataLayer.connect( "players" );
        conn.delete( p );
        try {
            p.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    public static Player load( String id ) {
        CouchDbConnector conn = DataLayer.connect( "players" );
        try {
            return conn.get( Player.class, id );
        } catch ( DocumentNotFoundException e ) {
            return null;
        }
    }

    public static List<Player> getAll() {
        List<Player> players = new ArrayList<Player>();
        CouchDbConnector conn = DataLayer.connect( "players" );
        for( String id : conn.getAllDocIds() ) {
            players.add( Player.load( id ) );
        }
        return players;
    }
}
