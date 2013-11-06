package com.photobox.appclasses;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

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
    public Date dateOfBirth;

    public Player() {
    }

    public Player(String name) {
        this.firstName = name;
    }

    public Player(String name, Date date) {
        this.firstName = name;
        this.dateOfBirth = date;
    }

    public Player(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public Player(String first, String last, Date date) {
        this.firstName = first;
        this.lastName = last;
        this.dateOfBirth = date;
    }
}
