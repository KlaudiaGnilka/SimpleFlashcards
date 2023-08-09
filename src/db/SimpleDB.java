package db;

import db.DBController;
import db.Flashcard;
import exceptions.FlashcardNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SimpleDB implements DBController {
    private final Set<Flashcard> learnedFlashcards;
    private final Set<Flashcard> trainingFlashcards;
    private final Statistics statistics;

    public SimpleDB() {
        learnedFlashcards = new HashSet<>();
        trainingFlashcards = new HashSet<>();
        statistics = new Statistics();
    }

    @Override
    public void addNewFlashcard(Flashcard flashcard) {
       trainingFlashcards.add(flashcard);
    }

    @Override
    public void deleteFlashcard(Flashcard flashcard) {
        learnedFlashcards.remove(flashcard);
        trainingFlashcards.remove(flashcard);
    }

    @Override
    public void moveFlashcard(Flashcard flashcard) {
        if(learnedFlashcards.contains(flashcard)){
            learnedFlashcards.remove(flashcard);
            trainingFlashcards.add(flashcard);
        }else if(trainingFlashcards.contains(flashcard)) {
            trainingFlashcards.remove(flashcard);
            learnedFlashcards.add(flashcard);
        }else{
            throw new FlashcardNotFoundException("Flashcard not found: " + flashcard);
        }
    }

    @Override
    public Set<Flashcard> getLearnedFlashcards() {
        return learnedFlashcards;
    }

    @Override
    public Set<Flashcard> getTrainingFlashcards() {
        return trainingFlashcards;
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public void updateStatistics(List<Boolean> results) {
        statistics.recalculateResultsToScore(results);
    }

}
