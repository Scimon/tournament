package com.photobox.appclasses;

import com.photobox.resource.DataLayer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 10:01
 * A Player in a tournament
 */
@XmlRootElement
public class Player {
	public String firstName;
	public String lastName;
	public Calendar dateOfBirth;
    private DataLayer dbLayer;

	public Player() {
        dbLayer = new DataLayer();
        firstName = "";
        lastName = "";
        dateOfBirth = null;
	}

	public Player(String name) {
        dbLayer = new DataLayer();
		firstName = name;
        lastName = "";
        dateOfBirth = null;

	}

	public Player(String name, Calendar date) {
        dbLayer = new DataLayer();
		firstName = name;
        lastName = "";
		dateOfBirth = date;
	}

	public Player(String first, String last) {
        dbLayer = new DataLayer();
		firstName = first;
		lastName = last;
        dateOfBirth = null;
	}

	public Player(String first, String last, Calendar date) {
        dbLayer = new DataLayer();
        firstName = first;
		lastName = last;
		dateOfBirth = date;
	}
}
