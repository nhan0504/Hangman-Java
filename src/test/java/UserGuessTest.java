import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserGuessTest {

    UserGuess guess = null;
    String word = "apple";

    @Before
    public void before() {
        guess = new UserGuess();
    }

    @Test
    public void testIsRepeatFirstGuess() {
        //guess.setUserGuess('a');
        assertFalse(guess.isRepeat());
    }
}
