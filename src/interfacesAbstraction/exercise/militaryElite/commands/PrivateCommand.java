package interfacesAbstraction.exercise.militaryElite.commands;

import interfacesAbstraction.exercise.militaryElite.tasks.SoldierFactory;
import interfacesAbstraction.exercise.militaryElite.interfaces.Soldier;

import java.util.List;

public class PrivateCommand extends BaseCommand {

    public PrivateCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}
