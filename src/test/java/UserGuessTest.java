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

    @Test
    public void testIsRepeatForRepeatGuess() {
        guess.setUserGuess('a');
        guess.isRepeat();
        guess.setUserGuess('a');
        assertTrue(guess.isRepeat());
    }

    @Test
    public void testIsRepeatForNonRepeatedGuess() {
        guess.setUserGuess('a');
        guess.isRepeat();
        guess.setUserGuess('b');
        assertFalse(guess.isRepeat());
    }

    @Test
    public void testCheckGuessForCorrectGuess() {
        guess.setUserGuess('a');
        assertTrue(guess.checkGuess(word));
    }

    @Test
    public void testCheckGuessForWrongGuess() {
        guess.setUserGuess('s');
        assertFalse(guess.checkGuess(word));
    }

    @Test
    public void updateMissed() {
        guess.setUserGuess('s');
        assertEquals('s', guess.getGuess());
        guess.updateMissed();
        char actual = guess.getMissedGuesses().get(0);
        assertEquals('s', actual);
    }


}
