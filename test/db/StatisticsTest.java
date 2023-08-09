package db;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {

    @Test
    public void recalculateResultsToScoreShouldChangeValuesCorrectly(){
        List<Boolean> results = new ArrayList<>();
        results.add(true);
        results.add(true);
        results.add(false);
        results.add(true);
        results.add(false);
        Statistics statistics = new Statistics();
        for(int i = 0; i < 30; i++){
            statistics.recalculateResultsToScore(results);
        }

        Assert.assertEquals(20, statistics.getScore());
        Assert.assertEquals(1, statistics.getLevel());
    }
}
