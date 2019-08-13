package interfacesAbstraction.exercise.militaryElite.soldiers;

import interfacesAbstraction.exercise.militaryElite.tasks.SolderImpl;
import interfacesAbstraction.exercise.militaryElite.interfaces.Spy;

public class SpyImpl extends SolderImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator()
                + "Code Number: " + this.getCodeNumber();
    }

}
