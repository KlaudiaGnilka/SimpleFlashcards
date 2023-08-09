package exercise;

import db.Flashcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PuzzleMaker implements ExerciseMaker {
    @Override
    public Exercise createExercise(Set<Flashcard> set) {
        List<Flashcard> testFlashcards = new ArrayList<>(set);
        if(set.size() > 5){
            Collections.shuffle(testFlashcards);
            return new Puzzle(testFlashcards.subList(0,5));
        }else{
            return new Puzzle(testFlashcards);
        }
    }
}
