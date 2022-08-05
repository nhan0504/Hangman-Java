import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class RandomWordTest {

    RandomWord word = null;

    @Before
    public void before() {
        word = new RandomWord("words.txt");
        word.setWord("apple");
    }

    @Test
    public void testIsDone() {
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','p','p','l','e'));
        assertTrue(word.isDone(0, curGuess));
    }

    @Test
    public void testIsDoneWhenMissedMoreThanSix() {
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','p','p','l','e'));
        assertTrue(word.isDone(7, curGuess));
    }

    @Test
    public void testIsDoneWhenNotFinish() {
        ArrayList<Character> curGuess = new ArrayList<>(Arrays.asList('a','_','_','l','e'));
        assertFalse(word.isDone(0, curGuess));
    }
}
