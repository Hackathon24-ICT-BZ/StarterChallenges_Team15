package ch.suva.hackathon.dilemma.model;

import ch.suva.hackathon.dilemma.strategy.Strategy;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stage {
    private final List<Strategy> population = new ArrayList<>();
    private final int rounds;
    private List<Strategy> winners;

    public Stage(List<Strategy> candidates, int rounds) {
        this.rounds = rounds;
        population.addAll(List.copyOf(candidates));
        population.addAll(List.copyOf(candidates));
        Collections.shuffle(population);
    }

    public void evaluate() {
        var pairings = new ArrayList<Pair<Strategy, Strategy>>();
        this.winners = new ArrayList<>();
        for (int i = 0; i < population.size(); i += 2) {
            pairings.add(new Pair<>(population.get(i), population.get(i + 1)));
        }
        pairings.forEach(pair -> {
            var run = new Run(pair.getFirst(), pair.getSecond(), rounds);
            var results = run.run();
            var scoreFirst = results.stream().mapToInt(Result::getScoreA).sum();
            var scoreSecond = results.stream().mapToInt(Result::getScoreB).sum();
//            System.out.println(pair.getFirst().getID() + " " + scoreFirst + " VS " + scoreSecond + " " + pair.getSecond().getID());
            winners.add(scoreFirst >= scoreSecond ? pair.getFirst() : pair.getSecond());
        });
    }

    public List<Strategy> getWinners() {
        return winners;
    }
}
