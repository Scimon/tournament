import com.photobox.appclasses.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 11:08
 * Test the Player Class
 */
public class testPlayer {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;

    @org.junit.Before
    public void setUp() throws Exception {
        player1 = new Player();
        player2 = new Player( "Simon" );
        player3 = new Player( "Simon", "Proctor" );
        player4 = new Player( "Simon", "Proctor", new GregorianCalendar( 1973, 10, 9 ) );
        player5 = new Player( "Simon", new GregorianCalendar( 1973, 10, 9 ) );
    }

    @Test
    public void testCreationNoArgs() throws Exception {
        Assert.assertEquals("Player is a player", "class com.photobox.appclasses.Player", player1.getClass().toString());
        Assert.assertEquals("Player first name is empty", "", player1.firstName );
        Assert.assertEquals("Player last name is empty", "", player1.lastName );
        Assert.assertNull("Player DOB is null", player1.dateOfBirth );
    }

    @Test
    public void testCreationOneName() throws Exception {
        Assert.assertEquals("Player is a player", "class com.photobox.appclasses.Player", player2.getClass().toString());
        Assert.assertEquals("Player first name is Simon", "Simon", player2.firstName );
        Assert.assertEquals("Player last name is empty", "", player2.lastName );
        Assert.assertNull("Player DOB is null", player2.dateOfBirth );
    }

    @Test
    public void testCreationTwoNames() throws Exception {
        Assert.assertEquals("Player is a player", "class com.photobox.appclasses.Player", player3.getClass().toString());
        Assert.assertEquals("Player first name is Simon", "Simon", player3.firstName );
        Assert.assertEquals("Player last name is Proctor", "Proctor", player3.lastName );
        Assert.assertNull("Player DOB is null", player3.dateOfBirth );
    }
}
