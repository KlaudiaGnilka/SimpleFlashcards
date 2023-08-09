package db;

import java.util.List;

public class Statistics {
    private int level;
    private int score;

    private static final int TEN_POINTS_THRESHOLD = 100;
    private static final int SIX_POINTS_THRESHOLD = 80;
    private static final int FOUR_POINTS_THRESHOLD = 50;
    private static final int ONE_POINT_THRESHOLD = 30;

    public Statistics(){
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public void recalculateResultsToScore(List<Boolean> results){
        int trueAnswers = (int) results.stream().filter(r -> r.equals(true)).count();
        int allAnswers = results.size();
        int percentage = (int) Math.round(((double) trueAnswers/(double) allAnswers)*100);
        int points = 0;
        if(percentage == TEN_POINTS_THRESHOLD){
            points = 10;
        }else if(percentage >= SIX_POINTS_THRESHOLD){
            points = 6;
        }else if(percentage >= FOUR_POINTS_THRESHOLD){
            points = 4;
        }else if(percentage >= ONE_POINT_THRESHOLD){
            points = 1;
        }
        score += points;
        checkForLevelUp();
    }

    private void checkForLevelUp(){
        if(score == 100){
            level += 1;
            score = 0;
        }
    }
}
