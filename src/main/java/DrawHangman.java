import java.util.ArrayList;
import java.util.HashSet;

public class DrawHangman {
    String[] picture = new String[7];
    ArrayList<Character> curGuess = new ArrayList<>();

    public DrawHangman(String word) {
        for (int i = 0; i < word.length(); i++) {
            curGuess.add('_');
        }
        picture[0] = " +---+\n     |\n     |\n     |\n    ===\n";
        picture[1] = " +---+\n o   |\n     |\n     |\n    ===\n";
        picture[2] = " +---+\n o   |\n |   |\n     |\n    ===\n";
        picture[3] = " +---+\n o   |\n/|   |\n     |\n    ===\n";
        picture[4] = " +---+\n o   |\n/|\\  |\n     |\n    ===\n";
        picture[5] = " +---+\n o   |\n/|\\  |\n/    |\n    ===\n";
        picture[6] = " +---+\n o   |\n/|\\  |\n/ \\  |\n    ===\n";
    }

    public ArrayList<Character> getCurGuess() { return curGuess; }

    public void setCurGuess(ArrayList<Character> curGuess) { this.curGuess = curGuess; }

    public void drawHangman(int numMissed, HashSet<Character> allGuesses) {
        System.out.print(picture[numMissed]);
        for (Character ch : curGuess) {
            System.out.print(ch);
        }
        System.out.print("\nAlready guessed letters: ");
        for (Character ch : allGuesses) {
            System.out.print(ch + " ");
        }
        System.out.print("\n");
    }
}
