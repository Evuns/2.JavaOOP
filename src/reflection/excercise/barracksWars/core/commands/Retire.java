package reflection.excercise.barracksWars.core.commands;

import reflection.excercise.barracksWars.interfaces.Repository;
import reflection.excercise.barracksWars.interfaces.UnitFactory;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        this.getRepository().removeUnit(this.getData()[1]);
        return "";
    }
}
