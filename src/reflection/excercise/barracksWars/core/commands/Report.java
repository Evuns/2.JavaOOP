package reflection.excercise.barracksWars.core.commands;

import reflection.excercise.barracksWars.interfaces.Repository;
import reflection.excercise.barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        String output = this.getRepository().getStatistics();
        return output;
    }
}
