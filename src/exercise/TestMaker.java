package exercise;

import db.Flashcard;


import java.util.*;

public class TestMaker implements ExerciseMaker {
    @Override
    public Exercise createExercise(Set<Flashcard> set) {
        List<Flashcard> testFlashcards = new ArrayList<>(set);
        if(set.size() > 10){
            Collections.shuffle(testFlashcards);
            return new Test(testFlashcards.subList(0,10));
        }else{
            return new Test(testFlashcards);
        }
    }
}
