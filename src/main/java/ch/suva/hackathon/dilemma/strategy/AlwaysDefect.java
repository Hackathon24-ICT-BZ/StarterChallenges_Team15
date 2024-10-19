package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;

public class AlwaysDefect implements Strategy {
    @Override
    public String getID() {
        return "alwaysDefect";
    }

    @Override
    public Decision decide(List<Result> results, boolean isPlayerA) {
        return Decision.DEFECT;
    }
}
