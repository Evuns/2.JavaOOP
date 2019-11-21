package reflection.excercise.barracksWarsDependencyInjection.core.commands;

import reflection.excercise.barracksWarsDependencyInjection.interfaces.Executable;

public abstract class Command implements Executable {

    private String [] data;

    public Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }


}
