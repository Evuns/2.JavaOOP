package interfacesAbstraction.exercise.militaryElite.enums;

public enum State {
    INPROGRESS,
    FINISHED;

    @Override
    public String toString() {
        return super.toString().equals("INPROGRESS") ? "inProgress" : "finished";
    }
}
