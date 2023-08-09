package exercise;

import db.Flashcard;

import java.util.*;

public class Puzzle extends Exercise {

    private List<String> wordsEN;
    private List<String> wordsIT;

    public Puzzle(Collection<Flashcard> flashcards){
        super(flashcards);
    }

    @Override
    public String showExercise() {
        wordsEN = new ArrayList<>(exerciseFlashcards.stream().map(Flashcard::getWordEN).toList());
        wordsIT = new ArrayList<>(exerciseFlashcards.stream().map(Flashcard::getWordIT).toList());
        Collections.shuffle(wordsEN);
        Collections.shuffle(wordsIT);
        List<String> puzzleWords = new ArrayList<>();
        for(int i = 0; i < wordsEN.size(); i++){
            puzzleWords.add(wordsEN.get(i) + "-" + wordsIT.get(i));
        }
        return String.join(",", puzzleWords);
    }

    @Override
    public List<Boolean> solveExercise(String answer) {
        List<Boolean> results = new ArrayList<>();
        List<String> answers = List.of(answer.split(","));
        for(String ans:answers){
            char ans1 = ans.charAt(0);
            char ans2 = ans.charAt(1);
            int ans1Index = Integer.parseInt(String.valueOf(ans1)) - 1;
            int ans2Index = ans2 - 97;
            try{
                String ans1Word = wordsEN.get(ans1Index);
                String ans2Word = wordsIT.get(ans2Index);
                Optional<Flashcard> flashcard = exerciseFlashcards.stream().filter
                        (f -> f.getWordEN().equals(ans1Word)).findFirst();
                if(flashcard.isPresent()){
                    results.add(ans2Word.equals(flashcard.get().getWordIT()));
                }else{
                    results.add(false);
                }
            }catch (IndexOutOfBoundsException e) {
                results.add(false);
            }
        }
        return results;
    }
}
