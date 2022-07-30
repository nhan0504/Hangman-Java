package app;

import java.util.*;

public class StartGame {
    public static void newGame(UserGuess userGuess, RandomWord randomWord) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Play again? Type yes or no: ");
        String answer = scr.next();
        String[] yes = {"Yes", "yes", "YES"};
        HashSet<String> yesOption = new HashSet<>(Arrays.asList(yes));
        if (yesOption.contains(answer)) {
            randomWord.generateWord();
            userGuess.resetMissedGuesses();
            userGuess.resetAllGuesses();
        }
    }

    public static void startGame(UserGuess userGuess, RandomWord randomWord, DrawHangman draw) {
        while (!randomWord.isDone(userGuess.getMissedGuesses().size(), draw.getCurGuess())) {
            draw.drawHangman(userGuess.getMissedGuesses().size(), userGuess.getAllGuesses());

            //Get user guess
            do {
                System.out.print("Enter a letter: ");
                Scanner scr = new Scanner(System.in);
                char guessLetter = scr.next().charAt(0);
                userGuess.setUserGuess(guessLetter);
            }
            while (!Character.isAlphabetic(userGuess.getGuess()) || userGuess.isRepeat());

            // Check if guess is correct
            if (userGuess.checkGuess(randomWord.getWord())) {
                draw.setCurGuess(userGuess.updateWord(randomWord.getWord(), draw.getCurGuess()));
            } else {
                userGuess.updateMissed();
            }

            // Check if game is finished
            if (randomWord.isDone(userGuess.getMissedGuesses().size(),draw.getCurGuess())) {
                if (userGuess.getMissedGuesses().size() == 6) {
                    System.out.print("You lose.");
                } else {
                    System.out.println("You win.");
                }
                System.out.print("The correct word is: " + randomWord.getWord() + "\n");
                StartGame.newGame(userGuess, randomWord);
                draw = new DrawHangman(randomWord.getWord());
            }
        }
    }
}
