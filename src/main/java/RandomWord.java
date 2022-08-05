import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
    String word = null;
    static ArrayList<String> wordList = new ArrayList<>();

    public RandomWord (String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
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
