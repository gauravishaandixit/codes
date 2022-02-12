package codes.java.machinelevel.Wordle.services;

import codes.java.machinelevel.Wordle.models.CurrentRound;
import codes.java.machinelevel.Wordle.models.Users;
import codes.java.machinelevel.Wordle.models.Word;
import codes.java.machinelevel.Wordle.models.Words;

import java.util.*;

public class WordleService {

    Words words;
    Users users;
    CurrentRound currentRound;
    List<Word> waitListedWords;

    public WordleService() {
        words = new Words();
        users = new Users();
        waitListedWords = new ArrayList<>();
    }

    public void registerNewUser(String name) {
        name = name.toUpperCase();
        boolean result = users.addNewUser(name);
        if(result) {
            System.out.println("\nUser [" + name + "] has registered.");
        } else {
            System.out.println("\nUser [" + name + "] was not registered.");
        }
    }

    public void addNewWord(String word, int difficultyLevel) {
        word = word.toUpperCase();
        if (!checkValidRound()) {
            addWord(word, difficultyLevel);
        } else {
            waitListedWords.add(new Word(word, difficultyLevel));
            System.out.println("[" + word + "] word is waitListed.");
        }
    }

    public void startNewRound() {
        System.out.println("==========================================");
        System.out.println("New Round");
        if(checkValidRound()) {
            updateScoreCard();
        }

        addWaitListedWords();

        Word word = words.selectRandomWord();
        word = new Word("MAPLE", 5);
        currentRound = new CurrentRound(word.getValue(), word.getLevel());

        System.out.println("Today's Word :" + word.getValue());
        System.out.println("No of Guesses: " + word.getLevel());
        System.out.println("==========================================");
    }

    void updateScoreCard() {
        Map<String, Double> currentRoundScores = currentRound.getScores();
        for(Map.Entry<String, Double> entry: currentRoundScores.entrySet()) {
            if(entry.getValue() > 0.0) {
                users.updateScoreCard(entry.getKey(), entry.getValue());
            }
        }
    }

    void addWord(String word, int difficultyLevel) {
        boolean result = words.addWord(word, difficultyLevel);
        if(result) {
            System.out.println("Word [" + word + "] is added.");
        } else {
            System.out.println("Word [" + word + "] was not added");
        }
    }

    boolean checkValidRound() {
        return currentRound != null;
    }

    public void guessWord(String userName, String guess) {
        userName = userName.toUpperCase();
        guess = guess.toUpperCase();

        if(!users.validUser(userName)) {
            System.out.println("User [" + userName + "] has not registered.");
            return;
        }

        if (!checkValidRound()) {
            System.out.println("Game Has Not Started Yet");
            return;
        }

        if (!words.checkIfWordIsPresent(guess)) {
            System.out.println("Invalid guess. [" + guess + "] is not present in dictionary");
            return;
        }

        currentRound.guessWord(userName, guess);
    }

    public void getCurrentRoundScores() {
        if(checkValidRound()) {
            Map<String, Double> currentRoundScores = currentRound.getScores();

            System.out.println("\n\nCurrent Round Scores");
            printScores(currentRoundScores);
        } else {
            System.out.println("No Game Has Started Yet");
        }
    }

    public void getAllRoundScores() {
        Map<String, Double> totalScores = users.getScores();
        Map<String, Double> currentScores = currentRound.getScores();

        Map<String, Double> scores = new HashMap<>(totalScores);

        for (Map.Entry<String, Double> entry: currentScores.entrySet()) {
            String name = entry.getKey();
            double totalScore = entry.getValue() + totalScores.getOrDefault(name, 0.0);

            scores.put(name, totalScore);
        }


        System.out.println("\n\nAll Round Scores");
        printScores(scores);
    }

    void printScores(Map<String, Double> scores) {
        boolean foundOneUserWithScore = false;
        List<Map.Entry<String, Double>> list = new ArrayList<>(scores.entrySet());
        Collections.sort(list, (a, b) -> (int) (b.getValue() - a.getValue()));

        for(Map.Entry<String, Double> entry: list) {
            if (entry.getValue() > 0.0) {
                foundOneUserWithScore = true;
                System.out.println("User: " + entry.getKey() + ", Score: " + entry.getValue());
            }
        }

        if (!foundOneUserWithScore) {
            System.out.println("No User Has Successfully Guessed Any Word");
        }
        System.out.println("=============================================================\n");
    }

    public void resetGame() {
        updateScoreCard();
        currentRound = null;
        System.out.println("Current Round Was Reset");
        addWaitListedWords();
    }

    void addWaitListedWords() {
        for(Word w: waitListedWords) {
            addWord(w.getValue(), w.getLevel());
        }
        waitListedWords.clear();
    }
}
