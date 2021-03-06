import com.photobox.appclasses.Player;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: simon
 * Date: 06/11/13
 * Time: 11:08
 * Test the Player Class
 */
public class TestPlayer {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private DateFormat simpleFormat;

    @org.junit.Before
    public void setUp() throws Exception {
        player1 = new Player();
        player2 = new Player( "Simon" );
        player3 = new Player( "Simon", new GregorianCalendar( 1973, 10 - 1, 9 ) );
        player4 = new Player( "Simon", "Proctor" );
        player5 = new Player( "Simon", "Proctor", new GregorianCalendar( 1973, 10 - 1, 9 ) );
        simpleFormat = new SimpleDateFormat( "yyyy-MM-dd");
    }

    @Test
    public void testCreationNoArgs() throws Exception {
        Assert.assertThat("Player is a player", player1, instanceOf( Player.class ) );
        Assert.assertEquals("Player is a player", "class com.photobox.appclasses.Player", player1.getClass().toString());
        Assert.assertEquals("Player first name is empty", "", player1.firstName );
        Assert.assertEquals("Player last name is empty", "", player1.lastName );
        Assert.assertNull("Player DOB is null", player1.dateOfBirth);
    }

    @Test
    public void testCreationOneName() throws Exception {
        Assert.assertThat("Player is a player", player2, instanceOf( Player.class ) );
        Assert.assertEquals("Player first name is Simon", "Simon", player2.firstName );
        Assert.assertEquals("Player last name is empty", "", player2.lastName );
        Assert.assertNull("Player DOB is null", player2.dateOfBirth );
    }

    @Test
    public void testCreationOneNameAndDate() throws Exception {
        Assert.assertThat("Player is a player", player3, instanceOf( Player.class ) );
        Assert.assertEquals("Player first name is Simon", "Simon", player3.firstName );
        Assert.assertEquals("Player last name is empty", "", player3.lastName );
        Assert.assertEquals("Player DOB is my birthday", "1973-10-09", simpleFormat.format(player3.dateOfBirth.getTime()) );
    }

    @Test
    public void testCreationTwoNames() throws Exception {
        Assert.assertThat("Player is a player", player4, instanceOf( Player.class ) );
        Assert.assertEquals("Player first name is Simon", "Simon", player4.firstName );
        Assert.assertEquals("Player last name is Proctor", "Proctor", player4.lastName );
        Assert.assertNull("Player DOB is null", player4.dateOfBirth );
    }

    @Test
    public void testCreationTwoNamesAndDate() throws Exception {
        Assert.assertThat("Player is a player", player5, instanceOf( Player.class ) );
        Assert.assertEquals("Player first name is Simon", "Simon", player5.firstName );
        Assert.assertEquals("Player last name is Proctor", "Proctor", player5.lastName );
        Assert.assertEquals("Player DOB is my birthday", "1973-10-09", simpleFormat.format(player3.dateOfBirth.getTime()));
    }

    @Test
    public void testUserSaveLoadAndDelete() throws Exception {
        Assert.assertNull( "Unsaved player has no ID", player5.id );
        player5.save();
        Assert.assertNotNull( "Saved player has an ID", player5.id );
        Assert.assertThat( "Id is a string", player5.id, instanceOf( String.class ) );
        Player newPlayer = Player.load( player5.id );
        Assert.assertTrue( "Loaded player is saved player", player5.equals( newPlayer ) );
        Player.delete( player5 );
        Assert.assertNull( "Deleted player can't be loaded", Player.load( newPlayer.id ) );
    }
}
