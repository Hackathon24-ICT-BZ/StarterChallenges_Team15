package ch.suva.hackathon.dilemma;

import ch.suva.hackathon.dilemma.model.Result;
import ch.suva.hackathon.dilemma.model.Run;
import ch.suva.hackathon.dilemma.strategy.*;
import org.apache.commons.math3.util.Combinations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyEvaluator {
    public static void main(String[] args) {
        var evaluator = new StrategyEvaluator();
        evaluator.run();
    }

    public void run() {
        var rounds = 20;
        var strategies = prepareStrategies();
        var combinations = new Combinations(strategies.size(), 2);
        var scores = new HashMap<String, Integer>();
        combinations.forEach(indexArray -> {
            var strategyA = strategies.get(indexArray[0]);
            var strategyB = strategies.get(indexArray[1]);
            var run = new Run(strategyA, strategyB, rounds);
            var results = run.run();
            var scoreA = scores.getOrDefault(strategyA.getID(), 0);
            var scoreB = scores.getOrDefault(strategyB.getID(), 0);
            scores.put(strategyA.getID(), scoreA + results.stream().mapToInt(Result::getScoreA).sum());
            scores.put(strategyB.getID(), scoreB + results.stream().mapToInt(Result::getScoreB).sum());
        });
        scores.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private List<Strategy> prepareStrategies() {
        return List.of(new AlwaysCooperate(), new AlwaysDefect(), new TitForTatNice(), new TitForTatCautious(), new TitForTatNiceForgiving(), new TitForTatCautiousForgiving(),new TotallyRandom(),new TitForTatRandomStart());
    }
}
