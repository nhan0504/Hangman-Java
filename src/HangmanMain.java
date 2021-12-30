public class HangmanMain {
    public static void main(String[] args) {
        RandomWord randomWord = new RandomWord("words_list.txt");
        UserGuess userGuess = new UserGuess();
        DrawHangman draw = new DrawHangman(randomWord.getWord());

        StartGame.startGame(userGuess, randomWord, draw);
    }
}
