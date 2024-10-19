package ch.suva.hackathon.dilemma.model;

public class Result {
    private final Decision decisionA;
    private final Decision decisionB;

    public Result(Decision decisionA, Decision decisionB) {
        this.decisionA = decisionA;
        this.decisionB = decisionB;
    }

    public Decision getDecisionA() {
        return decisionA;
    }

    public Decision getDecisionB() {
        return decisionB;
    }

    public int getScoreA() {
        return getScore(decisionA, decisionB);
    }

    public int getScoreB() {
        return getScore(decisionB, decisionA);
    }

    private int getScore(Decision a, Decision b){
        if (a == Decision.COOPERATE && b == Decision.COOPERATE) {
            return 1;
        } else if (a == Decision.COOPERATE && b == Decision.DEFECT) {
            return 3;
        } else if (a ==Decision.DEFECT && b == Decision.COOPERATE) {
            return 0;
        } else {
            return 2;
        }
    }

    @Override
    public String toString() {
        return "Player A "+ decisionA.verb +
                ", player B " + decisionB.verb;
    }
}
