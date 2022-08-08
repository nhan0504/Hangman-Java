import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class UserGuess {
    char guess;
    HashSet<Character> allGuesses = new HashSet<>();
    ArrayList<Character> missedGuesses = new ArrayList<>();

    //Constructor
    public UserGuess() {
        guess = '_';
    }

    public char getGuess() {
        return guess;
    }

    public void setUserGuess(char guess) {
        this.guess = guess;
    }

    public HashSet<Character> getAllGuesses() {
        return allGuesses;
    }

    public ArrayList<Character> getMissedGuesses () { return missedGuesses; }

    public void resetMissedGuesses () { missedGuesses.clear(); }

    public void resetAllGuesses () { allGuesses.clear(); }

    public void getUserGuess() {
        do {
            System.out.print("Enter a letter: ");
            Scanner scr = new Scanner(System.in);
            guess = scr.next().charAt(0);
        }
        while (!Character.isAlphabetic(guess) || isRepeat());
    }

    public void updateGuessHistory() {
        allGuesses.add(guess);
    }

    public boolean isRepeat() {
        if (allGuesses.contains(guess)) {
            System.out.print("This letter has already been guessed.\n");
            return true;
        }
        return false;
    }

    public boolean checkGuess(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    public void updateMissed() {
        missedGuesses.add(guess);
    }

    public ArrayList<Character> updateWord(String word, ArrayList<Character> curGuess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                curGuess.set(i,guess);
            }
        }
        return curGuess;
    }
}
