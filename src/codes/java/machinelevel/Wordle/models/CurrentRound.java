package codes.java.machinelevel.Wordle.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentRound {
    String word;
    int noOfGuesses;

    Map<String, List<String>> guesses;
    Map<String, Double> currentRoundScores;

    public CurrentRound(String word, int noOfGuesses) {
        this.word = word;
        this.noOfGuesses = noOfGuesses;
        guesses = new HashMap<>();
        currentRoundScores = new HashMap<>();
    }

    public void guessWord(String user, String guess) {
        guesses.putIfAbsent(user, new ArrayList<>());
        currentRoundScores.putIfAbsent(user, 0.0);

        if (currentRoundScores.get(user) > 0.0) {
            System.out.println("[" + user + "] Already Played This Round");
            return;
        }

        if (guess.length() != word.length()) {
            System.out.println("Invalid Guess. Unequal Length");
        } else {
            if (guesses.get(user).size() >= noOfGuesses) {
                System.out.println("Err!!!, [" + user + "] Out Of Guesses");
                return;
            }

            String code = getCode(guess);
            guesses.computeIfAbsent(user, k -> new ArrayList<>()).add(code);
            if (word.equals(guess)) {
                currentRoundScores.put(user, (noOfGuesses * 1.0) / guesses.get(user).size());
            }

            print(guesses.get(user));
        }
    }

    String getCode(String guess) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) { //MAPLE, //APPLE
            char chGuess = guess.charAt(i);
            char chWord = word.charAt(i);

            if (chWord == chGuess) {
                sb.append("C");
            } else {
                if (word.lastIndexOf(chGuess) != -1) {
                    sb.append("P");
                } else {
                    sb.append("I");
                }
            }
        }
        return sb.toString();
    }

    public Map<String, Double> getScores() {
        return currentRoundScores;
    }

    void print(List<String> guesses) {
        for (String guess : guesses) {
            System.out.println(guess);
        }
        System.out.println();
    }

}
