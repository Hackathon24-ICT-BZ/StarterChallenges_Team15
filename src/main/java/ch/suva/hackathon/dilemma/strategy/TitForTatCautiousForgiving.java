package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;

public class TitForTatCautiousForgiving implements Strategy {
    @Override
    public Decision decide(List<Result> results, boolean isPlayerA) {
        if (results.isEmpty()) {
            return Decision.COOPERATE;
        } else if (results.size() == 1) {
            var lasteResult = results.getLast();
            return isPlayerA ? lasteResult.getDecisionB() : lasteResult.getDecisionA();
        }
        return results.stream().map(result -> {
            if (isPlayerA) {
                return result.getDecisionB();
            } else {
                return result.getDecisionA();
            }
        }).skip(results.size() - 2).allMatch(decision -> Decision.DEFECT == decision) ? Decision.DEFECT : Decision.COOPERATE;
    }

    @Override
    public String getID() {
        return "titForTatCautiousForgiving";
    }
}
