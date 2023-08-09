package exercise;

import db.Flashcard;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PuzzleTest {
    @Test
    public void solveExerciseShouldReturnCorrectValues(){
        Set<Flashcard> flashcardSet = new HashSet<>();
        Flashcard flashcard = new Flashcard("hello" , "ciao");
        flashcardSet.add(flashcard);
        String answerTrue = "1a";
        PuzzleMaker puzzleMaker = new PuzzleMaker();
        Exercise puzzleExercise = puzzleMaker.createExercise(flashcardSet);
        puzzleExercise.showExercise();
        List<Boolean> resultsTrue = puzzleExercise.solveExercise(answerTrue);

        Assert.assertTrue(resultsTrue.get(0));

        String answerFalse = "2b";
        List<Boolean> resultFalse = puzzleExercise.solveExercise(answerFalse);

        Assert.assertFalse(resultFalse.get(0));
    }
}
