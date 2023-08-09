package exercise;

import db.Flashcard;

import java.util.Set;

public interface ExerciseMaker {
    Exercise createExercise(Set<Flashcard> set);
}
