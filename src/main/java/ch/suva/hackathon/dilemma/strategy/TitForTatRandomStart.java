package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;
import java.util.Random;

public class TitForTatRandomStart implements Strategy {
    @Override
    public Decision decide(List<Result> results, boolean isPlayerA) {
        if (results.isEmpty()) {
            return new Random().nextBoolean()?Decision.COOPERATE:Decision.DEFECT;
        }
        var lasteResult = results.getLast();
        return isPlayerA ? lasteResult.getDecisionB() : lasteResult.getDecisionA();
    }

    @Override
    public String getID() {
        return "titForTatRandomStart";
    }
}
