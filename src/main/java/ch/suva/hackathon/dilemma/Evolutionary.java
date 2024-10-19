package ch.suva.hackathon.dilemma;

import ch.suva.hackathon.dilemma.model.Stage;
import ch.suva.hackathon.dilemma.strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Evolutionary {
    public static void main(String[] args) {
        var evolutionary = new Evolutionary();
        evolutionary.run();
    }

    public void run() {
        var numberOfStages = 5;
        var allCandidates = prepareStrategies();
        final var population = new ArrayList<Strategy>();
        IntStream.rangeClosed(1, 5).forEach(number -> population.addAll(allCandidates));
        System.out.println("Initial population:");
        printPopulation(population);
        for (int i = 1; i <= numberOfStages; i++) {
            var stage = new Stage(population, 20);
            stage.evaluate();
            population.clear();
            population.addAll(stage.getWinners());
            System.out.println("=============================================");
            System.out.println("Survivors round " + i + ":");
            printPopulation(population);
        }

    }

    private List<Strategy> prepareStrategies() {
        return List.of(new AlwaysCooperate(), new AlwaysDefect(), new TitForTatNice(), new TitForTatCautious(), new TitForTatNiceForgiving(), new TitForTatCautiousForgiving(), new TotallyRandom(), new TitForTatRandomStart());
    }

    public void printPopulation(List<Strategy> population) {
        population.stream().collect(Collectors.groupingBy(Strategy::getID, Collectors.counting())).forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
