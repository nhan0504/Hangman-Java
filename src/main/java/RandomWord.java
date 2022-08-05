import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
    String word = null;
    static ArrayList<String> wordList = new ArrayList<>();

    public RandomWord (String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    this.getClass().getClassLoader().getResourceAsStream(fileName)));
            while (reader.readLine() != null) {
                wordList.add(reader.readLine());
            }
        } catch(Exception e) {
            System.out.print("Can't open file");
        }
        generateWord();
    }

    public String getWord() {
        return word;
    }

    //method to set word for testing
    public void setWord(String word) {
        this.word = word;
    }

    public void generateWord() {
        Random random = new Random();
        int randomNum = random.nextInt(wordList.size());
        word = wordList.get(randomNum);
    }

    public boolean isDone(int missed, ArrayList<Character> curGuess) {
        if (missed != 6) {
            for (int i = 0; i < word.length(); i++) {
                if (curGuess.get(i) != word.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
