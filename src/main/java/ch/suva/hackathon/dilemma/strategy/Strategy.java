package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;

public interface Strategy {
    Decision decide(List<Result> results, boolean isPlayerA);

    String getID();
}
