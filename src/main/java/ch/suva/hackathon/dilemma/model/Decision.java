package ch.suva.hackathon.dilemma.model;

public enum Decision {
    COOPERATE("cooperates"), DEFECT("defects");
    final String verb;

    Decision(String verb) {
        this.verb = verb;
    }
}
