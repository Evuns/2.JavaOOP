package reflection.excercise.barracksWarsDependencyInjection.core.commands;

import reflection.excercise.barracksWarsDependencyInjection.anotations.Inject;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Repository;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Unit;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute(){
        String unitType = this.getData()[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		return unitType + " added!";
    }
}
