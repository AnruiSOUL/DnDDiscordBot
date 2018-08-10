import bot.discord.DnDCharacterRandomizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DnDCharacterRandomizeTest {
    DnDCharacterRandomizer dnd;
    @Before
    public void setup() {
        dnd = new DnDCharacterRandomizer();
    }
    @Test
    public void characterRandomizedTest(){
        String actual = dnd.characterRandomized();
        Assert.assertNotNull("Calling characterRandomized() is null", actual);
    }

}
