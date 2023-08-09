package exercise;

import db.Flashcard;

import java.util.*;

public abstract class Exercise {
    protected List<Flashcard> exerciseFlashcards;

    public Exercise(Collection<Flashcard> flashcards){
        this.exerciseFlashcards = new ArrayList<>(flashcards);
    }

    public abstract String showExercise();

    public abstract List<Boolean> solveExercise(String answer);
}
