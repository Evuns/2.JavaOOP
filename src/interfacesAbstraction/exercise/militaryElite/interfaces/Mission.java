package interfacesAbstraction.exercise.militaryElite.interfaces;

import interfacesAbstraction.exercise.militaryElite.enums.State;

public interface Mission {

    void completeMission();
    String getCodeName();
    State getState();

}
