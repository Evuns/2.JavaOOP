package interfacesAbstraction.exercise.militaryElite.commands;

import interfacesAbstraction.exercise.militaryElite.tasks.SoldierFactory;
import interfacesAbstraction.exercise.militaryElite.interfaces.Soldier;

import java.util.List;

public class CommandoCommand extends BaseCommand {
    public CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceCommando(args));
    }
}
