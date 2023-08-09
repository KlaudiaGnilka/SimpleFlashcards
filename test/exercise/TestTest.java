package exercise;

import db.Flashcard;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTest {
    @Test
    public void solveExerciseShouldReturnCorrectValues(){
        Set<Flashcard> flashcardSet = new HashSet<>();
        flashcardSet.add(new Flashcard("hello", "ciao"));

        TestMaker testMaker = new TestMaker();
        String answerTrue = "ciao";
        Exercise exercise = testMaker.createExercise(flashcardSet);
        exercise.showExercise();
        List<Boolean> resultsTrue = exercise.solveExercise(answerTrue);

        Assert.assertTrue(resultsTrue.get(0));

        String answerFalse = "buon giorno";
        List<Boolean> resultsFalse = exercise.solveExercise(answerFalse);

        Assert.assertFalse(resultsFalse.get(0));
    }
}
