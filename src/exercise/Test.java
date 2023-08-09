package exercise;

import db.Flashcard;

import java.util.*;
import java.util.stream.Collectors;

public class Test extends Exercise{
    public Test(Collection<Flashcard> flashcards) {
        super(flashcards);
    }

    @Override
    public String showExercise() {
        return exerciseFlashcards.stream().map(Flashcard::getWordEN).collect(Collectors.joining(","));
    }

    @Override
    public List<Boolean> solveExercise(String answer) {
        List<String> answers = List.of(answer.split(","));
        List<String> correctAnswers = exerciseFlashcards.stream().map(Flashcard::getWordIT).toList();
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < answers.size(); i++){
            results.add(answers.get(i).equals(correctAnswers.get(i)));
        }
        return results;
    }


}
