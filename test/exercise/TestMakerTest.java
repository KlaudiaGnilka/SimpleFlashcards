package exercise;

import db.Flashcard;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestMakerTest {
    @Test
    public void createExerciseShouldCreateExerciseWithCorrectNumberOfFlashcards() {
        Set<Flashcard> flashcardSet = new HashSet<>();
        flashcardSet.add(new Flashcard("hello", "ciao"));
        flashcardSet.add(new Flashcard("good morning", "buongiorno"));
        flashcardSet.add(new Flashcard("good night", "buonanotte"));
        flashcardSet.add(new Flashcard("dog", "cane"));
        flashcardSet.add(new Flashcard("ice cream", "gelato"));
        flashcardSet.add(new Flashcard("spring", "la primavera"));
        flashcardSet.add(new Flashcard("yes", "si"));
        flashcardSet.add(new Flashcard("thank you", "grazie"));
        flashcardSet.add(new Flashcard("sorry", "scusa"));
        flashcardSet.add(new Flashcard("I", "Io"));
        flashcardSet.add(new Flashcard("right", "vero"));

        TestMaker testMaker = new TestMaker();
        Exercise exercise = testMaker.createExercise(flashcardSet);

        Assert.assertEquals(10, exercise.exerciseFlashcards.size());
    }
}
