package reflection.excercise.barracksWars.core.commands;

import reflection.excercise.barracksWars.interfaces.Repository;
import reflection.excercise.barracksWars.interfaces.Unit;
import reflection.excercise.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        String unitType = this.getData()[1];
		Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
		this.getRepository().addUnit(unitToAdd);
		return unitType + " added!";
    }
}
