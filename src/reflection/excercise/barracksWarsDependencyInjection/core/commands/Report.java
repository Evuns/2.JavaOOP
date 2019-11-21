package reflection.excercise.barracksWarsDependencyInjection.core.commands;

import reflection.excercise.barracksWarsDependencyInjection.anotations.Inject;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute(){
        String output = this.repository.getStatistics();
        return output;
    }
}
