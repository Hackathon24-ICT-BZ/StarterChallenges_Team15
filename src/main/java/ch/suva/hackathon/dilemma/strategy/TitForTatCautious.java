package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;

public class TitForTatCautious implements Strategy {
    @Override
    public Decision decide(List<Result> results, boolean isPlayerA) {
        if (results.isEmpty()) {
            return Decision.DEFECT;
        }
        var lasteResult = results.getLast();
        return isPlayerA ? lasteResult.getDecisionB() : lasteResult.getDecisionA();
    }

    @Override
    public String getID() {
        return "titForTatCautious";
    }
}
