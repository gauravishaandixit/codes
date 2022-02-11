package codes.java.machinelevel.Wordle.models;

import java.util.Objects;

public class Word {
    String value;
    int level;

    public Word() {
    }

    public Word(String value, int level) {
        this.value = value;
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value) && Objects.equals(level, word.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, level);
    }
}
