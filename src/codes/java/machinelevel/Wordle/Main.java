package codes.java.machinelevel.Wordle;

import codes.java.machinelevel.Wordle.modes.HardCodedMode;
import codes.java.machinelevel.Wordle.services.WordleService;

public class Main {
    public static void main(String[] args) {
        WordleService wordleService = new WordleService();
        new HardCodedMode(wordleService).process();

//        wordleService.addNewWord("APPLE", 5);
//        wordleService.addNewWord("FLOOD", 5);
//        wordleService.addNewWord("FLIPKART", 8);
//        wordleService.addNewWord("ROGUE", 5);
//        wordleService.addNewWord("Apple", 5);
//        wordleService.addNewWord("MAPLE", 5);
//
//        wordleService.registerNewUser("Gaurav");
//        wordleService.registerNewUser("Dixit");
//
//        wordleService.startNewRound();
//        wordleService.guessWord("Gaurav", "MAPLE");
//        wordleService.guessWord("Gaurav", "FLOOD");
//
//        wordleService.addNewWord("GAURAV", 5);
//        wordleService.addNewWord("MAPLE", 5);
//
//        wordleService.guessWord("Gaurav", "APPLE");
//        wordleService.guessWord("Dixit", "APPLE");
//        wordleService.getCurrentRoundScores();
//
//        wordleService.registerNewUser("Abhishek");
//        wordleService.guessWord("Abhishek", "MAPLE");
//        wordleService.getCurrentRoundScores();
//        wordleService.getAllRoundScores();
//
//        wordleService.resetGame();
//
//        wordleService.startNewRound();
//        wordleService.guessWord("Gaurav", "APPLE");
//        wordleService.guessWord("DIXIT", "APPLE");
//        wordleService.getCurrentRoundScores();
//
//        wordleService.startNewRound();
//        wordleService.getCurrentRoundScores();
//
//        wordleService.getAllRoundScores();
    }
}
