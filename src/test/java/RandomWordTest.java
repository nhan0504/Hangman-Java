import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
