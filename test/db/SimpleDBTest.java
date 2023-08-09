package db;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SimpleDBTest {

    @Test
    public void addNewFlashcardShouldAddFlashcardToTrainingDB(){
        SimpleDB db = new SimpleDB();
        Flashcard flashcard = new Flashcard("hello", "ciao");
        db.addNewFlashcard(flashcard);
        Set<Flashcard> set = db.getTrainingFlashcards();
        Assert.assertEquals(1, set.size());
        Assert.assertEquals(flashcard, set.stream().findFirst().get());
    }

    @Test
    public void deleteFlashcardShouldDeleteFlashcardFromDB(){
        SimpleDB db = new SimpleDB();
        Flashcard flashcard = new Flashcard("hello", "ciao");
        db.addNewFlashcard(flashcard);
        Set<Flashcard> set = db.getTrainingFlashcards();
        Assert.assertEquals(1, set.size());
        db.deleteFlashcard(flashcard);
        Set<Flashcard> set2 = db.getTrainingFlashcards();
        Assert.assertEquals(0, set2.size());
    }

    @Test
    public void moveFlashcardShouldMoveFlashcardToOtherDB(){
        SimpleDB db = new SimpleDB();
        Flashcard flashcard = new Flashcard("hello", "ciao");
        db.addNewFlashcard(flashcard);
        Set<Flashcard> set = db.getTrainingFlashcards();
        Assert.assertEquals(1, set.size());
        Set<Flashcard> set2 = db.getLearnedFlashcards();
        Assert.assertEquals(0, set2.size());
        db.moveFlashcard(flashcard);
        set = db.getTrainingFlashcards();
        set2 = db.getLearnedFlashcards();
        Assert.assertEquals(0, set.size());
        Assert.assertEquals(1, set2.size());
    }
}
