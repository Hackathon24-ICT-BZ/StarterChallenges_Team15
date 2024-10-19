package ch.suva.hackathon.dilemma.model;

import ch.suva.hackathon.dilemma.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Run {
    private final Strategy strategyA;
    private final Strategy strategyB;
    private final int rounds;
    private final List<Result> results = new ArrayList<>();

    public Run(Strategy strategyA, Strategy strategyB, int rounds) {
        this.strategyA = strategyA;
        this.strategyB = strategyB;
        this.rounds = rounds;
    }

    public List<Result> run() {
        for (int i = 0; i < rounds; i++) {
            var decisionA = strategyA.decide(results, true);
            var decisionB = strategyB.decide(results, false);
            results.add(new Result(decisionA, decisionB));
        }
        return results;
    }

    @Override
    public String toString() {
        return rounds + " rounds " + strategyA.getID() + " VS " + strategyB.getID() + "\n"
                + results.stream().map(Result::toString).collect(Collectors.joining("\n"))
                + "Final score:\n"
                + results.stream().map(Result::getScoreA).mapToInt(Integer::intValue).sum() + " : " + results.stream().map(Result::getScoreB).mapToInt(Integer::intValue).sum();
    }
}

