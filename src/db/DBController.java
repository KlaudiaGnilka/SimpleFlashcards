package db;

import java.util.List;
import java.util.Set;

public interface DBController {
    void addNewFlashcard(Flashcard flashcard);

    void deleteFlashcard(Flashcard flashcard);

    void moveFlashcard(Flashcard flashcard);

    Set<Flashcard> getLearnedFlashcards();

    Set<Flashcard> getTrainingFlashcards();

    Statistics getStatistics();

    void updateStatistics(List<Boolean> results);
}
