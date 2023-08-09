package engine;

import db.Flashcard;
import db.SimpleDB;
import db.Statistics;
import exercise.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EngineAppSimple implements EngineApp {
    Scanner sc = new Scanner(System.in);
    SimpleDB db = new SimpleDB();
    private List<Flashcard> filteredFlashcards;

    boolean x = true;


    @Override
    public void start() {
        while (x) {
            System.out.println("Choose option");
            System.out.println("1 - Add new flashcard");
            System.out.println("2 - Delete flashcard");
            System.out.println("3 - Move flashcard");
            System.out.println("4 - Learning - Puzzle");
            System.out.println("5 - Test - learning flashcard");
            System.out.println("6 - Test - repeat learned flashcard");
            System.out.println("7 - Get statistics");
            System.out.println("8 - Turn off program");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter new flashcard (EN --- IT)");
                    String wordEN = sc.nextLine();
                    String wordIT = sc.nextLine();
                    db.addNewFlashcard(new Flashcard(wordEN, wordIT));
                    System.out.println("Flashcard added successfully");
                }
                case 2 -> {
                    System.out.println("Enter flashcard witch one do you want delete (EN)");
                    String wordEN = sc.nextLine();
                    AtomicInteger i = new AtomicInteger(1);
                    filterFlashcards(wordEN).forEach(word -> System.out.println(i.getAndIncrement() + ". " + word));
                    int index = sc.nextInt();
                    index -= 1;
                    db.deleteFlashcard(filteredFlashcards.get(index));
                    System.out.println("Flashcard has been remove");
                }
                case 3 -> {
                    System.out.println("Witch one flashcard do you want move to other group (EN --- IT)");
                    String wordEN = sc.nextLine();
                    AtomicInteger i = new AtomicInteger(1);
                    filterFlashcards(wordEN).forEach(word -> System.out.println(i.getAndIncrement() + ". " + word));
                    int index = sc.nextInt();
                    index -= 1;
                    db.moveFlashcard(filteredFlashcards.get(index));
                    System.out.println("Flashcard moved successfully");
                }
                case 4 -> {
                    System.out.println("Puzzle:");
                    PuzzleMaker puzzleMaker = new PuzzleMaker();
                    Exercise puzzleMakerExercise = puzzleMaker.createExercise(db.getTrainingFlashcards());
                    String exercise = puzzleMakerExercise.showExercise();
                    formatPuzzleExercise(exercise);
                    System.out.println("Enter your answer (0x,...)");
                    String answers = sc.nextLine();
                    List<Boolean> results = puzzleMakerExercise.solveExercise(answers);
                    System.out.println(results);
                    db.updateStatistics(results);
                }
                case 5 -> {
                    System.out.println("Test - training");
                    TestMaker testMaker = new TestMaker();
                    Exercise testMakerExercise = testMaker.createExercise(db.getTrainingFlashcards());
                    String exercise = testMakerExercise.showExercise();
                    List<Boolean> results = testMakerExercise.solveExercise(formatTestExercise(exercise));
                    System.out.println(results);
                    db.updateStatistics(results);

                }
                case 6 -> {
                    System.out.println("Test - learned");
                    TestMaker testMaker = new TestMaker();
                    Exercise testMakerExercise = testMaker.createExercise(db.getLearnedFlashcards());
                    String exercise = testMakerExercise.showExercise();
                    List<Boolean> results = testMakerExercise.solveExercise(formatTestExercise(exercise));
                    System.out.println(results);
                    db.updateStatistics(results);
                }
                case 7 -> {
                    Statistics statistics = db.getStatistics();
                    int level = statistics.getLevel();
                    int score = statistics.getScore();
                    System.out.println("Your level: " + level);
                    System.out.println("Your score: " + score);

                }
                case 8 -> {
                    System.out.println("The program has been disabled");
                    x = false;
                }
                default -> System.out.println("Wrong option");
            }
        }
    }

    private void formatPuzzleExercise(String exercise){
        List<String> puzzle = List.of(exercise.split(","));
        char[] index = new char[]{'a', 'b', 'c', 'd', 'e'};
        for(int i = 0; i < puzzle.size(); i++){
            String[] words = puzzle.get(i).split("-");
            String wordEN = words[0];
            String wordIT = words[1];
            System.out.println(i+1 + ". " + wordEN + "      " + index[i] + ". " + wordIT);
        }
    }

    private String formatTestExercise(String exercise){
        List<String> test = List.of(exercise.split(","));
        String answers = "";
        for(int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
            String wordIT = sc.nextLine();
            answers += (wordIT + ",");
        }
        return answers;
    }



    private List<Flashcard> filterFlashcards(String wordEN){
        List<Flashcard> allFlashcards = new ArrayList<>();
        allFlashcards.addAll(db.getTrainingFlashcards());
        allFlashcards.addAll(db.getLearnedFlashcards());
        filteredFlashcards = allFlashcards.stream().filter(flashcard ->
                flashcard.getWordEN().equals(wordEN)).toList();
        return filteredFlashcards;
    }
}