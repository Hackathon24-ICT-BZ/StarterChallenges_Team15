package ch.suva.hackathon.dilemma.strategy;

import ch.suva.hackathon.dilemma.model.Decision;
import ch.suva.hackathon.dilemma.model.Result;

import java.util.List;
import java.util.Random;

public class TotallyRandom implements Strategy {
    private final Random random = new Random();
    @Override
    public Decision decide(List<Result> results, boolean isPlayerA) {
        return random.nextBoolean()?Decision.COOPERATE:Decision.DEFECT;
    }

    @Override
    public String getID() {
        return "totallyRandom";
    }
}
