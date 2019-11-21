package reflection.excercise.barracksWars.core.commands;

import reflection.excercise.barracksWars.interfaces.Repository;
import reflection.excercise.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        return "fight";
    }
}
