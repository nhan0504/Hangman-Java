import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class RandomWordTest {

    RandomWord word = null;
    UserGuess guess = null;

    @Before
    public void before() {
        word = new RandomWord("words.txt");
        guess = new UserGuess();
    }

    @Test
    public void testSetWord() {
        word.setWord("apple");
        assertEquals("apple",word.getWord());
    }

    @Test
    public void testIsDone() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','p','p','l','e'));
        assertTrue(word.isDone(0, curGuess));
    }

    @Test
    public void testIsDoneWhenMissedMoreThanSix() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','p','p','l','e'));
        assertTrue(word.isDone(7, curGuess));
    }

    @Test
    public void testIsDoneWhenNotFinish() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','_','_','l','e'));
        assertFalse(word.isDone(0, curGuess));
    }

    @Test
    public void testUpdateWordAndIsDone() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','_','_','l','e'));
        guess.setUserGuess('p');
        guess.updateWord(word.getWord(), curGuess);
        assertTrue(word.isDone(0, curGuess));
    }

    @Test
    public void testUpdateWordAndIsDoneReturnFalse() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','_','_','l','_'));
        guess.setUserGuess('p');
        guess.updateWord(word.getWord(), curGuess);
        assertFalse(word.isDone(0, curGuess));
    }

    @Test
    public void testUpdateWordAndIsDoneFirstGuess() {
        word.setWord("apple");
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('_','_','_','_','_'));
        guess.setUserGuess('e');
        guess.updateWord(word.getWord(), curGuess);
        assertFalse(word.isDone(0, curGuess));
    }

}
