package codes.java.machinelevel.Wordle.models;

import java.util.*;

public class Words {
    Set<String> wordsSet;
    List<Word> wordList;

    public Words() {
        wordsSet = new HashSet<>();
        wordList = new ArrayList<>();
    }

    public boolean addWord(String word, int difficultyLevel) {
        if(checkWhetherWordIsPresent(word)) {
            return false;
        }
        wordList.add(new Word(word, difficultyLevel));
        return true;
    }

    public Word selectRandomWord() {
        int size = wordList.size();
        return wordList.get((new Random()).nextInt(size));
    }

    boolean checkWhetherWordIsPresent(String word) {
        return !wordsSet.add(word);
    }

    public boolean checkIfWordIsPresent(String word) {
        return wordsSet.contains(word);
    }

}
