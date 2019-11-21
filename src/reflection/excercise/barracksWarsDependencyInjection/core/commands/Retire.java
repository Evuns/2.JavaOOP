package reflection.excercise.barracksWarsDependencyInjection.core.commands;

import reflection.excercise.barracksWarsDependencyInjection.anotations.Inject;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;
    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute(){
        this.repository.removeUnit(this.getData()[1]);
        return "";
    }
}
