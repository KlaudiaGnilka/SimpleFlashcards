package exercise;

import db.Flashcard;
import db.SimpleDB;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleMakerTest {
    @Test
    public void createExerciseShouldCreateExerciseWithCorrectNumberOfFlashcards(){
        Set<Flashcard> flashcardSet = new HashSet<>();
        flashcardSet.add(new Flashcard("hello" , "ciao"));
        flashcardSet.add(new Flashcard("good morning", "buongiorno"));
        flashcardSet.add(new Flashcard("good night", "buonanotte"));
        flashcardSet.add(new Flashcard("mother", "madre"));
        flashcardSet.add(new Flashcard("father", "padre"));
        flashcardSet.add(new Flashcard("dog", "cane"));

        PuzzleMaker puzzleMaker = new PuzzleMaker();
        Exercise exercise = puzzleMaker.createExercise(flashcardSet);
        Assert.assertEquals(5, exercise.exerciseFlashcards.size());
    }
    
}
