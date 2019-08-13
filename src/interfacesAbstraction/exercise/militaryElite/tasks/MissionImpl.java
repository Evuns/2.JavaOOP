package interfacesAbstraction.exercise.militaryElite.tasks;

import interfacesAbstraction.exercise.militaryElite.enums.State;
import interfacesAbstraction.exercise.militaryElite.interfaces.Mission;

public class MissionImpl implements Mission {

    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }



    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(),
                this.getState().toString());
    }
}
