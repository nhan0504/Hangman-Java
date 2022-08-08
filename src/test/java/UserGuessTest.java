import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class UserGuessTest {

    UserGuess guess = null;
    ArrayList<Character> curGuess = null;
    String word = "apple";

    @Before
    public void before() {
        guess = new UserGuess();
        curGuess = new ArrayList<>(Arrays.asList('_','_','_','_','_'));
    }

    @Test
    public void testIsRepeatFirstGuess() {
        assertFalse(guess.isRepeat());
    }

    @Test
    public void testIsRepeatForRepeatGuess() {
        guess.setUserGuess('a');
        guess.updateGuessHistory();
        guess.setUserGuess('a');
        guess.updateGuessHistory();
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
    public void testUpdateMissed() {
        guess.setUserGuess('s');
        assertEquals('s', guess.getGuess());
        guess.updateMissed();
        char actual = guess.getMissedGuesses().get(0);
        assertEquals('s', actual);
    }

    @Test
    public void testUpdateWord() {
        curGuess = new ArrayList<>(Arrays.asList('a','_','_','l','e'));
        guess.setUserGuess('p');
        guess.updateWord(word, curGuess);
        char actual1 = curGuess.get(1);
        assertEquals('p', actual1);
        char actual2 = curGuess.get(2);
        assertEquals('p', actual2);
    }

    @Test
    public void testUpdateWordFirstLetter() {
        curGuess = new ArrayList<>(Arrays.asList('_','_','_','l','e'));
        guess.setUserGuess('a');
        guess.updateWord(word, curGuess);
        char actual = curGuess.get(0);
        assertEquals('a', actual);
    }
    
}
