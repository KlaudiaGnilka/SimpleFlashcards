package db;

import java.util.Objects;

public class Flashcard {
    private String wordIT;
    private String wordEN;

    public Flashcard(String wordEN, String wordIT) {
        this.wordIT = wordIT;
        this.wordEN = wordEN;
    }

    public String getWordIT() {
        return wordIT;
    }

    public void setWordIT(String wordIT) {
        this.wordIT = wordIT;
    }

    public String getWordEN() {
        return wordEN;
    }

    public void setWordEN(String wordEN) {
        this.wordEN = wordEN;
    }



    @Override
    public String toString() {
        return wordEN + " ---------- " + wordIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return Objects.equals(wordIT, flashcard.wordIT) && Objects.equals(wordEN, flashcard.wordEN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordIT, wordEN);
    }
}
